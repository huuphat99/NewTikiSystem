package com.system.newtikisystem;

import androidx.appcompat.app.AppCompatActivity;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;

import com.system.newtikisystem.databases.DatabaseManager;
import com.system.newtikisystem.databases.models.Productrating;
import com.system.newtikisystem.databases.models.User;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Productrating> topicModelList;
    List<User> users;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        users = DatabaseManager.getInstance(this).getUsers();
        Log.d("listUser", " :" + users);

        topicModelList = DatabaseManager.getInstance(this).getListTopic();

//        Log.i(String.valueOf(topicModelList), "123123123");
    }
}