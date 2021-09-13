package com.dicoding.firstapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.net.Uri


class AboutDevActivity : AppCompatActivity(), View.OnClickListener {

    //mendeklarasikan title agar bisa di set di action bar
    private var title: String = "About Developer"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_dev)

        //memberikan title pada action bar
        supportActionBar?.title = title

        //back button
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val urlGithub: ImageView = findViewById(R.id.github)
        urlGithub.setOnClickListener(this)

        val urlInstagram: ImageView = findViewById(R.id.instagram)
        urlInstagram.setOnClickListener(this)

        val urlFacebook: ImageView = findViewById(R.id.facebook)
        urlFacebook.setOnClickListener(this)

    }

    override fun onClick(v: View?){
        when (v?.id){
            R.id.github -> {
                val uri: Uri = Uri.parse("https://github.com/FaridWaid")
                startActivity(Intent(Intent.ACTION_VIEW,uri))
            }

            R.id.instagram -> {
                val uri: Uri = Uri.parse("https://www.instagram.com/farid.waid/")
                startActivity(Intent(Intent.ACTION_VIEW,uri))
            }

            R.id.facebook -> {
                val uri: Uri = Uri.parse("https://www.facebook.com/mu111/")
                startActivity(Intent(Intent.ACTION_VIEW,uri))
            }

        }
    }


}