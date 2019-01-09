package com.example.joel.ikeaapp;

import android.app.Activity;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements PhotoClickListener {

    private MainViewModel mMainViewModel;
    private List<Category> mCategories;
    private CategoryAdapter mAdapter;
    private RecyclerView mRecyclerView;
    private int mModifyPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);
        mRecyclerView = findViewById(R.id.categoryRV);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(layoutManager);

        mCategories = new ArrayList<>();
        mMainViewModel = new MainViewModel(getApplicationContext());
        mMainViewModel.getCategories().observe(this, new Observer<List<Category>>() {
            @Override
            public void onChanged(@Nullable List<Category> categories) {
                mCategories = categories;
                updateUI();
            }
        });

    }
    //Go to Clicked category

    public void photoOnClick(int i){
        Intent intent = new Intent( this,CategoryActivity.class);
        mModifyPosition = i;
        intent.putExtra(CategoryActivity.EXTRA_CATEGORY_PHOTO,mCategories.get(i) );
        startActivity(intent);
    }

    //update ui

    private void updateUI() {
        if (mAdapter == null) {
            for(int i = 0; i <Category.IMAGE_URLS.length;i++)
                mCategories.add(new Category(Category.IMAGE_URLS[i],
                        Category.IMAGE_TITLES[i]));
            mAdapter = new CategoryAdapter(mCategories, this);
            mRecyclerView.setAdapter(mAdapter);
           }
            mAdapter.swapList(mCategories);
        }
    }
