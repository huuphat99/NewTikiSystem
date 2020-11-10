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
import com.system.newtikisystem.entity.Products;

import java.util.ArrayList;

public class RecyclerAdapterListProduct extends RecyclerView.Adapter<RecyclerAdapterListProduct.ViewHolder>  {

    ArrayList<Products> products;

    public RecyclerAdapterListProduct(ArrayList<Products> products) {
        this.products = products;
    }

    @NonNull
    @Override
    public RecyclerAdapterListProduct.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_product_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapterListProduct.ViewHolder holder, int position) {
        holder.lpName.setText(products.get(position).getName());
        holder.lpPrice.setText(Integer.toString(products.get(position).getPrice()));
        Picasso.get().load(products.get(position).getImageUrl()).into(holder.lpImage);
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public class ViewHolder  extends RecyclerView.ViewHolder {
        ImageView lpImage;
        TextView lpName, lpPrice;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            lpName = itemView.findViewById(R.id.lpName);
            lpPrice = itemView.findViewById(R.id.lpPrice);
            lpImage = itemView.findViewById(R.id.lpImageView);
        }
    }
}
