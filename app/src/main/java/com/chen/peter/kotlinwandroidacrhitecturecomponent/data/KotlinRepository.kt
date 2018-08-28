package com.chen.peter.kotlinwandroidacrhitecturecomponent.data

import android.app.Application
import android.arch.lifecycle.LiveData
import android.arch.paging.DataSource
import android.arch.persistence.room.Room
import android.os.AsyncTask

class KotlinRepository(application: Application) {
    val dataAarray = arrayOf("apple","dog","cat","bear","egg","frog","goat"
            ,"hen","ice","joke","kotlin","lemon","monster","nose","orange","pig","queen","rock","system","team"
            ,"ufo","water","year","xavier","zoo")
    private var dao: KotlinDao
    init {
        var database: KotlinDataBase = Room.databaseBuilder(application,KotlinDataBase::class.java,"database").build()
        dao = database.KotlinDao()
        initData()
    }

    fun initData(){
            var task = InsertTask()
            task.execute()
    }

    fun queryLiveData():LiveData<List<KotlinEntity>>{
        return dao.selectAll()
    }

    fun getPagedListLiveData():DataSource.Factory<Int,KotlinEntity> = dao.getPagelistData()

    fun insertData(input:String){
    }

    fun deleteData(input: String){
        val task = deleteTask()
        task.execute(input)
    }

    inner class InsertTask: AsyncTask<Void,Void,Void>(){
        override fun doInBackground(vararg p0: Void?): Void? {
                for(data in dataAarray){
                    var temp = KotlinEntity(data)
                    dao.insertData(temp)
                }
            return null
        }
    }

    inner class deleteTask: AsyncTask<String,Void,Void>(){
        override fun doInBackground(vararg input: String): Void? {
            dao.deleteData(input.get(0))
            return null
        }

    }
}