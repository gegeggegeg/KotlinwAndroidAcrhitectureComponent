package com.chen.peter.kotlinwandroidacrhitecturecomponent.ui

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.chen.peter.kotlinwandroidacrhitecturecomponent.R

class KotlinHolder(itemVIew: View):RecyclerView.ViewHolder(itemVIew) {
    var dataText = itemVIew.findViewById<TextView>(R.id.dataText)
}