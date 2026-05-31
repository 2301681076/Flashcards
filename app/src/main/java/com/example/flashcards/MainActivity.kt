package com.example.flashcards

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.flashcards.databinding.ActivityMainBinding
import java.util.UUID

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: DeckAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (DataManager.decks.isEmpty()) {
            val defaultDeck = Deck(
                id = UUID.randomUUID().toString(),
                name = getString(R.string.default_deck_name),
                cards = mutableListOf(
                    Flashcard(UUID.randomUUID().toString(), "Persistent", "Упорит / Настойчив"),
                    Flashcard(UUID.randomUUID().toString(), "Anxious", "Тревожен / Загрижен"),
                    Flashcard(UUID.randomUUID().toString(), "Improve", "Подобрявам / Усъвършенствам"),
                    Flashcard(UUID.randomUUID().toString(), "Challenge", "Предизвикателство"),
                    Flashcard(UUID.randomUUID().toString(), "Opportunity", "Възможност"),
                    Flashcard(UUID.randomUUID().toString(), "Succeed", "Успявам"),
                    Flashcard(UUID.randomUUID().toString(), "Habit", "Навик"),
                    Flashcard(UUID.randomUUID().toString(), "Goal", "Цел")
                )
            )
            DataManager.decks.add(defaultDeck)
        }

        adapter = DeckAdapter(DataManager.decks) { deck ->
            val intent = Intent(this, CardsActivity::class.java)
            intent.putExtra("DECK_ID", deck.id)
            startActivity(intent)
        }

        binding.rvDecks.layoutManager = LinearLayoutManager(this)
        binding.rvDecks.adapter = adapter

        binding.fabAddDeck.setOnClickListener {
            showCreateDeckDialog()
        }
    }

    private fun showCreateDeckDialog() {
        val input = EditText(this)
        input.hint = getString(R.string.deck_hint)

        val container = FrameLayout(this)
        val params = FrameLayout.LayoutParams(
            FrameLayout.LayoutParams.MATCH_PARENT,
            FrameLayout.LayoutParams.WRAP_CONTENT
        )
        params.setMargins(45, 20, 45, 0)
        input.layoutParams = params
        container.addView(input)

        AlertDialog.Builder(this)
            .setTitle(getString(R.string.new_deck))
            .setMessage(getString(R.string.enter_deck_name))
            .setView(container)
            .setPositiveButton(getString(R.string.create)) { _, _ ->
                val deckName = input.text.toString().trim()
                if (deckName.isNotEmpty()) {
                    val newDeck = Deck(
                        id = UUID.randomUUID().toString(),
                        name = deckName,
                        cards = mutableListOf()
                    )
                    DataManager.decks.add(newDeck)
                    adapter.notifyDataSetChanged()
                    Toast.makeText(this, getString(R.string.deck_created), Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, getString(R.string.empty_name_error), Toast.LENGTH_SHORT).show()
                }
            }
            .setNegativeButton(getString(R.string.cancel), null)
            .show()
    }

    override fun onResume() {
        super.onResume()
        adapter.notifyDataSetChanged()
    }
}