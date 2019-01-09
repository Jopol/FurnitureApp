package com.example.joel.ikeaapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class CartActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private FurnitureAdapter mAdapter;
    private List<Furniture> cartItems;
    private Button clearButton;
    private String cartTitle,cartPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cart_activity);

        cartItems = new ArrayList<>();

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);
        mRecyclerView = findViewById(R.id.cartRV);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(layoutManager);

        clearButton = findViewById(R.id.clearButton);
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cartItems.clear();
                updateUI();
            }
        });

        receiveData();
    }

    private void updateUI() {
        if (mAdapter == null) {
            mAdapter = new FurnitureAdapter(this,cartItems);
            mRecyclerView.setAdapter(mAdapter);
        } else {
            mAdapter.notifyDataSetChanged();
        }
    }

    private void receiveData()
    {
        //RECEIVE DATA VIA INTENT
        Intent i = getIntent();
        cartTitle = i.getStringExtra("NAME_KEY");
        cartPrice = i.getStringExtra("PRICE_KEY");

        addToAdapter(cartTitle, cartPrice);
        updateUI();

        System.out.println(cartItems);
    }

    private void addToAdapter(String name, String price){
        Furniture listItem = new Furniture(name,price);
        cartItems.add(listItem);
    }

}
