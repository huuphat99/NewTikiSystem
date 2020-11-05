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
import com.system.newtikisystem.entity.Orders;
import com.system.newtikisystem.entity.Products;

import java.util.ArrayList;

public class OrderHistoryRecyclerAdapter extends RecyclerView.Adapter<OrderHistoryRecyclerAdapter.OrderHisViewHolder> {

    ArrayList<Orders> orderItems;
    // get Product of order
    String productNames ;

    public OrderHistoryRecyclerAdapter(ArrayList<Orders> OrderItems, String productNames) {
        this.orderItems = OrderItems;
        this.productNames = productNames;
    }

    @NonNull
    @Override
    public OrderHisViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.order_history_item, parent, false);
        return new OrderHisViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderHisViewHolder holder, int position) {
        holder.orderHisProductsName.setText(productNames);
        holder.orderHisId.setText(Integer.toString(orderItems.get(position).getId()));
        holder.orderHisOrderDate.setText((CharSequence) orderItems.get(position).getOrderTime());
        String status = orderItems.get(position).isStatus() == true ? "Successful delivery" : "Shipping";
        holder.orderHisStatus.setText(status);
    }

    @Override
    public int getItemCount() {
        return orderItems.size();
    }

    public class OrderHisViewHolder extends RecyclerView.ViewHolder {

        TextView orderHisProductsName, orderHisId, orderHisOrderDate, orderHisStatus;

        public OrderHisViewHolder(@NonNull View itemView) {
            super(itemView);
            orderHisProductsName = itemView.findViewById(R.id.order_his_name);
            orderHisId = itemView.findViewById(R.id.order_his_id);
            orderHisOrderDate = itemView.findViewById(R.id.order_his_order_date);
            orderHisStatus = itemView.findViewById(R.id.order_his_status);
        }
    }
}
