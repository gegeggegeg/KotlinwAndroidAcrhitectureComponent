package com.chen.peter.kotlinwandroidacrhitecturecomponent.ui

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.chen.peter.kotlinwandroidacrhitecturecomponent.R
import com.chen.peter.kotlinwandroidacrhitecturecomponent.viewModel.KotlinViewModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var viewModel: KotlinViewModel = ViewModelProviders.of(this).get(KotlinViewModel::class.java)
        var recyclerView1 = findViewById<RecyclerView>(R.id.recyckerView1)
        recyclerView1.layoutManager = object: LinearLayoutManager(this){}
        val adapter = KotlinAdapter()
        recyclerView1.adapter = adapter
        viewModel.getPagedListLiveData().observe(this, Observer { kotlinEntity->
            if(kotlinEntity != null) adapter.submitList(kotlinEntity)
        })
    }
}
