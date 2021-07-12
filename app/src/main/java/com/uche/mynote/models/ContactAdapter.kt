package com.uche.mynote.models

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import com.uche.mynote.databinding.ContactListBinding


class ContactAdapter(var contacts: List<Contact>, val clicker: (Contact) -> Unit): RecyclerView.Adapter<ContactAdapter.ContactViewHolder>(){
   inner class ContactViewHolder(private val binding: ContactListBinding) : RecyclerView.ViewHolder(binding.root){
        fun bindContact(contact: Contact){
            binding.apply{
                Display.text = contact.id.toString()
                contactDisplay.text = contact.personName
                root.setOnClickListener { clicker (contact) }

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        var binding = ContactListBinding.inflate(LayoutInflater.from(parent.context))
        return ContactViewHolder(binding)

    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {

        holder.bindContact(contacts[position])

    }

    override fun getItemCount(): Int {
        return contacts.size

    }
}