package com.example.quiz_v1

import com.example.quiz.R

data class Question(
    val text: String,
    val imageRes: Int,
    val options: List<String>,
    val correctAnswer: String
)

data class Score(
    val name: String,
    val points: Int
)

val sampleQuestions = listOf(
    Question(
        text = "Qual é a capital do Brasil?",
        imageRes = R.drawable.brazil,
        options = listOf("Rio de Janeiro", "Brasília", "São Paulo", "Salvador"),
        correctAnswer = "Brasília"
    ),
    Question(
        text = "Qual é a capital da Rússia?",
        imageRes = R.drawable.russia,
        options = listOf("Moscou", "São Petersburgo", "Kazan", "Novosibirsk"),
        correctAnswer = "Moscou"
    ),
    Question(
        text = "Qual é a capital da China?",
        imageRes = R.drawable.china,
        options = listOf("Pequim", "Xangai", "Cantão", "Shenzhen"),
        correctAnswer = "Pequim"
    ),
    Question(
        text = "Qual é a capital do Japão?",
        imageRes = R.drawable.japan,
        options = listOf("Tóquio", "Osaka", "Kyoto", "Hiroshima"),
        correctAnswer = "Tóquio"
    ),
    Question(
        text = "Qual é a capital da Austrália?",
        imageRes = R.drawable.australia,
        options = listOf("Sydney", "Melbourne", "Brisbane", "Canberra"),
        correctAnswer = "Canberra"
    ),
    Question(
        text = "Qual é a capital do Canadá?",
        imageRes = R.drawable.canada,
        options = listOf("Toronto", "Vancouver", "Montreal", "Ottawa"),
        correctAnswer = "Ottawa"
    )
)

val sampleLeaderboard = listOf(
    Score(name = "Alice", points = 5),
    Score(name = "Bob", points = 4),
    Score(name = "Carol", points = 3)
)
