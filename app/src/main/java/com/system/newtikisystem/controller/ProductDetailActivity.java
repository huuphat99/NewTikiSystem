package com.system.newtikisystem.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.smarteist.autoimageslider.SliderView;
import com.system.newtikisystem.R;
import com.system.newtikisystem.entity.ImageSliderModel;

import java.util.ArrayList;
import java.util.List;

public class ProductDetailActivity extends AppCompatActivity {

    SliderView sliderView;
    List<ImageSliderModel> imageSliderModelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        //ads auto slider
        imageSliderModelList = new ArrayList<>();
        sliderView = findViewById(R.id.imageSlider);

        imageSliderModelList.add(new ImageSliderModel(R.drawable.dell1));
        imageSliderModelList.add(new ImageSliderModel(R.drawable.dell2));
        imageSliderModelList.add(new ImageSliderModel(R.drawable.dell1));

        sliderView.setSliderAdapter(new ImageSliderAdapter(this,imageSliderModelList));
    }
}