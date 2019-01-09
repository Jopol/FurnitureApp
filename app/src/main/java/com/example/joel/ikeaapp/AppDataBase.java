package com.example.joel.ikeaapp;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {Category.class}, version = 1,exportSchema = false)
public abstract class AppDataBase extends RoomDatabase {

    public abstract CategoryDao categoryDao();
    private final static String NAME_DATABASE = "category_db";

    //Static instance
    private static AppDataBase sInstance;

    public static AppDataBase getInstance(Context context) {
        if (sInstance == null) {
            sInstance = Room.databaseBuilder(context, AppDataBase.class, NAME_DATABASE)
                    .build();
        }
        return sInstance;
    }
}
