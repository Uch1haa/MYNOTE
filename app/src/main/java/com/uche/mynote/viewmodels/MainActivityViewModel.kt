package com.uche.mynote.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.room.Room
import com.uche.mynote.models.Note
import com.uche.mynote.models.NoteDatabase

class MainActivityViewModel : ViewModel() {
    private lateinit var database: NoteDatabase

    val notesLiveData = MutableLiveData<List<Note>>()

    init {

    }

    fun getNotes(database: NoteDatabase){
        notesLiveData.postValue(database.noteDao().getAllNotes())
    }
    fun addNote(database: NoteDatabase,note: Note){
        database.noteDao().addNote(note)
        getNotes(database)
    }
}