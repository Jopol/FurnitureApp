package com.example.joel.ikeaapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    private List<Category> mCategoryPhotos;
    final private PhotoClickListener mPhotoClickListener;

    public CategoryAdapter(List<Category> categories, PhotoClickListener mPhotoClickListener) {
        this.mCategoryPhotos = categories;
        this.mPhotoClickListener = mPhotoClickListener;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the layout
        View photoView = inflater.inflate(R.layout.image_holder, parent, false);

        return new ViewHolder(photoView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        final Category categoryPhoto = mCategoryPhotos.get(position);
        ImageView imageView = holder.mPhotoImageView;
        TextView textView = holder.mPhotoTextView;
        textView.setText(categoryPhoto.getTitle());
        System.out.println(mCategoryPhotos.get(position).describeContents());
        Picasso.get().load(mCategoryPhotos.get(position).getUrl()).into(imageView);

    }

    @Override
    public int getItemCount() {
        return (mCategoryPhotos.size());
    }

    public void swapList(List<Category> newList) {
        mCategoryPhotos = newList;
        if (newList != null) {
            // Force the RecyclerView to refresh
            this.notifyDataSetChanged();
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public ImageView mPhotoImageView;
        public TextView mPhotoTextView;
        public View view;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mPhotoImageView = (ImageView) itemView.findViewById(R.id.imageHolder);
            mPhotoTextView = (TextView) itemView.findViewById(R.id.imageTextView);
            this.view = itemView;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            mPhotoClickListener.photoOnClick(position);
        }

    }
}