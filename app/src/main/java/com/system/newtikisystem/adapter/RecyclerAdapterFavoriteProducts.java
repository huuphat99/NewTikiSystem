package com.system.newtikisystem.adapter;

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

import java.util.ArrayList;

public class RecyclerAdapterFavoriteProducts extends RecyclerView.Adapter<RecyclerAdapterFavoriteProducts.ViewHolder> {
    ArrayList<FavoriteProduct> products;
    private OnViewProductFavoriteListener onViewProductFavoriteListener;

    public RecyclerAdapterFavoriteProducts(ArrayList<FavoriteProduct> products, OnViewProductFavoriteListener onViewProductFavoriteListener) {
        this.products = products;
        this.onViewProductFavoriteListener = onViewProductFavoriteListener;
    }

    @NonNull
    @Override
    public RecyclerAdapterFavoriteProducts.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.favorite_product_item, parent, false);
        return new ViewHolder(view, onViewProductFavoriteListener);
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

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView fpImage;
        TextView fpName, fpPrice;
        OnViewProductFavoriteListener onViewProductFavoriteListener;

        public ViewHolder(@NonNull View itemView, OnViewProductFavoriteListener onViewProductFavoriteListener) {
            super(itemView);
            fpName = itemView.findViewById(R.id.fpName);
            fpPrice = itemView.findViewById(R.id.fpPrice);
            fpImage = itemView.findViewById(R.id.fpImage);

            this.onViewProductFavoriteListener = onViewProductFavoriteListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onViewProductFavoriteListener.onViewProductFavoriteClick(getAdapterPosition());
        }
    }

    public interface OnViewProductFavoriteListener {
        void onViewProductFavoriteClick(int position);
    }
}
