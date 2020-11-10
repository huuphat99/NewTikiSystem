package com.system.newtikisystem.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.smarteist.autoimageslider.SliderView;
import com.system.newtikisystem.R;
import com.system.newtikisystem.dao.ProductDAO;
import com.system.newtikisystem.entity.ImageSliderModel;
import com.system.newtikisystem.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductDetailActivity extends AppCompatActivity {

    SliderView sliderView;
    List<String> imageSliderModelList;
    TextView name;
    TextView realPrice;
    TextView price;
    TextView sale;
    TextView producer;
    TextView origin;
    TextView gurantee;
    TextView description;
    TextView descriptionDetail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        name = findViewById(R.id.textViewName);
        realPrice = findViewById(R.id.textViewRealPRice);
        price = findViewById(R.id.textViewPrice);
        sale = findViewById(R.id.textViewSale);
        producer = findViewById(R.id.textViewProducer);
        origin = findViewById(R.id.textViewOrigin);
        gurantee = findViewById(R.id.textViewGuarantee);
        description = findViewById(R.id.textViewDescription);
        descriptionDetail = findViewById(R.id.textViewDescriptionDetail);

        Intent intent = getIntent();
        int productId = intent.getIntExtra("productId",-1);
        ProductDAO productDAO = new ProductDAO();
        Product product = productDAO.getProductDetail(productId);
        name.setText(product.getName());
        if(product.getSale()!=0) {
            realPrice.setText(String.valueOf((int)(product.getPrice()*product.getSale()/100)));
            price.setText(String.valueOf(product.getPrice()));
            sale.setText(String.valueOf(product.getSale())+"%");
        } else {
            realPrice.setText(String.valueOf(product.getPrice()));
        }
        producer.setText("Producer: "+ product.getProducer());
        origin.setText("Origin: "+ product.getOrigin());
        gurantee.setText("Guarantee: "+product.getGuarantee());
        descriptionDetail.setText(product.getDescription());

        //ads auto slider
        imageSliderModelList = new ArrayList<>();
        sliderView = findViewById(R.id.imageSlider);
        imageSliderModelList = productDAO.getImageUrls(productId);


        sliderView.setSliderAdapter(new ProductImageSliderAdapter(this,imageSliderModelList));
    }
}