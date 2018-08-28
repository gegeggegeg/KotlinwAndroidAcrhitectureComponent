package com.chen.peter.kotlinwandroidacrhitecturecomponent.data

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey


@Entity(tableName = "KotlinTable")
data class KotlinEntity(
        val data : String
) {

    @PrimaryKey(autoGenerate = true)
    var _id  : Long = 0

}