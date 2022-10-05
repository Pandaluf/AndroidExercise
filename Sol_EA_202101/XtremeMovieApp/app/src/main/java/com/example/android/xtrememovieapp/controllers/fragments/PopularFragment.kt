package com.example.android.xtrememovieapp.controllers.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android.xtrememovieapp.R
import com.example.android.xtrememovieapp.adapter.MovieAdapter
import com.example.android.xtrememovieapp.models.ApiResponseDetails
import com.example.android.xtrememovieapp.models.Movie
import com.example.android.xtrememovieapp.network.MovieService
import kotlinx.android.synthetic.main.fragment_movie.*
import kotlinx.android.synthetic.main.fragment_popular.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PopularFragment : Fragment() {
    var movie:List<Movie> = ArrayList()
    lateinit var recyclerView: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_popular, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView=rvPopular
        loadMovies(view.context)
    }

    private fun loadMovies(context: Context) {
        val retrofit= Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val movieService: MovieService = retrofit.create(MovieService::class.java)
        val request=movieService.getMovies()
        request.enqueue(object : Callback<ApiResponseDetails>{
            override fun onFailure(call: Call<ApiResponseDetails>, t: Throwable) {
                Log.d("Activity Fail", "Error: $t")
            }

            override fun onResponse(
                call: Call<ApiResponseDetails>,
                response: Response<ApiResponseDetails>
            ) {
                if(response.isSuccessful){
                    val movies: List<Movie> = response.body()!!.results?:ArrayList()
                    recyclerView.layoutManager= LinearLayoutManager(context)
                    recyclerView.adapter= MovieAdapter(movies, context)
                } else{
                    Log.d("Activity fail", "Error: "+response.code())
                }
            }
        })
    }


}