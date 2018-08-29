package com.chen.peter.kotlinwandroidacrhitecturecomponent.data

import android.support.v7.util.DiffUtil

class KotlinDiffCallBack : DiffUtil.ItemCallback<KotlinEntity>(){

    override fun areItemsTheSame(oldItem: KotlinEntity?, newItem: KotlinEntity?): Boolean {
        return oldItem?._id == newItem?._id
    }

    override fun areContentsTheSame(oldItem: KotlinEntity?, newItem: KotlinEntity?): Boolean {
        return oldItem?.data == newItem?.data
    }

}