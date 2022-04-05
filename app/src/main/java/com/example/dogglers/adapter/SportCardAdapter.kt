package com.example.dogglers.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dogglers.R
import com.example.dogglers.const.Layout
import com.example.dogglers.data.DataSource

class SportCardAdapter(
    private val context: Context?,
    private val layout: Int

): RecyclerView.Adapter<SportCardAdapter.SportCardViewHolder>() {


    val sportList = DataSource.SPORTS

    class SportCardViewHolder(view: View?): RecyclerView.ViewHolder(view!!) {
        val sportImageView : ImageView? = view?.findViewById(R.id.sport_img)
        val sportNameText : TextView? = view?.findViewById(R.id.sport_name)
        val sportAgeText : TextView? = view?.findViewById(R.id.sport_type)
        val sportHobbyText : TextView? = view?.findViewById(R.id.sport_spek)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SportCardViewHolder {

        val adapterLayout = when (layout) {
            Layout.GRID -> LayoutInflater.from(parent.context).inflate(R.layout.grid_list_item, parent, false)
            else -> LayoutInflater.from(parent.context).inflate(R.layout.vertical_horizontal_list_item, parent, false)
        }
        return SportCardViewHolder(adapterLayout)
    }

    override fun getItemCount(): Int {
        return sportList.size
    }

    override fun onBindViewHolder(holder: SportCardViewHolder, position: Int) {
        val sportData = sportList[position]
        holder.sportImageView?.setImageResource(sportData.imageResourceId)
        holder.sportNameText?.text = sportData.name
        val resources = context?.resources
        holder.sportAgeText?.text = resources?.getString(R.string.sport_type, sportData.type)

        holder.sportHobbyText?.text = resources?.getString(R.string.sport_spek, sportData.spek)
    }
}
