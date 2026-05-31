package com.example.flashcards

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.flashcards.databinding.ItemDeckBinding

class DeckAdapter(
    private val decks: List<Deck>,
    private val onDeckClick: (Deck) -> Unit
) : RecyclerView.Adapter<DeckAdapter.DeckViewHolder>() {

    class DeckViewHolder(val binding: ItemDeckBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DeckViewHolder {
        val binding = ItemDeckBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DeckViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DeckViewHolder, position: Int) {
        val deck = decks[position]
        holder.binding.tvDeckName.text = deck.name
        holder.binding.tvCardCount.text = "${deck.cards.size} карти"

        holder.itemView.setOnClickListener {
            onDeckClick(deck)
        }
    }

    override fun getItemCount(): Int = decks.size
}