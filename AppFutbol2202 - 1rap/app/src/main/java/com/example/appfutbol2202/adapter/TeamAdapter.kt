package com.example.appfutbol2202.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.appfutbol2202.R
import com.example.appfutbolperu.models.Team
import com.squareup.picasso.OkHttp3Downloader
import com.squareup.picasso.Picasso
//import kotlinx.android.synthetic.main.prototype_team.view.*

class TeamAdapter(private val teams: List<Team>, private val context: Context): RecyclerView.Adapter<TeamAdapter.ViewHolder>() {
    class ViewHolder(val view: View): RecyclerView.ViewHolder(view) {
        val ivLogo = view.findViewById<ImageView>(R.id.ivLogo)
        val tvName = view.findViewById<TextView>(R.id.tvName)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
            .from(context).inflate(R.layout.prototype_team, parent, false)

        return  ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val team = teams[position]
        holder.tvName.text = team.name
        
        val picBuilder = Picasso.Builder(context)
        picBuilder.downloader(OkHttp3Downloader(context))
        picBuilder.build().load(team.logo)
            .placeholder((R.drawable.ic_launcher_background))
            .error(R.drawable.ic_launcher_background)
            .into(holder.ivLogo)
    }

    override fun getItemCount(): Int {
        return teams.size
    }
}