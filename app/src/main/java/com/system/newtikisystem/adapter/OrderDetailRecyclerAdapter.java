package com.system.newtikisystem.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.system.newtikisystem.R;
import com.system.newtikisystem.entity.CartItem;

import java.util.ArrayList;

public class OrderDetailRecyclerAdapter extends RecyclerView.Adapter<OrderDetailRecyclerAdapter.OrderDetailViewHolder> {

    ArrayList<CartItem> items;
    private OnRateProductListener mOnRateProductListener;

    public OrderDetailRecyclerAdapter(ArrayList<CartItem> items, OnRateProductListener onRateProductListener) {
        this.items = items;
        this.mOnRateProductListener = onRateProductListener;
    }

    @NonNull
    @Override
    public OrderDetailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.order_detail_item, parent, false);
        return new OrderDetailViewHolder(view, mOnRateProductListener);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderDetailViewHolder holder, int position) {
        Picasso.get().load(items.get(position).getUrl()).into(holder.orderDetailItemImage);
        holder.orderDetailItemName.setText(items.get(position).getName());
        holder.orderDetailItemPrice.setText(Integer.toString(items.get(position).getPrice()));
        holder.orderDetailItemQuantity.setText(Integer.toString(items.get(position).getQuantity()));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class OrderDetailViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView orderDetailItemImage;
        TextView orderDetailItemName, orderDetailItemPrice, orderDetailItemQuantity;
        OnRateProductListener onRateProductListener;
        Button rateDetailButton;

        public OrderDetailViewHolder(@NonNull View itemView, OnRateProductListener onRateProductListener) {
            super(itemView);
            orderDetailItemImage = itemView.findViewById(R.id.orderDetailItemImage);
            orderDetailItemName = itemView.findViewById(R.id.orderDetailItemName);
            orderDetailItemPrice = itemView.findViewById(R.id.orderDetailItemPrice);
            orderDetailItemQuantity = itemView.findViewById(R.id.orderDetailItemQuantity);
            rateDetailButton = itemView.findViewById(R.id.rateDetailButton);

            this.onRateProductListener = onRateProductListener;
            rateDetailButton.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onRateProductListener.onRateProductClick(getAdapterPosition());
        }
    }

    public interface OnRateProductListener {
        void onRateProductClick(int position);
    }
}
