package com.system.newtikisystem.controller;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.system.newtikisystem.R;
import com.system.newtikisystem.common.Constants;

public class OrderConfirmActivity extends AppCompatActivity {

    int totalCost = Constants.personalCart.totalCost();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_confirm);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        TextView textTotalPrice = findViewById(R.id.txtView23);
        textTotalPrice.setText(totalCost + " đ");
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

    public void changeOrder(View view) {
    }

    public void onNextStepOrderClick(View view) {

    }
}