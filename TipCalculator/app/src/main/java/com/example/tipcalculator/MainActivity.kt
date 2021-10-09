package com.example.tipcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.view.View
import com.example.tipcalculator.databinding.ActivityMainBinding
import kotlin.math.nextUp
import kotlin.math.roundToLong

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    lateinit var totalsMessage: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calculateTipBtn.setOnClickListener {
            calculateTip()
        }
    }

    private fun calculateTip(){
        if(binding.billEntry.text.isEmpty()){
            binding.tipText.text = getString(R.string.invalidValue)
        }
        if(binding.billEntry.text.isNotEmpty()){
            val bill = binding.billEntry.text.toString().toFloat()
            totalsMessage = getString(R.string.tipTotals)
            totalsMessage = totalsMessage + "\n\n10% = " + "%.2f".format(bill*1.1).toFloat() + "\n\n15% = " +"%.2f".format(bill*1.15).toFloat() + "\n\n20% = " + "%.2f".format(bill*1.2).toFloat()
            binding.tipText.text = totalsMessage
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val totals = binding.tipText.text.toString()
        outState.putString("savedTotals", totals)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val totals = savedInstanceState.getString("savedTotals", "blank")
        binding.tipText.text = totals

    }
}


