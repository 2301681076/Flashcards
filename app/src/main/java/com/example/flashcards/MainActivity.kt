package com.example.flashcards2025

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.flashcards2025.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.fabAddDeck.setOnClickListener {
        }
    }
}