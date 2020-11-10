package com.system.newtikisystem.controller;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.system.newtikisystem.R;
import com.system.newtikisystem.entity.FavoriteProduct;
import com.system.newtikisystem.entity.Products;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class RecyclerAdapterFavoriteProducts extends RecyclerView.Adapter<RecyclerAdapterFavoriteProducts.ViewHolder> {
    ArrayList<FavoriteProduct> products;

    public RecyclerAdapterFavoriteProducts(ArrayList<FavoriteProduct> products) {
        this.products = products;
    }

    @NonNull
    @Override
    public RecyclerAdapterFavoriteProducts.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.favorite_product_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapterFavoriteProducts.ViewHolder holder, int position) {
        holder.fpName.setText(products.get(position).getName());
        holder.fpPrice.setText(Integer.toString(products.get(position).getPrice()));
        Picasso.get().load(products.get(position).getImageURL()).into(holder.fpImage);
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView fpImage;
        TextView fpName, fpPrice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            fpName = itemView.findViewById(R.id.fpName);
            fpPrice = itemView.findViewById(R.id.fpPrice);
            fpImage = itemView.findViewById(R.id.fpImage);
        }
    }
}
