package com.uche.mynote.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.uche.mynote.databinding.ActivityNotedetailsBinding



class ContactDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNotedetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNotedetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.run{

            idDisplayTv.text = intent.getIntExtra("id", 0).toString()
            contactName.text = intent.getStringExtra("personName")
            contactNumber.text = intent.getStringExtra("phoneNo")


        }
    }
}