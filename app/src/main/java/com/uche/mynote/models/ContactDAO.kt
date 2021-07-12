package com.uche.mynote.models

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ContactDAO {
    @Query("SELECT * FROM contact_table")
    fun getAllContacts() : List<Contact>

    @Query("SELECT * FROM contact_table WHERE id = :id")
    fun getContactById(id: Int): Contact

    @Insert
    fun addContact(contact: Contact)

    @Delete
    fun deleteContact(contact: Contact)
}