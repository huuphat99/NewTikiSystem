package com.system.newtikisystem.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.system.newtikisystem.R;
import com.system.newtikisystem.entity.CartItem;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.CartViewHolder>{

    ArrayList<CartItem> items;

    public RecyclerAdapter(ArrayList<CartItem> items){
        this.items = items;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.shop_cart_layout, parent, false);
        return new CartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
        holder.cartItemImage.setImageResource(items.get(position).getImageId());
        holder.cartItemName.setText(items.get(position).getName());
        holder.cartItemPrice.setText(Integer.toString(items.get(position).getPrice()));
        holder.cartItemSalePrice.setText(Integer.toString(items.get(position).getSale()));
        holder.cartItemQuantity.setText(Integer.toString(items.get(position).getQuantity()));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class CartViewHolder extends RecyclerView.ViewHolder {

        ImageView cartItemImage;
        TextView cartItemName, cartItemPrice, cartItemSalePrice;
        EditText cartItemQuantity;
        ImageButton decrease, increase, delete;

        public CartViewHolder(@NonNull View itemView) {
            super(itemView);
            cartItemImage = itemView.findViewById(R.id.cartItemImage);
            cartItemName = itemView.findViewById(R.id.cartItemName);
            cartItemPrice = itemView.findViewById(R.id.cartItemPrice);
            cartItemSalePrice = itemView.findViewById(R.id.cartItemSalePrice);
            cartItemQuantity = itemView.findViewById(R.id.cartItemQuantity);
            decrease = itemView.findViewById(R.id.cartItemDe);
            increase = itemView.findViewById(R.id.cartItemIn);
            decrease = itemView.findViewById(R.id.cartItemDelete);
        }
    }
}
