package com.example.joel.ikeaapp;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;

import java.util.List;

public class MainViewModel extends ViewModel {

    private Repository mRepository;
    private LiveData<List<Category>> mCategories;

    public MainViewModel (Context context){
        mRepository = new Repository(context);
        mCategories = mRepository.getAllCategories();
    }

    public LiveData<List<Category>> getCategories() {
        return mCategories;
    }

    public void insert(Category category) {
        mRepository.insert(category);
    }

    public void update(Category category) {
        mRepository.update(category);
    }

    public void delete(Category category) {
        mRepository.delete(category);
    }

}

