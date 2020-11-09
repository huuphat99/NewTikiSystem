package com.system.newtikisystem.controller;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.system.newtikisystem.R;
import com.system.newtikisystem.entity.PaymentMethods;

public class ShippingAddressActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shipping_adress);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
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

    public void onConfirmAddressClick(View view) {
        Intent intent = new Intent(this, PaymentMethodActivity.class);
        EditText edtShipAddress = findViewById(R.id.edtShipAddress);
        EditText edtShipName = findViewById(R.id.edtShipName);
        EditText edtShipPhone = findViewById(R.id.edtShipPhone);
        Bundle bundle = new Bundle();
        bundle.putString("edtShipAddress", edtShipAddress.getText().toString());
        bundle.putString("edtShipName", edtShipName.getText().toString());
        bundle.putString("edtShipPhone", edtShipPhone.getText().toString());
        intent.putExtras(bundle);
        startActivity(intent);
    }
}