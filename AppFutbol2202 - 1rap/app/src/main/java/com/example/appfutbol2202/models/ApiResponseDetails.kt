package com.example.appfutbolperu.models

import com.google.gson.annotations.SerializedName

class ApiResponseDetails (
    val results: Int,
    val teams: List<Team>
        )