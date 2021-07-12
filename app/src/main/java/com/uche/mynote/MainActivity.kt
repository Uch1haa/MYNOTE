package com.uche.mynote

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.uche.mynote.activities.ContactDetailsActivity
import com.uche.mynote.databinding.ActivityMainBinding
import com.uche.mynote.models.Contact
import com.uche.mynote.models.ContactAdapter
import com.uche.mynote.models.ContactDatabase
import com.uche.mynote.viewmodels.MainActivityViewModel


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var database: ContactDatabase
    private lateinit var contactAdapter: ContactAdapter
    private lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//instantiating database
        database = Room.databaseBuilder(
            applicationContext,
            ContactDatabase::class.java,
            "contact_database"
        ).allowMainThreadQueries().build()

        //instantiating viewModel
        viewModel = ViewModelProvider(this)[MainActivityViewModel :: class.java]
        viewModel.getContacts(database)
        
        contactAdapter = ContactAdapter(listOf<Contact>()){
            val intent = Intent(this@MainActivity, ContactDetailsActivity:: class.java)
            intent.run{
                putExtra("id", it.id)
                putExtra("personName", it.personName)
                putExtra("phoneNo", it.phoneNo)
            }
            startActivity(intent)
        }
        binding.contactList.apply { 
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = contactAdapter
        }

        //observe live data from view model
        viewModel.contactsLiveData.observe(this,{ contact ->
            contactAdapter.contacts = contact
            contactAdapter.notifyDataSetChanged()
            
        })

        binding.createButton.setOnClickListener {
            val personName = binding.personName.text.toString()

            val phoneNo = binding.phoneNo.text.toString()

            saveContact(personName, phoneNo)
        }
    }
    private fun saveContact(personName: String,  phoneNo: String,){
        val contact = Contact(id = 0, personName,  phoneNo)
       viewModel.addContact(database, contact)
    }
}