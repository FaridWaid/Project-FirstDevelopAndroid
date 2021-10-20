package com.dicoding.firstapplication.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.dicoding.firstapplication.CharactersData
import com.dicoding.firstapplication.R
import com.google.android.material.bottomnavigation.BottomNavigationView


class AboutFragment : Fragment() {

    //mendeklarasikan title agar bisa di set di action bar
    private var title: String = "About Developer"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_about, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        //memberikan title pada action bar
//        supportActionBar?.title = title
//
//        //back button
//        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val urlGithub: ImageView = view.findViewById(R.id.github)
        urlGithub.setOnClickListener {
            val uri: Uri = Uri.parse("https://github.com/FaridWaid")
            startActivity(Intent(Intent.ACTION_VIEW,uri))
        }

        val urlInstagram: ImageView = view.findViewById(R.id.instagram)
        urlInstagram.setOnClickListener {
            val uri: Uri = Uri.parse("https://www.instagram.com/farid.waid/")
            startActivity(Intent(Intent.ACTION_VIEW,uri))
        }

        val urlFacebook: ImageView = view.findViewById(R.id.facebook)
        urlFacebook.setOnClickListener {
            val uri: Uri = Uri.parse("https://www.facebook.com/mu111/")
            startActivity(Intent(Intent.ACTION_VIEW,uri))
        }

    }

}