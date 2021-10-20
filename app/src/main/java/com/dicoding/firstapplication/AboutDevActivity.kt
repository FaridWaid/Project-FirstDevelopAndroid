package com.dicoding.firstapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.net.Uri
import com.google.android.material.bottomnavigation.BottomNavigationView


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

        //Bottom Navigation
        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        //Set item navigation
        bottomNavigation.setOnNavigationItemSelectedListener(navigasjonen)

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

    private val navigasjonen = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.action_home -> {
                val intent = Intent(this@AboutDevActivity, HomeActivity::class.java)
                startActivity(intent)
                finish()
                return@OnNavigationItemSelectedListener true
            }
            R.id.action_about -> {
                return@OnNavigationItemSelectedListener false
            }
//            R.id.favoritter -> {
//                val intent = Intent(this@MainActivity, MyRecipes::class.java)
//                startActivity(intent)
//                return@OnNavigationItemSelectedListener true
//            }
//            R.id.utforsk -> {
//                return@OnNavigationItemSelectedListener true
//            }
        }
        false

    }


}