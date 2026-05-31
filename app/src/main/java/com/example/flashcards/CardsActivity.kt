package com.example.flashcards

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.flashcards.databinding.ActivityCardsBinding

class CardsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCardsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCardsBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}