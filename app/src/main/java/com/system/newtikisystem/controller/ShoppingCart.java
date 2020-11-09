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
import com.system.newtikisystem.common.Constants;
import com.system.newtikisystem.entity.CartItem;
import com.system.newtikisystem.entity.PersonalCartItems;

import java.util.ArrayList;

public class ShoppingCart extends AppCompatActivity implements CartRecyclerAdapter.OnHandleCartItemListener {

    PersonalCartItems pCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);
        RecyclerView recyclerView = findViewById(R.id.cartRecyclerView);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        for (PersonalCartItems p : Constants.personalCart.listPersonalCartItems) {
            if (p.getEmail() == "123123@gmail.com") {
                pCart = p;
            }
        }

        CartRecyclerAdapter adapter = new CartRecyclerAdapter(pCart.getCartItems(), this);
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
        int quantity = pCart.getCartItems().get(position).getQuantity();
        pCart.getCartItems().get(position).setQuantity(quantity - 1);
        recreate();
    }

    @Override
    public void onIncreaseQuantityClick(int position) {
        int quantity = pCart.getCartItems().get(position).getQuantity();
        pCart.getCartItems().get(position).setQuantity(quantity + 1);
        recreate();
    }

    @Override
    public void onDeleteClick(int position) {
        int id = pCart.getCartItems().get(position).getId();
        Constants.personalCart.listPersonalCartItems.remove(id);
    }
}