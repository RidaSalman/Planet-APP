package com.example.recyclerview

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import java.io.Serializable

class PlanetDetails : AppCompatActivity() {

    private  var obj: PlanetData? = null
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_planet_details)

        obj= intent.getParcelableExtra("planet")
        setData()

        val buttonInfo = findViewById<TextView>(R.id.button_info)

        buttonInfo.setOnClickListener{
            val intent=Intent(this,FinalActivity::class.java)
            intent.putExtra("planet", obj)
            startActivity(intent)

        }

    }

    @SuppressLint("SetTextI18n")
    private fun setData() {

        val titleInfo = findViewById<TextView>(R.id.title_info)
        val distanceInfo = findViewById<TextView>(R.id.distance_info)
        val gravityInfo = findViewById<TextView>(R.id.gravity_info)
        val overviewInfo = findViewById<TextView>(R.id.overview_info)
        val galaxyInfo = findViewById<TextView>(R.id.galaxy_info)
        val planetImgInfo = findViewById<ImageView>(R.id.planet_img_info)

        titleInfo.text = obj?.title
        distanceInfo.text = obj?.distance
        gravityInfo.text = obj?.gravity
        overviewInfo.text = obj?.overview
        galaxyInfo.text = obj?.galaxy
        obj?.planetImg?.let { planetImgInfo.setImageResource(it) }


    }
}