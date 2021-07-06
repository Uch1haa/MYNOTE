package com.uche.mynote.models

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.uche.mynote.databinding.NoteItemBinding

class NoteAdapter(val notes: List<Note>): RecyclerView.Adapter<NoteAdapter.NoteViewHolder>(){
    class NoteViewHolder(private val binding: NoteItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bindNote(note: Note){
            binding.apply{
                display.text = note.id.toString()
                tittleDisplay.text = note.tittle

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        var binding = NoteItemBinding.inflate(LayoutInflater.from(parent.context))
        return NoteViewHolder(binding)

    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val record = notes[position]
        holder.bindNote(record)

    }

    override fun getItemCount(): Int {
        return notes.size

    }
}