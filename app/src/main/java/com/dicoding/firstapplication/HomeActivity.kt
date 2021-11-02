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

//    private lateinit var rvChars: RecyclerView
//    private var list: ArrayList<Character> = arrayListOf()
//    private var title: String = "Top Character In Anime World"
    private val homeFragment = HomeFragment()
    private val favoriteFragment = FavoriteFragment()
    private val aboutFragment = AboutFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        supportActionBar?.hide()
        //setActionBarTitle(title)
//        replaceFragment(homeFragment)

//        rvChars = findViewById(R.id.rv_chars)
//        rvChars.setHasFixedSize(true)
//
//        list.addAll(CharactersData.listData)
//        showRecyclesList()

        //Bottom Navigation
        val bottomNavigation: MeowBottomNavigation = findViewById(R.id.bottom_navigation)
////        val bottomNavigation = findViewById<MeowBottomNavigation>(R.id.bottom_navigation)
//        bottomNavigation.add(MeowBottomNavigation.Model(0, R.drawable.ic_baseline_home_24))
//        bottomNavigation.add(MeowBottomNavigation.Model(1, R.drawable.ic_baseline_favorite_24))
//        bottomNavigation.add(MeowBottomNavigation.Model(2, R.drawable.ic_baseline_person_24))
//
//        bottomNavigation.setOnClickMenuListener {
//            when(it.id) {
//                0 -> {
//                    Toast.makeText(this@HomeActivity, "OKE 1", Toast.LENGTH_SHORT).show()
//                }
//                1 -> {
//                    Toast.makeText(this@HomeActivity, "OKE 2", Toast.LENGTH_SHORT).show()
////                    replaceFragment(favoriteFragment)
//                }
//                2 -> {
//                    Toast.makeText(this@HomeActivity, "OKE 3", Toast.LENGTH_SHORT).show()
////                    replaceFragment(aboutFragment)
//                }
//            }
//        }

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

//        bottomNavigation.setOnNavigationItemSelectedListener {
//            when(it.itemId) {
//                R.id.action_home -> replaceFragment(homeFragment)
//                R.id.action_favourite -> replaceFragment(favoriteFragment)
//                R.id.action_about -> replaceFragment(aboutFragment)
//            }
//            true
//        }


    }

    private fun setActionBarTitle(title: String) {
        supportActionBar?.title = title
    }

//    private fun showRecyclesList() {
//        rvChars.layoutManager = LinearLayoutManager(this)
//        val listClubAdapter = ListCharAdapter(list)
//        rvChars.adapter = listClubAdapter
//    }

//    private fun showRecyclerCardView() {
//        rvChars.layoutManager = LinearLayoutManager(this)
//        val cardViewClubAdapter = CardViewCharAdapter(list)
//        rvChars.adapter = cardViewClubAdapter
//    }
//
//    private fun showAboutDeveloper() {
//        rvChars.layoutManager = LinearLayoutManager(this)
//        val listAboutAdapter = ListAboutAdapter()
//        //rvChars.adapter = listAboutAdapter
//    }
//
//    override fun onCreateOptionsMenu(menu: Menu): Boolean {
//        menuInflater.inflate(R.menu.menu, menu)
//        return super.onCreateOptionsMenu(menu)
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        setMode(item.itemId)
//        return super.onOptionsItemSelected(item)
//    }

//    private fun setMode(selecterMode: Int) {
//        when (selecterMode) {
////            R.id.action_list -> {
////                title = "Top Character In Anime World"
////                showRecyclesList()
////            }
////            R.id.action_card -> {
////                title = "Choose One of This Characters"
////                showRecyclerCardView()
////            }
//            R.id.action_about -> {
////                title = "About Developer"
//                val moveIntent = Intent(this@HomeActivity, AboutDevActivity::class.java)
//                startActivity(moveIntent)
//            }
//        }
//        setActionBarTitle(title)
//    }

//    private fun replaceFragment(fragment: Fragment) {
//        if (fragment != null) {
//            val transaction = supportFragmentManager.beginTransaction()
//            transaction.replace(R.id.fragment_container, fragment)
//            transaction.commit()
//        }
//    }

    private fun replaceFragment(fragment:Fragment){
        val fragmentTransition = supportFragmentManager.beginTransaction()
        fragmentTransition.replace(R.id.fragment_container,fragment).commit()
    }

    private fun addFragment(fragment:Fragment){
        val fragmentTransition = supportFragmentManager.beginTransaction()
        fragmentTransition.add(R.id.fragment_container,fragment).commit()
    }

}

