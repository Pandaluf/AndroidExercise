package com.example.android.xtrememovieapp.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity(tableName = "movies")
class Movie(
    @PrimaryKey
    @SerializedName("id")
    var movie_id: Int,
    @SerializedName("title")
    var title: String,
    @SerializedName("overview")
    var overview: String,
    @SerializedName("popularity")
    var popularity: Float
): Serializable