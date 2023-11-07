package com.example.recyclerview

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class Adapter(private var context: Context,var planet : List<PlanetData>):RecyclerView.Adapter<Adapter.myViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        var itemView = LayoutInflater.from(parent.context).inflate(R.layout.view,parent,false)
        return myViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return planet.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        holder.title.text = planet[position].title
        holder.galaxy.text = planet[position].galaxy
        holder.distance.text = planet[position].distance + "m km"
        holder.gravity.text = planet[position].gravity + "m/ss"
        holder.planetImg.setImageDrawable(ContextCompat.getDrawable(holder.planetImg.context,planet[position].planetImg))
    }

    class myViewHolder(view: View) : RecyclerView.ViewHolder(view){
        var title = view.findViewById<TextView>(R.id.title)
        var galaxy = view.findViewById<TextView>(R.id.galaxy)
        var distance = view.findViewById<TextView>(R.id.distance)
        var gravity = view.findViewById<TextView>(R.id.gravity)
        var planetImg = view.findViewById<ImageView>(R.id.planet_img)

    }


}

