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
        var task = InitTask()
        task.execute()
    }

    fun queryLiveData():LiveData<List<KotlinEntity>>{
        return dao.selectAll()
    }

    fun getPagedListLiveData():DataSource.Factory<Int,KotlinEntity> = dao.getPagelistData()

    fun insertData(input:String){
        var task = insertTask()
        task.execute(input)
    }

    fun deleteData(input: String){
        val task = deleteTask()
        task.execute(input)
    }

    fun deleteAllData(){
        val task = deleteAllTask()
        task.execute()
    }


    inner class InitTask: AsyncTask<Void,Void,Void>(){
        override fun doInBackground(vararg p0: Void?): Void? {
            if(dao.checkEmpty().isEmpty()){
                for(data in dataAarray){
                    var temp = KotlinEntity(data)
                    dao.insertData(temp)
                }
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

    inner class insertTask: AsyncTask<String,Void,Void>(){
        override fun doInBackground(vararg input: String): Void? {
            var temp = KotlinEntity(input.get(0))
            dao.insertData(temp)
            return null
        }
    }

    inner class deleteAllTask: AsyncTask<Void,Void,Void>(){
        override fun doInBackground(vararg p0: Void): Void? {
            dao.deleteAll()
            return null
        }
    }
}