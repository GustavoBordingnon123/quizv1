package com.example.quiz_v1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.quizapp.ui.theme.QuizAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuizAppTheme {
                Navigation()
            }
        }
    }
}

@Composable
fun Navigation() {
    val navController = rememberNavController()
    val shuffledQuestions = remember { shuffleQuestions(sampleQuestions) }

    NavHost(navController = navController, startDestination = "enter_name") {
        composable("enter_name") { EnterNameScreen(navController) }
        composable("menu/{userName}") { backStackEntry ->
            val userName = backStackEntry.arguments?.getString("userName") ?: "User"
            MenuScreen(navController, userName)
        }
        composable("quiz/{userName}") { backStackEntry ->
            val userName = backStackEntry.arguments?.getString("userName") ?: "User"
            QuizScreen(navController, shuffledQuestions, userName)
        }
        composable("leaderboard/{userName}/{correctAnswers}/{totalQuestionsAnswered}") { backStackEntry ->
            val userName = backStackEntry.arguments?.getString("userName") ?: "User"
            val correctAnswers = backStackEntry.arguments?.getString("correctAnswers")?.toInt() ?: 0
            val totalQuestionsAnswered = backStackEntry.arguments?.getString("totalQuestionsAnswered")?.toInt() ?: 0
            LeaderboardScreen(navController, userName, correctAnswers, totalQuestionsAnswered)
        }
    }
}


fun shuffleQuestions(questions: List<Question>): List<Question> {
    return questions.shuffled().map { question ->
        question.copy(options = question.options.shuffled())
    }
}
