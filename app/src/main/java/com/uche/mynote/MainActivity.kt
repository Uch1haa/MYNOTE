package com.uche.mynote

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.uche.mynote.databinding.ActivityMainBinding
import com.uche.mynote.models.Note
import com.uche.mynote.models.NoteAdapter
import com.uche.mynote.models.NoteDatabase

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var database: NoteDatabase
    private lateinit var notesAdapter: NoteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        database = Room.databaseBuilder(
            applicationContext,
            NoteDatabase::class.java,
            "notes_database"
        ).allowMainThreadQueries().build()

        notesAdapter = NoteAdapter(database.noteDao().getAllNotes())
        binding.Recycler.apply{
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = notesAdapter
        }
        binding.button.setOnClickListener {
            val tittle = binding.tittle.text.toString()
            val content = binding.content.text.toString()

            saveNote(tittle, content)
        }
    }
    private fun saveNote(tittle: String, content: String){
        val note = Note(id = 0, tittle, content)
        database.noteDao().addNote(note)
        notesAdapter.notifyDataSetChanged()
    }
}