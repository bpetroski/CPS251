package com.ebookfrenzy.carddemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.ViewModelProvider

import com.ebookfrenzy.carddemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private var dt = Data

    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>? = null

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)


        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        layoutManager = LinearLayoutManager(this)
        binding.contentMain.recyclerView.layoutManager = layoutManager
        adapter = RecyclerAdapter()
        binding.contentMain.recyclerView.adapter = adapter

        dt.initData()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putStringArray("titles", MainViewModel.titles)
        outState.putStringArray("details", MainViewModel.details)
        outState.putIntArray("Images", MainViewModel.images)

    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

/*        MainViewModel.titles = savedInstanceState.getStringArray("titles") as Array<String>
        MainViewModel.details = savedInstanceState.getStringArray("details") as Array<String>
        MainViewModel.images = savedInstanceState.getIntArray("Images")!!*/
        MainViewModel.initTitlesArray(savedInstanceState.getStringArray("titles") as Array<String>)

    }
}