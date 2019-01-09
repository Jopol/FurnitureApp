package com.example.joel.ikeaapp;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface CategoryDao {

    @Query("SELECT * FROM category")
    public LiveData<List<Category>> getAllCategories();

    @Insert
    public void insertCategories(Category category);

    @Delete
    public void deleteCategories(Category category);

    @Update
    public void updateCategories(Category category);

}
