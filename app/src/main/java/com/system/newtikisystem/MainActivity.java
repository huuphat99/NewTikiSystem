package com.system.newtikisystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.system.newtikisystem.dao.UserDAO;
import com.system.newtikisystem.entity.Productrating;
import com.system.newtikisystem.entity.User;


public class MainActivity extends AppCompatActivity {
    TextView textView3;
    EditText textView1, textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView1 = findViewById(R.id.username);
        textView2 = findViewById(R.id.password);
        textView3 = findViewById(R.id.textView3);
    }

    public void onClick(View view) {
        UserDAO proDAO = new UserDAO();
        User product;
        try {
            product = proDAO.getData(textView1.getText().toString(), textView2.getText().toString());
            if (product == null) {
                textView3.setText("Null roi dm ");
            } else {
                textView3.setText("Co du lieu roi");
                Intent intent = new Intent(this, ShoppingCart.class);
                startActivity(intent);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}