package com.example.diabeats

import android.app.Application
import androidx.room.Room

class DiabeatsApplication : Application() {

    companion object {
        lateinit var database: DiabeatsDatabase
            private set
    }
    override fun onCreate() {
        super.onCreate()
        database = Room
            .databaseBuilder(
                this,
                DiabeatsDatabase::class.java,
                "diabeatsDatabase"
            )
            .build() }
}
