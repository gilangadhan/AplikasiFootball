/*
 * Copyright (c) 2018.
 * Gilang Ramadhan (gilang@imastudio.co.id)
 */

package com.google.aplikasifootball.view

import com.google.aplikasifootball.model.TeamModel

interface MainView{
    fun showLoading()
    fun hideLoading()
    fun showTeamList(data : List<TeamModel>)
}