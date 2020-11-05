package com.system.newtikisystem.controller;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.system.newtikisystem.R;
import com.system.newtikisystem.adapter.CartRecyclerAdapter;
import com.system.newtikisystem.adapter.OrderDetailRecyclerAdapter;
import com.system.newtikisystem.common.Common;
import com.system.newtikisystem.dao.OrderDAO;
import com.system.newtikisystem.entity.CartItem;
import com.system.newtikisystem.entity.Orders;
import com.system.newtikisystem.entity.PaymentMethods;

import java.util.ArrayList;

public class OrderDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        OrderDAO dao = new OrderDAO();
        Common common = new Common();
        RecyclerView recyclerView = findViewById(R.id.order_detail_recycler_view);
        Intent intent = getIntent();
        int orderID = intent.getIntExtra("orderId", 0);

        // set data for recycler view
        ArrayList<CartItem> items = dao.getCartItemsByOrder(orderID);
        // TODO get first image of each product, products by order id
        items.add(new CartItem(20, "Logitech" + 20, "https://product.hstatic.net/1000026716/product/gvn_log_g304_3df28cd60a48412b8fb1d2ff762dc6a9.png", 2, 20 * 1000000, 20 * 1000000 - 500000));

        OrderDetailRecyclerAdapter adapter = new OrderDetailRecyclerAdapter(items);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        TextView textViewOrderID = findViewById(R.id.textViewOrderID);
        TextView textViewOrderDate = findViewById(R.id.textViewOrderDate);
        TextView textViewShipDate = findViewById(R.id.textViewShipDate);
        TextView textViewAddress = findViewById(R.id.textViewAddress);
        TextView textViewPaymentMethod = findViewById(R.id.textViewPaymentMethod);
        TextView textViewStatus = findViewById(R.id.textViewStatus);
        TextView textViewTotalPrice = findViewById(R.id.textViewTotalPrice);

        // get payment method by id
        Orders order = dao.getOrderById(orderID);
        PaymentMethods paymentMethod = dao.getPaymentMethodById(order.getPaymentmethod());

        // set data for activity
        textViewOrderID.setText(Integer.toString(order.getId()));
        textViewOrderDate.setText(common.changeDateToString(order.getOrderTime()));
        textViewShipDate.setText(common.changeDateToString(order.getShipTime()));
        textViewAddress.setText(order.getDestination());
        textViewPaymentMethod.setText(paymentMethod.getName());
        textViewStatus.setText(order.isStatus() == true ? "Successful delivery" : "Shipping");
        textViewTotalPrice.setText(Integer.toString(order.getTotalPrice()));
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}