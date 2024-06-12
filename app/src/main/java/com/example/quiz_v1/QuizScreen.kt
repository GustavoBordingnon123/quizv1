package com.example.quiz_v1

import android.widget.Toast
import androidx.compose.animation.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun QuizScreen(navController: NavController, questions: List<Question>, userName: String) {
    var currentQuestionIndex by remember { mutableStateOf(0) }
    var correctAnswers by remember { mutableStateOf(0) }
    var totalQuestionsAnswered by remember { mutableStateOf(0) }
    var selectedOption by remember { mutableStateOf<String?>(null) }
    var isAnswered by remember { mutableStateOf(false) }

    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AnimatedContent(
            targetState = currentQuestionIndex,
            transitionSpec = {
                slideInHorizontally { width -> width } + fadeIn() with
                        slideOutHorizontally { width -> -width } + fadeOut()
            }
        ) { index ->
            val question = questions[index]

            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = question.text, style = MaterialTheme.typography.h5)
                Image(painter = painterResource(id = question.imageRes), contentDescription = null)
                question.options.forEach { option ->
                    Button(
                        onClick = {
                            if (!isAnswered) {
                                selectedOption = option
                                isAnswered = true
                                totalQuestionsAnswered++
                                if (option == question.correctAnswer) {
                                    correctAnswers++
                                    // Dispara o alerta de acerto
                                    Toast.makeText(context, "Acertou!", Toast.LENGTH_SHORT).show()
                                }
                            }
                        },
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = if (selectedOption == option) Color.White else MaterialTheme.colors.primary
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    ) {
                        Text(text = option)
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            if (currentQuestionIndex < questions.size - 1) {
                currentQuestionIndex++
                isAnswered = false
                selectedOption = null
            } else {
                navController.navigate("leaderboard/$userName/$correctAnswers/$totalQuestionsAnswered")
            }
        }) {
            Text(text = "Próxima Pergunta")
        }
    }
}
