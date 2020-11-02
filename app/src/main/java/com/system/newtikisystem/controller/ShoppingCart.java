package com.system.newtikisystem.controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.system.newtikisystem.R;
import com.system.newtikisystem.adapter.RecyclerAdapter;
import com.system.newtikisystem.entity.CartItem;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class ShoppingCart extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);

        RecyclerView recyclerView = findViewById(R.id.cartRecyclerView);
        ArrayList<CartItem> items = new ArrayList<>();

        for(int i = 1; i < 10; i++){
            items.add(new CartItem(i, "Logitech" + i, getResId("i1", R.drawable.class), 2, i * 1000000, i* 1000000 - 500000));
        }

        RecyclerAdapter adapter= new RecyclerAdapter(items);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    public static int getResId(String resName, Class<?> c) {
        try {
            Field idField = c.getDeclaredField(resName);
            return idField.getInt(idField);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}