package com.example.quiz_v1

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun LeaderboardScreen(
    navController: NavController,
    userName: String,
    correctAnswers: Int,
    totalQuestionsAnswered: Int
) {
    // Atualize a pontuação do usuário atual
    val currentHighScore = highScores[userName] ?: 0
    val newHighScore = if (correctAnswers > currentHighScore) correctAnswers else currentHighScore
    highScores[userName] = newHighScore

    // Atualize a lista de leaderboard com as novas pontuações
    var updatedLeaderboard by remember { mutableStateOf(listOf<Score>()) }

    LaunchedEffect(Unit) {
        updatedLeaderboard = highScores.toList()
            .map { Score(it.first, it.second) }
            .sortedByDescending { it.points }
            .take(10)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Leaderboard", style = MaterialTheme.typography.h4)
        Spacer(modifier = Modifier.height(16.dp))
        updatedLeaderboard.forEach { score ->
            Text(text = "${score.name}: ${score.points}")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Você acertou $correctAnswers de $totalQuestionsAnswered questões.")
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            navController.navigate("enter_name")
        }) {
            Text(text = "Tentar Novamente")
        }
    }
}
