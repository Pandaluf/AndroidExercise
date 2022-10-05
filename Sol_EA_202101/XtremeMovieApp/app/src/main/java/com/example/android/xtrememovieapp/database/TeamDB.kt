package com.example.android.xtrememovieapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.android.xtrememovieapp.models.Movie

@Database(entities=[Movie::class], version=1)
abstract class MovieDB: RoomDatabase() {
    abstract fun getMovieDAO():MovieDao
    companion object {
        private var INSTANCE: MovieDB?=null
        fun getInstance(context: Context):MovieDB{
            if(INSTANCE==null){
                INSTANCE=Room
                        .databaseBuilder(context, MovieDB::class.java, "movie.db")
                        .allowMainThreadQueries()
                        .build()
            }
            return INSTANCE as MovieDB
        }
    }
}