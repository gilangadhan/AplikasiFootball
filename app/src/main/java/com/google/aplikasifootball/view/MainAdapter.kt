/*
 * Copyright (c) 2018.
 * Gilang Ramadhan (gilang@imastudio.co.id)
 */

package com.google.aplikasifootball.view

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.google.aplikasifootball.R
import com.google.aplikasifootball.R.id.imageClub
import com.google.aplikasifootball.R.id.nameClub
import com.google.aplikasifootball.model.ClubModel
import com.google.aplikasifootball.model.TeamModel
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick

class MainAdapter(val list: List<TeamModel>, val listener: (TeamModel)-> (Unit)):
    RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): MainViewHolder =
        MainViewHolder(
            AdapterUI().createView(AnkoContext.create(parent.context))
        )

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(view: MainViewHolder, posisi: Int) {
        view.bind(list[posisi], listener)
    }
    class MainViewHolder (val view:View) :RecyclerView.ViewHolder(view) {
        val name = view.findViewById<TextView>(nameClub)
        val image = view.findViewById<ImageView>(imageClub)
        fun bind(teamModel: TeamModel, listener: (TeamModel) -> Unit) {
            name.text = teamModel.name
            Glide.with(itemView.context).load(teamModel.image).into(image)
            itemView.onClick { listener(teamModel) }
        }
    }

}

class AdapterUI :AnkoComponent<Context>{
    override fun createView(ui: AnkoContext<Context>): View  = with(ui){
        return linearLayout{
            padding = dip(8)
            imageView {
                id = R.id.imageClub
            }.lparams {
                width = dip(48)
                height = dip(48)
                rightMargin = dip(8)
            }

            textView{
                textSize = sp(12).toFloat()
                id = R.id.nameClub
            }.lparams{
                width = wrapContent
                height =  wrapContent
            }
        }
    }
}

