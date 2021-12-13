package com.ebookfrenzy.contactsproject

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.*

class ContactRepository(application: Application) {

    val searchResults = MutableLiveData<List<Contact>>()
    private var contactDao: ContactDao?
    private val coroutineScope = CoroutineScope(Dispatchers.Main)
    var allContacts: LiveData<List<Contact>>?

    init {
        val db: ContactRoomDatabase? =
            ContactRoomDatabase.getDatabase(application)
        contactDao = db?.contactDao()
        allContacts = contactDao?.getAllContacts()
    }

    fun insertContact(newcontact: Contact) {
        coroutineScope.launch(Dispatchers.IO) {
            asyncInsert(newcontact)
        }
    }

    private suspend fun asyncInsert(contact: Contact) {
        contactDao?.insertContact(contact)
    }

    fun deleteContact(contactID: Int) {
        coroutineScope.launch(Dispatchers.IO) {
            asyncDelete(contactID)
        }
    }

    private suspend fun asyncDelete(contactID: Int) {
        contactDao?.deleteContact(contactID)
    }

    fun findContact(name: String) {

        coroutineScope.launch(Dispatchers.Main) {
            searchResults.value = asyncFind(name).await()
        }
    }


    fun ascSortContacts(){
        coroutineScope.launch(Dispatchers.Main){
            searchResults.value = asyncSortASC().await()
        }
    }

    fun descSortContacts(){
        coroutineScope.launch(Dispatchers.Main){
            searchResults.value = asyncSortDESC().await()
        }
    }


    private suspend fun asyncFind(name: String): Deferred<List<Contact>?> =

        coroutineScope.async(Dispatchers.IO) {
            return@async contactDao?.findContact(name)
        }

    private suspend fun asyncSortASC(): Deferred<List<Contact>?> =

        coroutineScope.async(Dispatchers.IO){
            return@async contactDao?.getAscContacts()
        }

    private suspend fun asyncSortDESC(): Deferred<List<Contact>?> =
        coroutineScope.async(Dispatchers.IO){
            return@async contactDao?.getDescContacts()
        }

}