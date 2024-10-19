package com.example.rmom

import android.app.Application
import io.realm.Realm
import io.realm.RealmConfiguration

class MyApplication :Application()
{
    override fun onCreate()
    {
        super.onCreate()

        Realm.init(this)

        val realmConfig = RealmConfiguration.Builder()
            .name("tops.db")
            .schemaVersion(1)
            .deleteRealmIfMigrationNeeded()
            .migration(MyMigration())
            .allowWritesOnUiThread(true)// Increment this if you change the schema
            .build()

        Realm.setDefaultConfiguration(realmConfig)

    }
}