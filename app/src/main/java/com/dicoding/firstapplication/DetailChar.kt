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
    private var title: String = "Detail Character"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_char)

        val actionBar = supportActionBar
        actionBar!!.title = title

        //back button
        actionBar.setDisplayHomeAsUpEnabled(true)

        val tvSetName: TextView = findViewById(R.id.tv_item_name)
        val imgSetPhoto: ImageView = findViewById(R.id.img_item_photo)
        val tvSetDetail: TextView = findViewById(R.id.tv_item_detail)

        val tName  = intent.getStringExtra(EXTRA_NAME)
        val tImg = intent.getIntExtra(EXTRA_PHOTO,0)
        val tDetail = intent.getStringExtra(EXTRA_DETAIL)
        val tNameAnime = intent.getStringExtra(EXTRA_NAME_ANIME)
        val tScore = intent.getStringExtra(EXTRA_SCORE)
        val tRank = intent.getStringExtra(EXTRA_RANK)
        val tPopularity = intent.getStringExtra(EXTRA_POPULARITY)
        val tMember = intent.getStringExtra(EXTRA_MEMBERS)
        val tDetailAnime = intent.getStringExtra(EXTRA_DETAIL_ANIME)
        val tImgAnime = intent.getIntExtra(EXTRA_PHOTO_ANIME, 0)

        tvSetName.text = tName
        Glide.with(this)
            .load(tImg)
            .apply(RequestOptions())
            .into(imgSetPhoto)
        tvSetDetail.text = tDetail

        val btnCheck: Button = findViewById(R.id.button_check)
        btnCheck.setOnClickListener{
            Toast.makeText(this, "You checked " + tNameAnime + " detail!", Toast.LENGTH_SHORT).show()
            val moveDetail = Intent(this@DetailChar, DetailAnime::class.java)
            moveDetail.putExtra(DetailChar.EXTRA_NAME_ANIME, tNameAnime)
            moveDetail.putExtra(DetailChar.EXTRA_SCORE, tScore)
            moveDetail.putExtra(DetailChar.EXTRA_RANK, tRank)
            moveDetail.putExtra(DetailChar.EXTRA_POPULARITY, tPopularity)
            moveDetail.putExtra(DetailChar.EXTRA_MEMBERS, tMember)
            moveDetail.putExtra(DetailChar.EXTRA_DETAIL_ANIME, tDetailAnime)
            moveDetail.putExtra(DetailChar.EXTRA_PHOTO_ANIME, tImgAnime)
            startActivity(moveDetail)
        }
    }

    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_PHOTO = "extra_photo"
        const val EXTRA_DETAIL = "extra_detail"
        const val EXTRA_NAME_ANIME = "extra_name_anime"
        const val EXTRA_RANK = "extra_rank"
        const val EXTRA_SCORE = "extra_score"
        const val EXTRA_POPULARITY = "extra_popularity"
        const val EXTRA_MEMBERS = "extra_members"
        const val EXTRA_DETAIL_ANIME = "extra_detail_anime"
        const val EXTRA_PHOTO_ANIME = "extra_photo_anime"
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
