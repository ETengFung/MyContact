package com.example.mycontact

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.example.mycontact.entity.Contact

class ContactRepository(private val contactDAO: ContactDAO) {
    //TODO: link to DAO and Create a cache copy of UI data
    val allContact: LiveData<List<Contact>> = contactDAO.getAll()

    @WorkerThread
    suspend fun insert(contact: Contact){
        contactDAO.insert(contact)
    }
    @WorkerThread
    suspend fun update(contact: Contact){
        contactDAO.update(contact)
    }
    @WorkerThread
    suspend fun delete(contact: Contact){
        contactDAO.delete(contact)
    }

}