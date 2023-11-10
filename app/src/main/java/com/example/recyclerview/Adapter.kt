package com.example.recyclerview

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class Adapter(private var planet: List<PlanetData>):RecyclerView.Adapter<Adapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.view,parent,false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return planet.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.title.text = planet[position].title
        holder.itemView.setOnClickListener{

            val intent =  Intent(holder.itemView.context, PlanetDetails::class.java)
            intent.putExtra("planet", planet[position])
            holder.itemView.context.startActivity(intent)

        }
        holder.galaxy.text = planet[position].galaxy
        holder.distance.text = planet[position].distance + "m km"
        holder.gravity.text = planet[position].gravity + "m/ss"
        holder.planetImg.setImageDrawable(ContextCompat.getDrawable(holder.planetImg.context,planet[position].planetImg))
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view){
        var title: TextView = view.findViewById(R.id.title)
        var galaxy: TextView = view.findViewById(R.id.galaxy)
        var distance: TextView = view.findViewById(R.id.distance)
        var gravity: TextView = view.findViewById(R.id.gravity)
        var planetImg: ImageView = view.findViewById(R.id.planet_img)

    }


}

