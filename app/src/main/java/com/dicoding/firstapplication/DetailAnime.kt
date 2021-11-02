package com.dicoding.firstapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class DetailAnime : AppCompatActivity() {

    private var title: String = "Detail Anime"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_anime)

        val actionBar = supportActionBar
        actionBar!!.title = title

        //back button
        actionBar.setDisplayHomeAsUpEnabled(true)

        val tvSetName: TextView = findViewById(R.id.tv_item_name)
        val tvSetScore: TextView = findViewById(R.id.tv_item_score)
        val tvSetRank: TextView = findViewById(R.id.tv_item_rank)
        val tvSetPopularity: TextView = findViewById(R.id.tv_popularity)
        val tvSetMembers: TextView = findViewById(R.id.tv_member)
        val imgSetPhoto: ImageView = findViewById(R.id.img_item_photo)
        val tvSetDetail: TextView = findViewById(R.id.tv_item_detail)

        val tNameAnime = intent.getStringExtra(EXTRA_NAME_ANIME)
        val tScore = intent.getStringExtra(EXTRA_SCORE)
        val tRank = intent.getStringExtra(EXTRA_RANK)
        val tPopularity = intent.getStringExtra(EXTRA_POPULARITY)
        val tMember = intent.getStringExtra(EXTRA_MEMBERS)
        val tDetailAnime = intent.getStringExtra(EXTRA_DETAIL_ANIME)
        val tImgAnime = intent.getIntExtra(EXTRA_PHOTO_ANIME, 0)

        tvSetName.text = tNameAnime
        tvSetScore.text = tScore
        tvSetRank.text = tRank
        tvSetPopularity.text = tPopularity
        tvSetMembers.text = tMember
        Glide.with(this)
            .load(tImgAnime)
            .apply(RequestOptions())
            .into(imgSetPhoto)
        tvSetDetail.text = tDetailAnime

        val btnLike: Button = findViewById(R.id.button_like)
        btnLike.setOnClickListener{
            Toast.makeText(this, "You Like " + tNameAnime, Toast.LENGTH_SHORT).show()
        }
    }

    companion object {
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