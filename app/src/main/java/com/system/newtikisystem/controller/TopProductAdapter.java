package com.system.newtikisystem.controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.system.newtikisystem.R;
import com.system.newtikisystem.entity.Product;

import java.util.List;

//Xử lý việc đưa itemList vào trong imageView
public class TopProductAdapter extends RecyclerView.Adapter<TopProductAdapter.TopSaleProductViewHolder> {

    Context context;
    List<Product> productsList;

    public TopProductAdapter(Context context, List<Product> productsList) {
        this.context = context;
        this.productsList = productsList;
    }

    @NonNull
    @Override  //Code cho nay la gi nhi?
    public TopSaleProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.topproduct_row_items,parent,false);
        return new TopSaleProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TopSaleProductViewHolder holder, int position) {

        holder.topSaleImageView.setImageResource(productsList.get(position).getImageurl());

    }

    @Override
    public int getItemCount() {
        return productsList.size();
        //return 5;
    }

    public static class TopSaleProductViewHolder extends RecyclerView.ViewHolder{

        ImageView topSaleImageView;

        public TopSaleProductViewHolder(@NonNull View itemView) {
            super(itemView);

            topSaleImageView = itemView.findViewById(R.id.categoryImage);
        }
    }
}
