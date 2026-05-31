package com.example.flashcards

data class Flashcard(
    val id: String,
    val question: String,
    val answer: String,
    var isFrontVisible: Boolean = true
)