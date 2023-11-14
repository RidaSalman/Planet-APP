package com.example.recyclerview

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.core.content.ContextCompat

class FinalActivity : AppCompatActivity() {

    private  var obj: PlanetData? = null
    private lateinit var image:ImageView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final)
        obj= intent.getParcelableExtra("planet")


        image = findViewById(R.id.finalImage)
        image.setImageDrawable(ContextCompat.getDrawable(this,obj?.planetImg?:R.drawable.earth))
    }
}