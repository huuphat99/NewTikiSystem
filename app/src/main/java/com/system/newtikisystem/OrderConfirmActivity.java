package com.system.newtikisystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;

public class OrderConfirmActivity extends AppCompatActivity {

    TextView textChange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_confirm);
        textChange = findViewById(R.id.textChange);
        textChange.setMovementMethod(LinkMovementMethod.getInstance());
    }

    public void changeOrder(View view){
    }
}