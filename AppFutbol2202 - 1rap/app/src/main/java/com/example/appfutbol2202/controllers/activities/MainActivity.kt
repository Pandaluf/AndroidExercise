package com.example.appfutbol2202.controllers.activities

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appfutbol2202.R
import com.example.appfutbol2202.adapter.TeamAdapter
import com.example.appfutbol2202.network.TeamService
import com.example.appfutbolperu.models.ApiResponseHeader
import com.example.appfutbolperu.models.Team
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    lateinit var teamRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        teamRecyclerView = findViewById<RecyclerView>(R.id.rvTeam)
        loadTeams(this)
    }

    private fun loadTeams(context: Context) {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api-football-v1.p.rapidapi.com/v2/teams/league/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val teamService: TeamService
        teamService = retrofit.create(TeamService::class.java)

        val request = teamService.getTeams(
            "api-football-v1.p.rapidapi.com",
            "d229813befmsh4c1646ad132a0b5p1313fcjsn9afecaefc97e")

        request.enqueue(object : Callback<ApiResponseHeader> {
            override fun onResponse(
                call: Call<ApiResponseHeader>,
                response: Response<ApiResponseHeader>
            ) {
                val teams: List<Team> = response.body()!!.api.teams ?: ArrayList()
                teamRecyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
                teamRecyclerView.adapter = TeamAdapter(teams, context)
            }

            override fun onFailure(call: Call<ApiResponseHeader>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }
}