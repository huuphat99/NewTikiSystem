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

    Intent intent;
    Bundle bundle;
    EditText edtShipAddress;
    EditText edtShipName;
    EditText edtShipPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shipping_adress);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        edtShipAddress = findViewById(R.id.edtShipAddress);
        edtShipName = findViewById(R.id.edtShipName);
        edtShipPhone = findViewById(R.id.edtShipPhone);
        intent = getIntent();
        bundle = intent.getExtras();
        if (bundle != null) {
            edtShipAddress.setText(bundle.getString("edtShipAddress"));
            edtShipName.setText(bundle.getString("edtShipName"));
            edtShipPhone.setText(bundle.getString("edtShipPhone"));
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

    public void onConfirmAddressClick(View view) {
        Intent intent = new Intent(this, PaymentMethodActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("edtShipAddress", edtShipAddress.getText().toString());
        bundle.putString("edtShipName", edtShipName.getText().toString());
        bundle.putString("edtShipPhone", edtShipPhone.getText().toString());
        intent.putExtras(bundle);
        startActivity(intent);
    }
}