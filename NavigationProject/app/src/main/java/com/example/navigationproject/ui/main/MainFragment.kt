package com.example.navigationproject.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.navigationproject.R
import com.example.navigationproject.databinding.MainFragmentBinding

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }
/*
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
*/
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.button.setOnClickListener {
            val action: MainFragmentDirections.NavigateToImage = MainFragmentDirections.navigateToImage()

            action.setMessage("Image One")
            action.setImageDir("android_image_1.jpg")
            Navigation.findNavController(it).navigate(action)
        }
        binding.button2.setOnClickListener {
            val action: MainFragmentDirections.NavigateToImage = MainFragmentDirections.navigateToImage()

            action.setMessage("Image Two")
            Navigation.findNavController(it).navigate(action)
        }
        binding.button3.setOnClickListener {
            val action: MainFragmentDirections.NavigateToImage = MainFragmentDirections.navigateToImage()

            action.setMessage("Image Three")
            Navigation.findNavController(it).navigate(action)
        }
    }

}