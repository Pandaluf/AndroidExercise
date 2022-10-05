package com.example.android.xtrememovieapp.database

import androidx.room.*
import com.example.android.xtrememovieapp.models.Movie

@Dao
interface MovieDao {
    @Insert
    fun insertMovie(vararg movie: Movie)
    @Query("SELECT * FROM movies")
    fun getAllMovies(): List<Movie>
    @Delete
    fun deleteMovie(vararg movie: Movie)
    @Update
    fun updateMovie(vararg movie: Movie)
}