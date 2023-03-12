package com.example.quizly

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.ImageView
import com.bumptech.glide.Glide

class Slash : AppCompatActivity() {

    lateinit var imageView: ImageView
    val url="https://media0.giphy.com/media/Rs2QPsshsFI9zeT4Kn/giphy.gif?cid=ecf05e477ax28ugz52ezhpbt8lsllzg8j9snyadmjsq7ij42&rid=giphy.gif&ct=g"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slash)


        imageView=findViewById(R.id.iv)

        //using glide library
        Glide.with(this)
            .load(url)
            .into(imageView)
        //setting time for splash screen
        Handler().postDelayed({
            val intent= Intent(this@Slash,LogIn::class.java)
            startActivity(intent)
            finish()

        },4000)


    }
}