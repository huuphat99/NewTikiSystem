package com.system.newtikisystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

import com.system.newtikisystem.adapter.OrderHistoryRecyclerAdapter;
import com.system.newtikisystem.entity.Orders;
import com.system.newtikisystem.entity.Products;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class OrderHistoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_history);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        RecyclerView recyclerView = findViewById(R.id.orderHisRecyclerView);

        ArrayList<Orders> items = new ArrayList<>();
        ArrayList<Products> products = new ArrayList<>();
        String productNames = "";

        for (int i = 1; i < 10; i++) {
            items.add(new Orders(i, "email" + i, null, null, "Bac Ninh", 1000, true, 0));
        }

        for (int i = 1; i < 10; i++) {
            products.add(new Products(i, "Product" + i, "Description" + i, true, 1, 1, 1000000, 2, null, "Producer" + i, "Origin" + i, "guarantee" + i, "specifications" + i));
        }

        for (int i = 0; i < products.size() - 1; i++) {
            productNames += products.get(i).getName() + " + ";
        }
        productNames += products.get(products.size() - 1);

        OrderHistoryRecyclerAdapter adapter = new OrderHistoryRecyclerAdapter(items, productNames);
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
}