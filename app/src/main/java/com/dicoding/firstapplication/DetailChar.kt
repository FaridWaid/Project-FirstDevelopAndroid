package com.dicoding.firstapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dicoding.firstapplication.fragments.FavoriteFragment

class DetailChar : AppCompatActivity() {

    private val favoriteFragment = FavoriteFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_char)


        val tvSetName: TextView = findViewById(R.id.tv_item_name)
        val imgSetPhoto: ImageView = findViewById(R.id.img_item_photo)
        val tvSetDetail: TextView = findViewById(R.id.tv_item_detail)

        val tName  = intent.getStringExtra(EXTRA_NAME)
        val tImg = intent.getIntExtra(EXTRA_PHOTO,0)
        val tDetail = intent.getStringExtra(EXTRA_DETAIL)


        tvSetName.text = tName
        Glide.with(this)
            .load(tImg)
            .apply(RequestOptions().override(120,120))
            .into(imgSetPhoto)
        tvSetDetail.text = tDetail

//        val mFragmentManager = supportFragmentManager
//        val mFragmentTransaction = mFragmentManager.beginTransaction()

        val btnFavorit: Button = findViewById(R.id.button_fav)
        btnFavorit.setOnClickListener{
            Toast.makeText(this, "You choose " + tName + " as your favorite character", Toast.LENGTH_SHORT).show()
//            val mBundle = Bundle()
//            val moveIntent = Intent(this, FavoriteFragment::class.java)
//            mBundle.putString("set_name", tName)
//            favoriteFragment.arguments = mBundle
//            mFragmentTransaction.add(R.id.fragment_containerFav, favoriteFragment)
//            mFragmentTransaction.addToBackStack(null)
//            mFragmentTransaction.commit()
//            moveIntent.putExtra("set_photo", tImg)
//            replaceFragment(favoriteFragment)
        }
    }

    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_PHOTO = "extra_photo"
        const val EXTRA_DETAIL = "extra_detail"
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

//    private fun replaceFragment(fragment: Fragment) {
//        if (fragment != null) {
//            val transaction = supportFragmentManager.beginTransaction()
//            transaction.replace(R.id.fragment_container, favoriteFragment)
//            transaction.commit()
//        }
//    }

}
