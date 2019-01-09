package com.example.joel.ikeaapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class FurnitureAdapter extends RecyclerView.Adapter<FurnitureAdapter.FurnitureViewHolder> {

    private Context context;
    public List<Furniture> cartListItem;

    public FurnitureAdapter(Context context, List<Furniture> cartListItem) {
        this.context = context;
        this.cartListItem = cartListItem;
    }

    @NonNull
    @Override
    public FurnitureViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new FurnitureViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FurnitureViewHolder holder, int position) {
        // Gets a single item in the list from its position
        final Furniture furniture = cartListItem.get(position);
        // The holder argument is used to reference the views inside the viewHolder
        // Populate the views with the data from the list
        holder.Title.setText(furniture.getmTitle());
        holder.Price.setText(furniture.getmPrice());
    }

    @Override
    public int getItemCount() {
        return cartListItem.size();
    }{

    }
    public class FurnitureViewHolder extends RecyclerView.ViewHolder {

        public TextView Title,Price;
        public View view;

        public FurnitureViewHolder(View itemView) {

            super(itemView);
            Title = itemView.findViewById(R.id.cartTitleTextView);
            Price = itemView.findViewById(R.id.cartPriceTextView);
            view = itemView;

        }

    }
}
