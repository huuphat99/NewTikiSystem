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

public class PaymentMethodActivity extends AppCompatActivity {

    int totalCost = Constants.personalCart.totalCost();
    Intent intent;
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_method);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        TextView textTotalPrice = findViewById(R.id.txtView23);
        textTotalPrice.setText(totalCost + " đ");
        intent = getIntent();
        bundle = intent.getExtras();
        if (bundle != null) {

        }
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
        Intent intent = new Intent(this, PayCardActivity.class);
        startActivity(intent);
    }
}