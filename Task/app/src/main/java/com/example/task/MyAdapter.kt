package com.example.task

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_view.view.*
import java.text.FieldPosition

class MyAdapter(val numbers : List<image>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    private lateinit var mListener:onItemClickListener
    interface onItemClickListener{
        fun onItemClick(position: Int)
    }
    fun setonItemClickListener(listener: onItemClickListener){
        mListener=listener
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater=LayoutInflater.from(parent.context)
        val view=inflater.inflate(R.layout.item_view,parent,false)
        return MyViewHolder(view,mListener)
    }

    override fun onBindViewHolder(holder: MyViewHolder,position: Int) {
        holder.number.text=numbers[position].ImageDesc
        holder.image.setImageResource(numbers[position].imgSrc)
    }

    override fun getItemCount(): Int {
       return numbers.size
    }
    class MyViewHolder(itemView: View,listener: onItemClickListener): RecyclerView.ViewHolder(itemView) {
        var image=itemView.findViewById<ImageView>(R.id.image)
        var number=itemView.findViewById<TextView>(R.id.ImgDesc)

        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }
    }


}
