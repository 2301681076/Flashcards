package com.example.flashcards

data class Deck(
    val id: String,
    val name: String,
    val cards: List<Flashcard> = emptyList()
)