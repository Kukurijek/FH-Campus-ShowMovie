package com.example.mad03_fragments_and_navigation.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mad03_fragments_and_navigation.models.Movie

@Database(
    entities = [Movie::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase: RoomDatabase() {
    abstract val appDatabase: MovieDao
}

