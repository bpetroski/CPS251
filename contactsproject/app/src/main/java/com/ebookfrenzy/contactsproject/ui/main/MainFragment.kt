package com.ebookfrenzy.contactsproject.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.ebookfrenzy.contactsproject.R

import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.ebookfrenzy.contactsproject.Contact
import androidx.fragment.app.viewModels

import java.util.*

import com.ebookfrenzy.contactsproject.databinding.MainFragmentBinding
import java.lang.Integer.parseInt

class MainFragment : Fragment() {

    private var adapter: ContactListAdapter? = null

    companion object {
        fun newInstance() = MainFragment()
    }

    val viewModel: MainViewModel by viewModels()
    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        listenerSetup()
        observerSetup()
        recyclerSetup()

    }

    private fun listenerSetup() {

        binding.addButton.setOnClickListener {
            val contactName = binding.contactName.text.toString()
            val phoneNum = binding.phoneNumber.text.toString()

            if (contactName != "" && phoneNum != "") {
                val contact = Contact(contactName, phoneNum)
                viewModel.insertContact(contact)
                clearFields()
            } else {
                Toast.makeText(context, "Please fill both fields.", Toast.LENGTH_LONG).show()
            }
        }

        binding.findButton.setOnClickListener { viewModel.findContact(binding.contactName.text.toString()) }

        binding.ascButton.setOnClickListener {
            viewModel.ascSortContacts()

        }
    }

    private fun observerSetup() {

        viewModel.getAllContacts()?.observe(viewLifecycleOwner, Observer { contacts ->
            contacts?.let  {
                adapter?.setContactList(it)
            }
        })

        viewModel.getSearchResults().observe(viewLifecycleOwner, Observer { contacts ->

            contacts?.let {
                if (it.isNotEmpty()) {

                    binding.contactName.setText(it[0].contactName)
                    binding.phoneNumber.setText(it[0].phoneNumber)
                } else {
                    Toast.makeText(context, "No Match Found", Toast.LENGTH_LONG)
                }
            }
        })
    }

    private fun recyclerSetup() {
        adapter = ContactListAdapter(R.layout.contact_list_item)
        binding.contactRecycler.layoutManager = LinearLayoutManager(context)
        binding.contactRecycler.adapter = adapter

        adapter!!.settingListener(object: ContactListAdapter.onItemClickListener{
            override fun onClick(id: String){
                var contactID: Int = parseInt(id)
                viewModel.deleteContact(contactID)
            }
        })
    }

    private fun clearFields() {
        binding.contactName.setText("")
        binding.phoneNumber.setText("")
    }
}