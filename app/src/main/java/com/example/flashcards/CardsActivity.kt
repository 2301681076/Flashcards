package com.example.flashcards

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.flashcards.databinding.ActivityCardsBinding

class CardsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCardsBinding
    private var currentDeck: Deck? = null
    private var currentCardIndex = 0
    private var isShowingQuestion = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCardsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val deckId = intent.getStringExtra("DECK_ID")
        currentDeck = DataManager.decks.find { it.id == deckId }

        if (currentDeck == null || currentDeck!!.cards.isEmpty()) {
            binding.tvQuestion.text = "Няма карти"
            binding.btnFlip.visibility = View.GONE
            binding.btnNextCard.visibility = View.GONE
            return
        }

        displayCard()

        binding.btnFlip.setOnClickListener {
            if (isShowingQuestion) {
                binding.tvQuestion.text = currentDeck!!.cards[currentCardIndex].answer
            } else {
                binding.tvQuestion.text = currentDeck!!.cards[currentCardIndex].question
            }
            isShowingQuestion = !isShowingQuestion
        }

        binding.btnNextCard.setOnClickListener {
            if (currentDeck!!.cards.isNotEmpty()) {
                currentCardIndex = (currentCardIndex + 1) % currentDeck!!.cards.size
                displayCard()
            }
        }
    }

    private fun displayCard() {
        binding.tvQuestion.text = currentDeck!!.cards[currentCardIndex].question
        isShowingQuestion = true
    }
}