package com.example.task

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Math.random
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val imageObjects= mutableListOf<image>()
        imageObjects.add(image("One",R.drawable.first))
        imageObjects.add(image("Two",R.drawable.second))
        imageObjects.add(image("Three",R.drawable.three))
        imageObjects.add(image("Four",R.drawable.four))
        imageObjects.add(image("Five",R.drawable.five))
        imageObjects.add(image("Six",R.drawable.six))
        imageObjects.add(image("Seven",R.drawable.seven))
        imageObjects.add(image("Eight",R.drawable.eight))
        imageObjects.add(image("Nine",R.drawable.nine))
        imageObjects.add(image("Ten",R.drawable.ten))
        shuffle.setOnClickListener {
            imageObjects.shuffle()
        }
        var adapter=MyAdapter(imageObjects)
        numberList.adapter=adapter
        numberList.layoutManager=LinearLayoutManager((this))
        adapter.setonItemClickListener(
            object : MyAdapter.onItemClickListener {
                override fun onItemClick(position: Int) {
                    val p=position
                    val q:Int=1
                    val sum=p+q


                    Toast.makeText(this@MainActivity,"You clicked on item no. $sum",Toast.LENGTH_SHORT).show()
                }

            },
        )

    }


}


