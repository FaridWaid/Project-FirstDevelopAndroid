package com.dicoding.firstapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvClubs: RecyclerView
    private var list: ArrayList<Club> = arrayListOf()
    private var title: String = "The Best Clubs In The World"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setActionBarTitle(title)

        rvClubs = findViewById(R.id.rv_clubs)
        rvClubs.setHasFixedSize(true)

        list.addAll(ClubsData.listData)
        showRecyclesList()
    }

    private fun setActionBarTitle(title: String) {
        supportActionBar?.title = title
    }

    private fun showRecyclesList() {
        rvClubs.layoutManager = LinearLayoutManager(this)
        val listClubAdapter = ListClubAdapter(list)
        rvClubs.adapter = listClubAdapter
    }

    private fun showRecyclerCardView() {
        rvClubs.layoutManager = LinearLayoutManager(this)
        val cardViewClubAdapter = CardViewClubAdapter(list)
        rvClubs.adapter = cardViewClubAdapter
    }

    private fun showAboutDeveloper() {
        rvClubs.layoutManager = LinearLayoutManager(this)
        val listAboutAdapter = ListAboutAdapter()
        rvClubs.adapter = listAboutAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selecterMode: Int) {
        when (selecterMode) {
            R.id.action_list -> {
                title = "The Best Clubs In The World"
                showRecyclesList()
            }
            R.id.action_card -> {
                title = "You can choose one of this clubs"
                showRecyclerCardView()
            }
            R.id.action_about -> {
                title = "About Developer"
                showAboutDeveloper()
            }
        }
        setActionBarTitle(title)
    }
}