 package com.example.lifecycleawareproject.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.Observer
import com.example.lifecycleawareproject.databinding.MainFragmentBinding
import com.example.lifecycleawareproject.myObserver

 class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }
    var temp = ""
    private lateinit var myObserver: myObserver
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

     override fun onResume() {
         super.onResume()
         binding.output.text = viewModel.resume()
         binding.output.text = viewModel.endLine()
     }

     override fun onDestroy() {
         super.onDestroy()
         binding.output.text = viewModel.destroy()
     }

     override fun onPause() {
         super.onPause()
         binding.output.text = viewModel.pause()
     }

     override fun onStart() {
         super.onStart()
         binding.output.text = viewModel.start()
     }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        lifecycle.addObserver(myObserver())
        binding.output.text = viewModel.activityCreated()


        // TODO: Use the ViewModel
    }

}