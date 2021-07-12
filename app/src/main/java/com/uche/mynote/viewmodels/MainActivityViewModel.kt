package com.uche.mynote.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.uche.mynote.models.Contact
import com.uche.mynote.models.ContactDatabase

class MainActivityViewModel : ViewModel() {


    val contactsLiveData = MutableLiveData<List<Contact>>()

    fun getContacts(database: ContactDatabase){
        contactsLiveData.postValue(database.contactDao().getAllContacts())
    }
    fun addContact(database: ContactDatabase, contact: Contact){
        database.contactDao().addContact(contact)
        getContacts(database)
    }
}