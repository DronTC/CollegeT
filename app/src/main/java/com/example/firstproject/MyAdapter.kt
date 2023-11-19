package com.example.firstproject

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class CustomAdapter(context: Activity, private val layoutResourceId: Int, private val data: List<Subject>) :
    ArrayAdapter<Subject>(context, layoutResourceId, data) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var row = convertView
        val holder: ViewHolder

        if (row == null) {
            val inflater = LayoutInflater.from(context)
            row = inflater.inflate(layoutResourceId, parent, false)

            holder = ViewHolder()
            holder.nameTextView = row.findViewById(R.id.textView_name)
            holder.timeTextView = row.findViewById(R.id.textView_time)

            row.tag = holder
        } else {
            holder = row.tag as ViewHolder
        }

        val item = data[position]
        holder.nameTextView?.text = item.name
        holder.timeTextView?.text = item.time

        return row!!
    }

    private class ViewHolder {
        var nameTextView: TextView? = null
        var timeTextView: TextView? = null
    }
}