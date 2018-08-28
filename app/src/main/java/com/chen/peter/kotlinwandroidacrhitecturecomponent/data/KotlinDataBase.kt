package com.chen.peter.kotlinwandroidacrhitecturecomponent.data

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters

@Database (entities = [KotlinEntity::class],version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class KotlinDataBase: RoomDatabase() {
    abstract fun KotlinDao():KotlinDao
}