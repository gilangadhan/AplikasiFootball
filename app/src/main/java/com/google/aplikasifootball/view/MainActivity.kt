/*
 * Copyright (c) 2018.
 * Gilang Ramadhan (gilang@imastudio.co.id)
 */

package com.google.aplikasifootball.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.google.aplikasifootball.R
import com.google.aplikasifootball.R.array.*
import com.google.aplikasifootball.model.ClubModel
import com.google.aplikasifootball.model.TeamModel
import com.google.aplikasifootball.network.ApiRepository
import com.google.gson.Gson
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

class MainActivity : AppCompatActivity(), MainView {

    val data = ArrayList<ClubModel>()
    lateinit var adapterView : MainAdapter
    var response: MutableList<TeamModel> = arrayListOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        generateData()
        val gson = Gson()
        val request = ApiRepository()
        val presenter = MainPresenter(this,request, gson)
        presenter.getTeamList("German%20Bundesliga")
        adapterView = MainAdapter(response) { data ->
            toast(data.name)
        }
        linearLayout {
            padding = dip(8)
            lparams(width = matchParent, height = wrapContent)
            recyclerView {
                layoutManager = LinearLayoutManager(this@MainActivity)
                adapter = adapterView
            }
        }
    }

    fun generateData() {
        val name = resources.getStringArray(club_name)
        val image = resources.obtainTypedArray(club_image)
        val desc = resources.getStringArray(club_desc)

        data.clear()
        for (i in name.indices) {
            data.add(ClubModel(name[i], image.getResourceId(i, 0), desc[i]))
        }
        image.recycle()
    }

    override fun showLoading() {

    }

    override fun hideLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showTeamList(data: List<TeamModel>) {
        response.clear()
        response.addAll(data)
        adapterView.notifyDataSetChanged()
    }

}

