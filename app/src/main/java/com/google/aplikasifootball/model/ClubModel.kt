/*
 * Copyright (c) 2018.
 * Gilang Ramadhan (gilang@imastudio.co.id)
 */

package com.google.aplikasifootball.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


@Parcelize
data class ClubModel(val name: String = "", val image: Int = 0, val desc: String = "") : Parcelable

@Parcelize
data class TeamModel(
    @SerializedName("idTeam")
    val teamId: String = "",
    @SerializedName("strTeam")
    val name: String = "",
    @SerializedName("strTeamBadge")
    val image: String = ""
) : Parcelable

data class TeamResponse(
    @SerializedName("teams")
    val teams: List<TeamModel> = arrayListOf()
)