/*
 * Copyright (c) 2018.
 * Gilang Ramadhan (gilang@imastudio.co.id)
 */

package com.google.aplikasifootball

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class ClubModel(val name: String = "", val image: Int = 0, val desc: String = "") : Parcelable