package com.system.newtikisystem.controller;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.system.newtikisystem.controller.HomeActivity;
import com.system.newtikisystem.R;
import com.system.newtikisystem.common.Constants;
import com.system.newtikisystem.dao.UserDAO;

import java.util.Random;

public class ForgetPasswordActivity extends AppCompatActivity {
    EditText textUser;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
        getSupportActionBar().hide();
        ActivityCompat.requestPermissions(ForgetPasswordActivity.this, new String[]{Manifest.permission.SEND_SMS, Manifest.permission.READ_SMS},
                PackageManager.PERMISSION_GRANTED);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        textUser = findViewById(R.id.getUser);
        textView = findViewById(R.id.textStatus);
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

    public void checkUser(View view) {
        boolean checkUser;
        String email = textUser.getText().toString();
        UserDAO userDAO = new UserDAO();
        try {
            checkUser = userDAO.checkUserForget(email);

            if (checkUser == true && !email.trim().equals("")) {
                SmsManager sendSms = SmsManager.getDefault();
                String random = Constants.getRandomNumber.numberRandom;
                Constants.accountSave.emailAccount = email;
                sendSms.sendTextMessage(email, null, random, null, null);
                Intent intent = new Intent(ForgetPasswordActivity.this, ChangePasswordActivity.class);
                intent.putExtra("sms", random);
                startActivity(intent);
            } else if(email.trim().equals("")) {
                textView.setText("Please enter your email address or phone number!");
            } else {
                textView.setText("Please re-enter email or phone number!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}