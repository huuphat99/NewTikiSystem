package com.system.newtikisystem.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.system.newtikisystem.R;
import com.system.newtikisystem.common.Constants;
import com.system.newtikisystem.dao.UserDAO;
import com.system.newtikisystem.entity.User;


public class MainActivity extends AppCompatActivity {
    EditText txtUsername, txtPassword, txtForgetPassword, txtCreateAccount;
    Button btnLogin;
    TextView alert;
    private FirebaseAuth mFirebase;
    boolean Islogin;
    SharedPreferences prefs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtUsername = findViewById(R.id.txtEmail);
        txtPassword = findViewById(R.id.txtPassword);
        alert = findViewById(R.id.alert);
        txtCreateAccount = findViewById(R.id.txtCreateAccount);
        txtCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        txtForgetPassword = findViewById(R.id.txtForgetPassword);
        txtForgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MainActivity.this, ForgetPasswordActivity.class);
                startActivity(intent1);
            }
        });

        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        Islogin = prefs.getBoolean("Islogin", false);
        Islogin = Constants.statusLogin.checkLogin;
        if(Islogin) {
            Log.i("message: ", "da  login");
        }
        else {
            Log.i("message: ", "Chua login");
        }
    }

    public void OnClickLogin(View view){
        UserDAO userDAO = new UserDAO();
        User user;
        try {
            user = userDAO.checkLogin(txtUsername.getText().toString(), txtPassword.getText().toString());
            if(user != null){
                prefs.edit().putBoolean("Islogin", true);
                prefs.edit().commit();
                Islogin = true;
                Constants.statusLogin.checkLogin = Islogin;
                if(Constants.statusLogin.checkLogin){
                    Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                    startActivity(intent);
                    Log.i("message: ", "da login");
                    Toast.makeText(this, "Logged in", Toast.LENGTH_LONG).show();
                }
            } else {
                alert.setText("Email or Password is wrong!");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}