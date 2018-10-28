/*
 * Copyright (c) 2018.
 * Gilang Ramadhan (gilang@imastudio.co.id)
 */

package com.google.aplikasifootball.network

import java.net.URL

class  ApiRepository {
    fun doRequest(url :String) :String{
        return URL(url).readText()
    }
}