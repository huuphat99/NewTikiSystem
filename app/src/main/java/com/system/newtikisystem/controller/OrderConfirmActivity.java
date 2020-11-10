package com.system.newtikisystem.controller;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.system.newtikisystem.R;
import com.system.newtikisystem.common.Constants;
import com.system.newtikisystem.dao.OrderDAO;

public class OrderConfirmActivity extends AppCompatActivity {

    int totalCost = Constants.personalCart.totalCost();
    Intent intent;
    Bundle bundle;
    OrderDAO dao = new OrderDAO();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_confirm);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        TextView textTotalPrice = findViewById(R.id.totalCost);
        textTotalPrice.setText(totalCost + " đ");
        intent = getIntent();
        bundle = intent.getExtras();

        TextView orderCfName = findViewById(R.id.orderCfName);
        if (bundle.getString("edtShipName") != null) {
            orderCfName.setText(bundle.getString("edtShipName"));
        }
        TextView orderCfAddress = findViewById(R.id.orderCfAddress);
        if (bundle.getString("edtShipAddress") != null) {
            orderCfAddress.setText(bundle.getString("edtShipAddress"));
        }
        TextView orderCfMethod = findViewById(R.id.orderCfMethod);
        int pId = bundle.getInt("paymentMethod");
        orderCfMethod.setText(dao.getPaymentMethodById(pId).getName());
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

    public void onNextStepOrderClick(View view) {

    }

    public void changeOrderOnClick(View view) {
        Intent intent = new Intent(this, ShoppingCart.class);
        startActivity(intent);
    }

    public void changeAddressOnClick(View view) {
        Intent intent = new Intent(this, ShippingAddressActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void changeMethodOnClick(View view) {
        Intent intent = new Intent(this, PaymentMethodActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}