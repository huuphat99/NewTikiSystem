package com.system.newtikisystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.system.newtikisystem.databases.DatabaseManager;
import com.system.newtikisystem.databases.models.Productrating;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Productrating> topicModelList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        topicModelList = DatabaseManager.getInstance(this).getListTopic();

        Log.i(String.valueOf(topicModelList), "123123123");
    }
}