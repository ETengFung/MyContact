package com.example.mycontact
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.ContactDatabase.ContactDatabase
import com.example.mycontact.entity.Contact
import kotlinx.coroutines.launch

class ContactViewModel(application: Application)
    :AndroidViewModel (application){
    //TODO: Create an instance dataset, repository
        var contactList:LiveData<List<Contact>>
        private val contactRepository: ContactRepository

        init {
            //Create an instance for DAO dataset
            val contactDAO = ContactDatabase.getDatabase(application).contactDao()

            //Create repository
            contactRepository = ContactRepository(contactDAO)

            //Retrieve data from repository
            contactList = contactRepository.allContact
        }
    fun insert(contact: Contact) = viewModelScope.launch {
        contactRepository.insert(contact)
    }
    fun delete(contact: Contact) = viewModelScope.launch {
        contactRepository.delete(contact)
    }
    fun update(contact: Contact) = viewModelScope.launch {
        contactRepository.update(contact)
    }



}