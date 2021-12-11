package com.ebookfrenzy.contactsproject

import android.telephony.PhoneNumberUtils
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contacts")
class Contact {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "contactId")
    var id: Int = 0

    @ColumnInfo(name = "contactName")
    var contactName: String? = null
    var phoneNumber: String? = null

    constructor() {}

    constructor(id: Int, contactname: String, phoneNumber: String) {
        this.contactName = contactname
        this.phoneNumber = phoneNumber
    }
    constructor(contactname: String, phoneNumber: String) {
        this.contactName = contactname
        this.phoneNumber = phoneNumber //PhoneNumberUtils.formatNumber("1" + phoneNumber, "US") tried this for formatting, didn't work
    }
}