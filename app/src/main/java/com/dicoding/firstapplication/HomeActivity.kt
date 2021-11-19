package com.dicoding.firstapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.firstapplication.fragments.AboutFragment
import com.dicoding.firstapplication.fragments.FavoriteFragment
import com.dicoding.firstapplication.fragments.HomeFragment
import com.etebarian.meowbottomnavigation.MeowBottomNavigation
import java.lang.reflect.Array.newInstance
import javax.xml.datatype.DatatypeFactory.newInstance

class HomeActivity : AppCompatActivity() {

    private val homeFragment = HomeFragment()
    private val favoriteFragment = FavoriteFragment()
    private val aboutFragment = AboutFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        supportActionBar?.hide()

        //Bottom Navigation
        val bottomNavigation: MeowBottomNavigation = findViewById(R.id.bottom_navigation)

        addFragment(HomeFragment())
        bottomNavigation.show(0)
        bottomNavigation.add(MeowBottomNavigation.Model(0,R.drawable.ic_baseline_home_24))
        bottomNavigation.add(MeowBottomNavigation.Model(1,R.drawable.ic_baseline_favorite_24))
        bottomNavigation.add(MeowBottomNavigation.Model(2,R.drawable.ic_baseline_person_24))

        bottomNavigation.setOnClickMenuListener {
            when(it.id){
                0 -> {
                    replaceFragment(HomeFragment())
                }
                1 -> {
                    replaceFragment(FavoriteFragment())
                }
                2 -> {
                    replaceFragment(AboutFragment())
                }
                else -> {
                    replaceFragment(HomeFragment())
                }
            }
        }
    }

    private fun setActionBarTitle(title: String) {
        supportActionBar?.title = title
    }

    private fun replaceFragment(fragment:Fragment){
        val fragmentTransition = supportFragmentManager.beginTransaction()
        fragmentTransition.replace(R.id.fragment_container,fragment).commit()
    }

    private fun addFragment(fragment:Fragment){
        val fragmentTransition = supportFragmentManager.beginTransaction()
        fragmentTransition.add(R.id.fragment_container,fragment).commit()
    }

}

