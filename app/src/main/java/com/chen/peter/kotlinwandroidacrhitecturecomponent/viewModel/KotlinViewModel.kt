package com.chen.peter.kotlinwandroidacrhitecturecomponent.viewModel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.paging.LivePagedListBuilder
import android.arch.paging.PagedList
import com.chen.peter.kotlinwandroidacrhitecturecomponent.data.KotlinEntity
import com.chen.peter.kotlinwandroidacrhitecturecomponent.data.KotlinRepository


open class KotlinViewModel(application: Application): AndroidViewModel(application) {

    val mRepository:KotlinRepository = KotlinRepository(application)

    public fun getLivData():LiveData<List<KotlinEntity>> =  mRepository.queryLiveData()

    public fun getPagedListLiveData():LiveData<PagedList<KotlinEntity>>{
        var pagedList:LiveData<PagedList<KotlinEntity>>
                = LivePagedListBuilder(mRepository.getPagedListLiveData(),30).build()
        return pagedList
    }

    public fun deleteData(input: String){
        mRepository.deleteData(input)
    }

    public fun deleteAllData(){
        mRepository.deleteAllData()
    }

    public fun insertData(input: String){
        mRepository.insertData(input)
    }

}