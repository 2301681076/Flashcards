package com.example.flashcards

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.flashcards.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: DeckAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dummyDecks = listOf(
            Deck("1", "Английски думи", listOf(Flashcard("1", "Apple", "Ябълка"))),
            Deck("2", "История", listOf(Flashcard("2", "1396 г.", "Падане под османско робство"))),
            Deck("3", "География", emptyList())
        )

        adapter = DeckAdapter(dummyDecks) { deck ->
            val intent = Intent(this, CardsActivity::class.java)
            startActivity(intent)
        }

        binding.rvDecks.layoutManager = LinearLayoutManager(this)
        binding.rvDecks.adapter = adapter

        binding.fabAddDeck.setOnClickListener {
            val intent = Intent(this, CardsActivity::class.java)
            startActivity(intent)
        }
    }
}