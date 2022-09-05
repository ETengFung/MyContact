package com.example.ContactDatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mycontact.ContactDAO
import com.example.mycontact.entity.Contact

@Database(entities = [Contact::class], version = 1, exportSchema = false)
abstract class ContactDatabase: RoomDatabase() {
    abstract fun contactDao(): ContactDAO

    companion object{
        //Singleton prevents multiple instances of database opening at the same time
        @Volatile
        private var INSTANCE : ContactDatabase? = null

        fun getDatabase(context: Context): ContactDatabase{
            val tempInstance = INSTANCE
            if(tempInstance!= null){
                return tempInstance
            }

            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ContactDatabase::class.java,
                    "contact_db"
                ).build()

                INSTANCE = instance
                return instance
            }
        }
    }
}