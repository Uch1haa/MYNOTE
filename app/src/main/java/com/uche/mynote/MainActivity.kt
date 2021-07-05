package com.uche.mynote

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import com.uche.mynote.databinding.ActivityMainBinding
import com.uche.mynote.models.Note
import com.uche.mynote.models.NoteDatabase

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var database: NoteDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        database = Room.databaseBuilder(
            applicationContext,
            NoteDatabase::class.java,
            "notes_database"
        ).build()
    }
    private fun saveNote(tittle: String, content: String){
        val note = Note(id = 0, tittle, content)
    }
}