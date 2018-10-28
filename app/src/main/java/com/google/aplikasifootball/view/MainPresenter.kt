/*
 * Copyright (c) 2018.
 * Gilang Ramadhan (gilang@imastudio.co.id)
 */

package com.google.aplikasifootball.view

import com.google.aplikasifootball.model.TeamResponse
import com.google.aplikasifootball.network.ApiRepository
import com.google.aplikasifootball.network.DbApi
import com.google.gson.Gson
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class MainPresenter(private val view: MainView, val apiRepository: ApiRepository, val gson: Gson) {
    fun getTeamList(league: String) {
        view.showLoading()
        doAsync {
            val data = gson.fromJson(apiRepository.doRequest(DbApi.getTeams(league)), TeamResponse::class.java)
        uiThread {
            view.showLoading()
            view.showTeamList(data.teams)
        }
        }
    }
}