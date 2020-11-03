package com.system.newtikisystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

import com.system.newtikisystem.adapter.CartRecyclerAdapter;
import com.system.newtikisystem.adapter.OrderDetailRecyclerAdapter;
import com.system.newtikisystem.entity.CartItem;

import java.util.ArrayList;

public class OrderDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        RecyclerView recyclerView = findViewById(R.id.order_detail_recycler_view);

        ArrayList<CartItem> items = new ArrayList<>();

        for (int i = 1; i < 10; i++) {
            items.add(new CartItem(i, "Logitech" + i, "https://product.hstatic.net/1000026716/product/gvn_log_g304_3df28cd60a48412b8fb1d2ff762dc6a9.png", 2, i * 1000000, i * 1000000 - 500000));
        }

        OrderDetailRecyclerAdapter adapter = new OrderDetailRecyclerAdapter(items);

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