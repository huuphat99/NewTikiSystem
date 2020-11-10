package com.system.newtikisystem.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.system.newtikisystem.R;
import com.system.newtikisystem.common.Constants;
import com.system.newtikisystem.dao.UserDAO;

public class ChangePasswordActivity extends AppCompatActivity {

    EditText newPassword, retypeNewPass, code;
    TextView alertPass;
    public static final String MY_PREFS_NAME = "MyPrefsFile";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        newPassword = findViewById(R.id.newPassword);
        retypeNewPass = findViewById(R.id.retypeNewPassword);
        code = findViewById(R.id.codeCheck);
        alertPass = findViewById(R.id.alertPass);
        Intent intent = new Intent();
        intent.getExtras();
    }

    public void onClickChange(View view){
        if(Constants.getRandomNumber.numberCheck == Integer.parseInt(code.getText().toString())){
            String password1 = newPassword.getText().toString();
            String password2 = retypeNewPass.getText().toString();
            UserDAO userDAO = new UserDAO();

            userDAO.updatePassword(password1, Constants.accountSave.emailAccount);
            Intent intent = new Intent(ChangePasswordActivity.this, MainActivity.class);
            startActivity(intent);
//            } else if(password1 != password2){
//                alertPass.setText("Please check password or code");
//            }
        } else if(Constants.getRandomNumber.numberCheck != Integer.parseInt(code.getText().toString())) {
            Toast.makeText(this, "Random Number is wrong", Toast.LENGTH_LONG).show();
        }

        SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        String name = prefs.getString("name", "No name defined");//"No name defined" is the default value.
        int idName = prefs.getInt("idName", 0);
    }
}