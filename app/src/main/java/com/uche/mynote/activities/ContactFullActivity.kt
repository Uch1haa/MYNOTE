package com.uche.mynote.activities

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.uche.mynote.databinding.ActivityContactFullBinding



class ContactFullActivity : AppCompatActivity() {
    private lateinit var binding: ActivityContactFullBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContactFullBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.run {
            idShowFull.text = intent.getIntExtra("id", Build.VERSION_CODES.O).toString()
            NameShowFull.text = intent.getStringExtra("FullName")
            phoneShowFull.text = intent.getStringExtra("phoneNumber").toString()
        }
    }
}