package com.dicoding.firstapplication.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.firstapplication.data.Character
import com.dicoding.firstapplication.data.CharactersData
import com.dicoding.firstapplication.adapter.ListCharAdapter
import com.dicoding.firstapplication.R

class HomeFragment : Fragment() {

    private lateinit var rvChars: RecyclerView
    private var list: ArrayList<Character> = arrayListOf()
    private var title: String = "Top Character In Anime World"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvChars = view.findViewById(R.id.rv_chars)
        rvChars.setHasFixedSize(true)

        list.clear()
        list.addAll(CharactersData.listData)
        showRecyclesList()
    }

    private fun showRecyclesList() {
        rvChars.layoutManager = LinearLayoutManager(context)
        val listCharAdapter = ListCharAdapter(list)
        rvChars.adapter = listCharAdapter
    }

}