package com.example.mycontact

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.mycontact.entity.Contact

@Dao
interface ContactDAO {
    //TODO: Prov database CRUD function
    @Query("SELECT * FROM contact")
    fun getAll():LiveData<List<Contact>>

    @Query("SELECT * FROM contact WHERE name LIKE :name")
    suspend fun findByName(name: String):Contact

    @Insert
    suspend fun insert(contact: Contact)

    @Update
    suspend fun update(contact: Contact)

    @Delete
    suspend fun delete(contact: Contact)


}