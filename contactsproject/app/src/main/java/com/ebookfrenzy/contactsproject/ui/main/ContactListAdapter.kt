package com.ebookfrenzy.contactsproject.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ebookfrenzy.contactsproject.Contact
import com.ebookfrenzy.contactsproject.R

class ContactListAdapter(private val productItemLayout: Int) :
    RecyclerView.Adapter<ContactListAdapter.ViewHolder>() {

    private var contactList: List<Contact>? = null

    var listener: onItemClickListener? = null

    fun settingListener(listener: onItemClickListener?){
        this.listener = listener
    }
    interface onItemClickListener {
        fun onClick(str: String)
    }

    override fun onBindViewHolder(holder: ViewHolder, listPosition: Int) {
        val item = holder.item
        val number = holder.phoneNumber
        val id = holder.contactID
        var delete = holder.deleteImage
        contactList.let {
            item.text = it!![listPosition].contactName
            number.text = it!![listPosition].phoneNumber
            id.text = it!![listPosition].id.toString()
            delete.setImageResource(android.R.drawable.ic_delete)
        }

        delete.setOnClickListener(View.OnClickListener {
            var clickedID = id.text.toString()
            listener?.onClick(clickedID)
        })

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            productItemLayout, parent, false)
        return ViewHolder(view)
    }

    fun setContactList(contacts: List<Contact>) {
        contactList = contacts
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return if (contactList == null) 0 else contactList!!.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var item: TextView = itemView.findViewById(R.id.contact_row)
        var phoneNumber: TextView = itemView.findViewById(R.id.phoneNumber)
        var contactID: TextView = itemView.findViewById(R.id.contactID)
        var deleteImage: ImageView = itemView.findViewById(R.id.trashCan)
    }
}