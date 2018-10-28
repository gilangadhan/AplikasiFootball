package com.google.aplikasifootball

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.google.aplikasifootball.R.array.*
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

class MainActivity : AppCompatActivity() {

    val data = ArrayList<ClubModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        generateData()
        linearLayout {
            padding = dip(8)
            lparams(width = matchParent, height = wrapContent)
            recyclerView {
                layoutManager = LinearLayoutManager(this@MainActivity)
                adapter = MainAdapter(data) { data ->
                    toast(data.name)
                }
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
}

