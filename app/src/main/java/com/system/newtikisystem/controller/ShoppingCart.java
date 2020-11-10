package com.system.newtikisystem.controller;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.system.newtikisystem.R;
import com.system.newtikisystem.adapter.CartRecyclerAdapter;
import com.system.newtikisystem.common.Constants;
import com.system.newtikisystem.entity.PersonalCartItems;

public class ShoppingCart extends AppCompatActivity implements CartRecyclerAdapter.OnHandleCartItemListener {

    PersonalCartItems pCart;
    int totalCost = Constants.personalCart.totalCost();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);
        RecyclerView recyclerView = findViewById(R.id.cartRecyclerView);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        pCart = Constants.personalCart.getCartOfUser();

        if (pCart.getCartItems().size() == 0) {
            Intent intent = new Intent(this, EmptyCartActivity.class);
            startActivity(intent);
        }

        CartRecyclerAdapter adapter = new CartRecyclerAdapter(pCart.getCartItems(), this);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        TextView numberItemInCart = findViewById(R.id.numberItemInCart);
        numberItemInCart.setText(Integer.toString(pCart.getCartItems().size()));
        TextView textProvisionalPrice = findViewById(R.id.textProvisionalPrice);
        textProvisionalPrice.setText(totalCost + " đ");
        TextView textTotalPrice = findViewById(R.id.totalCost);
        textTotalPrice.setText(totalCost + " đ");
    }

    public void onNextStepOrderClick(View view) {
        Intent intent = new Intent(this, ShippingAddressActivity.class);
        startActivity(intent);
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
        if (quantity != 1) {
            pCart.getCartItems().get(position).setQuantity(quantity - 1);
            recreate();
        } else {
            pCart.getCartItems().remove(position);
            recreate();
        }
    }

    @Override
    public void onIncreaseQuantityClick(int position) {
        int quantity = pCart.getCartItems().get(position).getQuantity();
        pCart.getCartItems().get(position).setQuantity(quantity + 1);
        recreate();
    }

    @Override
    public void onDeleteClick(int position) {
        pCart.getCartItems().remove(position);
        recreate();
    }
}