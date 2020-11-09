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
import com.system.newtikisystem.entity.CartItem;

import java.util.ArrayList;

public class OrderRecyclerAdapter extends RecyclerView.Adapter<OrderRecyclerAdapter.CartViewHolder>{

    ArrayList<CartItem> items;

    public OrderRecyclerAdapter(ArrayList<CartItem> items){
        this.items = items;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.order_item, parent, false);
        return new CartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
        Picasso.get().load(items.get(position).getUrl()).into(holder.orderItemImage);
        holder.orderItemName.setText(items.get(position).getName());
        holder.orderItemPrice.setText(Integer.toString(items.get(position).getPrice()));
        holder.orderItemQuantity.setText(Integer.toString(items.get(position).getQuantity()));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class CartViewHolder extends RecyclerView.ViewHolder {

        ImageView orderItemImage;
        TextView orderItemName, orderItemPrice, orderItemQuantity;

        public CartViewHolder(@NonNull View itemView) {
            super(itemView);
            orderItemImage = itemView.findViewById(R.id.orderDetailItemImage);
            orderItemName = itemView.findViewById(R.id.orderDetailItemName);
            orderItemPrice = itemView.findViewById(R.id.cartSalePrice);
            orderItemQuantity = itemView.findViewById(R.id.orderDetailItemQuantity);
        }
    }
}
