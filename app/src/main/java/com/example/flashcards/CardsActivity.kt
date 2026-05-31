package com.example.flashcards

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.flashcards.databinding.ActivityCardsBinding
import java.util.UUID

class CardsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCardsBinding
    private var isShowingQuestion = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCardsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.cardAnswer.visibility = View.GONE
        binding.cardQuestion.visibility = View.VISIBLE

        binding.cardQuestion.setOnClickListener { flipCard() }
        binding.cardAnswer.setOnClickListener { flipCard() }

        binding.btnBack.setOnClickListener {
            finish()
        }

        binding.btnSaveCard.setOnClickListener {
            saveFlashcard()
        }
    }

    private fun flipCard() {
        if (isShowingQuestion) {
            binding.cardQuestion.visibility = View.GONE
            binding.cardAnswer.visibility = View.VISIBLE
        } else {
            binding.cardAnswer.visibility = View.GONE
            binding.cardQuestion.visibility = View.VISIBLE
        }
        isShowingQuestion = !isShowingQuestion
    }

    private fun saveFlashcard() {
        val questionText = binding.etQuestion.text.toString().trim()
        val answerText = binding.etAnswer.text.toString().trim()

        if (questionText.isEmpty() || answerText.isEmpty()) {
            Toast.makeText(this, "Моля, попълнете и двете полета!", Toast.LENGTH_SHORT).show()
            return
        }

        val newCard = Flashcard(
            id = UUID.randomUUID().toString(),
            question = questionText,
            answer = answerText
        )

        Toast.makeText(this, "Картата е запазена успешно!", Toast.LENGTH_SHORT).show()
        finish()
    }
}