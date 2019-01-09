package com.example.joel.ikeaapp;

import android.arch.lifecycle.LiveData;
import android.content.Context;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Repository {
    private AppDataBase mAppDataBase;
    private CategoryDao mCategoryDao;
    private LiveData<List<Category>> mCategories;
    private Executor mExecutor = Executors.newSingleThreadExecutor();

    public Repository(Context context) {
        mAppDataBase = mAppDataBase.getInstance(context);
        mCategoryDao = mAppDataBase.categoryDao();
        mCategories = mCategoryDao.getAllCategories();
    }

    public LiveData<List<Category>> getAllCategories(){
        return mCategories;
    }

    public void insert(final Category category){
        mExecutor.execute(new Runnable(){
            @Override
            public void run(){
                mCategoryDao.insertCategories(category);
            }
        });
    }
    public void update(final Category category) {
        mExecutor.execute(new Runnable() {
            @Override
            public void run() {
                mCategoryDao.updateCategories(category);

            }

        });
    }

    public void delete(final Category category) {
        mExecutor.execute(new Runnable() {
            @Override
            public void run() {
                mCategoryDao.deleteCategories(category);
            }
        });
    }
}
