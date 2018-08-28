package com.chen.peter.kotlinwandroidacrhitecturecomponent.data

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import javax.sql.DataSource

@Dao
interface KotlinDao {

    @Insert
    public fun insertData(data: KotlinEntity):Long

    @Update
    public fun updateData(data: KotlinEntity):Int

    @Query(" DELETE FROM KotlinTable WHERE data=:input ")
    public fun deleteData(input:String)

    @Query("SELECT * FROM KotlinTable")
    public fun selectAll(): LiveData<List<KotlinEntity>>

    @Query("SELECT * FROM KotlinTable")
    public fun checkEmpty(): List<KotlinEntity>

    @Query("SELECT * FROM KotlinTable")
    public fun getPagelistData():android.arch.paging.DataSource.Factory<Int,KotlinEntity>

    @Query("DELETE FROM KotlinTable")
    public fun deleteAll()

}