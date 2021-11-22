package com.ebookfrenzy.carddemo

import android.content.Intent
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import com.ebookfrenzy.carddemo.Data
import com.ebookfrenzy.carddemo.MainViewModel

import androidx.recyclerview.widget.RecyclerView

import com.google.android.material.snackbar.Snackbar

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    private var data = Data()
    private lateinit var arr: ArrayList<ArrayList<Int>>

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.card_layout, viewGroup, false)
        arr = MainViewModel.intlist
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return data.titles.size
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.itemTitle.text = data.titles[arr[i][0]]
        viewHolder.itemDetail.text = data.details[arr[i][1]]
        viewHolder.itemImage.setImageResource(data.images[arr[i][2]])
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var itemImage: ImageView
        var itemTitle: TextView
        var itemDetail: TextView

        init {
            itemImage = itemView.findViewById(R.id.itemImage)
            itemTitle = itemView.findViewById(R.id.itemTitle)
            itemDetail = itemView.findViewById(R.id.itemDetail)

            itemView.setOnClickListener { v: View  ->
                var position: Int = getAdapterPosition()
                val clickedTitle = data.titles[arr[position][0]]
                val clickedDetails = data.details[arr[position][1]]
                val clickedImage = data.images[arr[position][2]]

                val i = Intent(v.getContext(),MainActivity2::class.java)

                i.putExtra("cardTitle", clickedTitle)
                i.putExtra("cardDetail", clickedDetails)
                i.putExtra("cardImage", clickedImage)

                startActivity(v.context,i,null)

/*                Snackbar.make(v, "Click detected on item $position" +
                        "\nTitle: " + clickedTitle + "|Details: " + clickedDetails,
                    Snackbar.LENGTH_LONG).setAction("Action", null).show()*/
            }
        }
    }
}