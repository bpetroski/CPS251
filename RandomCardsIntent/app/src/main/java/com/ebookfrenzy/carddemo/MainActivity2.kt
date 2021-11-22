package com.ebookfrenzy.carddemo

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

import com.ebookfrenzy.carddemo.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val extras = intent.extras ?: return

        val cardTitle = extras.getString("cardTitle")
        val cardDetail = extras.getString("cardDetail")
        val cardImage = extras.getInt("cardImage")

        binding.titleText.text = cardTitle
        binding.detailsText.text = cardDetail
        binding.imageView.setImageResource(cardImage)
    }
}