package com.chen.peter.kotlinwandroidacrhitecturecomponent.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.DialogInterface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.AlertDialog
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.MenuItem
import android.widget.EditText
import android.widget.Toast
import com.chen.peter.kotlinwandroidacrhitecturecomponent.R
import com.chen.peter.kotlinwandroidacrhitecturecomponent.viewModel.KotlinViewModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel: KotlinViewModel = ViewModelProviders.of(this).get(KotlinViewModel::class.java)

        val recyclerView1 = findViewById<RecyclerView>(R.id.recyckerView1)
        recyclerView1.layoutManager = object: LinearLayoutManager(this){}
        val adapter = KotlinAdapter()
        recyclerView1.adapter = adapter

        viewModel.getPagedListLiveData().observe(this, Observer { kotlinEntity->
            if(kotlinEntity != null) adapter.submitList(kotlinEntity)
        })

        setupDrawer(viewModel)
    }

    private fun setupDrawer(viewModel: KotlinViewModel){
        val mDrawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout)
        val mNavigationView = findViewById<NavigationView>(R.id.navigation_view)
        mNavigationView.setNavigationItemSelectedListener(object:NavigationView.OnNavigationItemSelectedListener {
            override fun onNavigationItemSelected (item:MenuItem):Boolean{
                when (item.itemId){
                    R.id.deleteTable-> viewModel.deleteAllData()
                    R.id.insert -> showDialog(viewModel)
                    R.id.about -> Toast.makeText(this@MainActivity,"about this app",Toast.LENGTH_SHORT).show()
                }
                mDrawerLayout.closeDrawer(GravityCompat.START)
                return true
            }
        })
    }

    private fun showDialog(viewModel: KotlinViewModel){
        val builder = AlertDialog.Builder(this)
        val editText = EditText(this)
        builder.setTitle("Enter data")
                .setView(editText)
                .setPositiveButton("Insert",object :DialogInterface.OnClickListener{
                    override fun onClick(dialogInterface: DialogInterface?, i: Int) {
                        viewModel.insertData(editText.text.toString())
                    }
                }).setNegativeButton("cancel",object :DialogInterface.OnClickListener{
                    override fun onClick(p0: DialogInterface?, p1: Int) {
                        // do nothing
                    }
                })
        val dialog = builder.create()
        dialog.show()
    }
}
