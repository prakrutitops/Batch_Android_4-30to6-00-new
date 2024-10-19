package com.example.rmom

import io.realm.DynamicRealm
import io.realm.RealmMigration

class MyMigration : RealmMigration {
    override fun migrate(realm: DynamicRealm, oldVersion: Long, newVersion: Long) {
        var schema = realm.schema

        if (oldVersion == 0L)
        {
            // Your migration logic here (if needed)
            //oldVersion++
        }
    }
}
