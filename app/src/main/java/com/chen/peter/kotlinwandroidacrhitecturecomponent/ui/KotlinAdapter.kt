package com.chen.peter.kotlinwandroidacrhitecturecomponent.ui

import android.arch.paging.PagedListAdapter
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.chen.peter.kotlinwandroidacrhitecturecomponent.R
import com.chen.peter.kotlinwandroidacrhitecturecomponent.data.KotlinDiffCallBack
import com.chen.peter.kotlinwandroidacrhitecturecomponent.data.KotlinEntity

open class KotlinAdapter :PagedListAdapter<KotlinEntity,KotlinHolder>{

    constructor():super(KotlinDiffCallBack())

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KotlinHolder {
        var inflater = parent.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        return KotlinHolder(inflater.inflate(R.layout.holder_layout,parent,false))
    }

    override fun onBindViewHolder(holder: KotlinHolder, position: Int) {
      holder.dataText.text = getItem(position)?.data
    }

}