package com.system.newtikisystem.controller;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.system.newtikisystem.R;
import com.system.newtikisystem.adapter.OrderHistoryRecyclerAdapter;
import com.system.newtikisystem.common.Constants;
import com.system.newtikisystem.dao.OrderDAO;
import com.system.newtikisystem.entity.Orders;
import com.system.newtikisystem.entity.Products;

import org.w3c.dom.Text;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderHistoryActivity extends AppCompatActivity implements OrderHistoryRecyclerAdapter.OnViewDetailListener {

    ArrayList<Orders> orders;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_history);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

//        String email = Constants.accountSave.emailAccount;

        OrderDAO orderDAO = new OrderDAO();
        orders = orderDAO.getOrdersByEmail(Constants.accountSave.emailAccount);

        ArrayList<String> productNames = new ArrayList<>();
        for (Orders order : orders) {
            ArrayList<Products> products = orderDAO.getProductsByOrder(order.getId());
            productNames.add(orderDAO.getNameOfListProducts(products));
        }

        RecyclerView recyclerView = findViewById(R.id.orderHisRecyclerView);
        OrderHistoryRecyclerAdapter adapter = new OrderHistoryRecyclerAdapter(orders, productNames, this);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
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

    @Override
    public void onViewDetailClick(int position) {
        Intent intent = new Intent(this, OrderDetailActivity.class);
        try {
            intent.putExtra("orderId", orders.get(position).getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
        startActivity(intent);
    }
}