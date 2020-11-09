package com.system.newtikisystem.controller;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.Toast;

import com.system.newtikisystem.R;
import com.system.newtikisystem.adapter.CartRecyclerAdapter;
import com.system.newtikisystem.entity.CartItem;

import java.util.ArrayList;

public class ShoppingCart extends AppCompatActivity implements CartRecyclerAdapter.OnHandleCartItemListener {

    ArrayList<CartItem> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);
        RecyclerView recyclerView = findViewById(R.id.cartRecyclerView);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        items = new ArrayList<>();

        for (int i = 1; i < 5; i++) {
            items.add(new CartItem(i, "Logitech" + i, "https://product.hstatic.net/1000026716/product/gvn_log_g304_3df28cd60a48412b8fb1d2ff762dc6a9.png", 2, i * 1000000, i * 1000000 - 500000));
        }

        CartRecyclerAdapter adapter = new CartRecyclerAdapter(items, this);
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
    public void onDecreaseQuantityClick(int position) {
        int quantity = items.get(position).getQuantity();
        items.get(position).setQuantity(quantity - 1);
        Toast toast = Toast.makeText(getApplicationContext(), quantity + "de", Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    public void onIncreaseQuantityClick(int position) {
        int quantity = items.get(position).getQuantity();
        items.get(position).setQuantity(quantity + 1);
        Toast toast = Toast.makeText(getApplicationContext(), quantity + "in", Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    public void onDeleteClick(int position) {
        int id = items.get(position).getId();
        Toast toast = Toast.makeText(getApplicationContext(), id + "delete", Toast.LENGTH_SHORT);
        toast.show();
    }
}