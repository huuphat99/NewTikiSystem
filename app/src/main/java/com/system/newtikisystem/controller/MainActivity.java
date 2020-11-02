package com.system.newtikisystem.controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.smarteist.autoimageslider.SliderView;
import com.system.newtikisystem.R;
import com.system.newtikisystem.entity.ImageSliderModel;
import com.system.newtikisystem.entity.Product;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    SliderView sliderView;
    List<ImageSliderModel> imageSliderModelList;

    //top sale
    RecyclerView topSaleRecyclerView;
    TopProductAdapter topSaleProductAdapter;
    List<Product> topSaleProductList;

    //top new
    RecyclerView topNewRecyclerView;
    TopProductAdapter topNewProductAdapter;
    List<Product> topNewProductList;

    //top selled
    RecyclerView topSellRecyclerView;
    TopProductAdapter topSellProductAdapter;
    List<Product> topSellProductList;
    //top selled 1
    RecyclerView topSell1RecyclerView;
    TopProductAdapter topSell1ProductAdapter;
    List<Product> topSell1ProductList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ads auto slider
        imageSliderModelList = new ArrayList<>();
        sliderView = findViewById(R.id.imageSlider);

        imageSliderModelList.add(new ImageSliderModel(R.drawable.slideshow_1));
        imageSliderModelList.add(new ImageSliderModel(R.drawable.slideshow_4));
        imageSliderModelList.add(new ImageSliderModel(R.drawable.slideshow_1));

        sliderView.setSliderAdapter(new ImageSliderAdapter(this,imageSliderModelList));

        //top sale
        topSaleRecyclerView = findViewById(R.id.topSaleRecycler);

        topSaleProductList = new ArrayList<>();
        topSaleProductList.add(new Product(1,R.drawable.dell1));
        topSaleProductList.add(new Product(2,R.drawable.dell2));
        topSaleProductList.add(new Product(3,R.drawable.dell1));
        topSaleProductList.add(new Product(4,R.drawable.dell2));
        topSaleProductList.add(new Product(4,R.drawable.dell1));
        topSaleProductList.add(new Product(4,R.drawable.dell2));
        setTopSaleRecycler((ArrayList<Product>) topSaleProductList);

        //topNew
        topNewRecyclerView = findViewById(R.id.topNewRecycler);

        topNewProductList = new ArrayList<>();
        topNewProductList.add(new Product(1,R.drawable.lenovo1));
        topNewProductList.add(new Product(1,R.drawable.lenovo1));
        topNewProductList.add(new Product(1,R.drawable.lenovo1));
        topNewProductList.add(new Product(1,R.drawable.lenovo1));
        topNewProductList.add(new Product(1,R.drawable.lenovo1));
        topNewProductList.add(new Product(1,R.drawable.lenovo1));
        setTopNewRecycler((ArrayList<Product>) topNewProductList);

        //top Sell
        topSellRecyclerView = findViewById(R.id.topSellRecycler);

        topSellProductList = new ArrayList<>();
        topSellProductList.add(new Product(1,R.drawable.msi1));
        topSellProductList.add(new Product(2,R.drawable.msi1));
        topSellProductList.add(new Product(3,R.drawable.msi1));
        topSellProductList.add(new Product(4,R.drawable.msi1));
        topSellProductList.add(new Product(4,R.drawable.msi1));
        topSellProductList.add(new Product(4,R.drawable.msi1));
        setTopSellRecycler((ArrayList<Product>) topSellProductList);

        //top sell1
//        topSell1RecyclerView = findViewById(R.id.topSell1Recycler);
//
//        topSell1ProductList = new ArrayList<>();
//        topSell1ProductList.add(new Product(1,R.drawable.lenovo1));
//        topSell1ProductList.add(new Product(2,R.drawable.lenovo1));
//        topSell1ProductList.add(new Product(3,R.drawable.lenovo1));
//        topSell1ProductList.add(new Product(4,R.drawable.lenovo1));
//        topSell1ProductList.add(new Product(4,R.drawable.lenovo1));
//        topSell1ProductList.add(new Product(4,R.drawable.lenovo1));
//        setTopSell1Recycler((ArrayList<Product>) topSell1ProductList);


    }

    private void setTopSellRecycler(ArrayList<Product> topSellProductList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);//truot ngang hay doc
        topSellRecyclerView.setLayoutManager(layoutManager);
        topSellProductAdapter = new TopProductAdapter(this, topSellProductList);
        topSellRecyclerView.setAdapter(topSellProductAdapter);
    }

    private void setTopSell1Recycler(ArrayList<Product> topSellProductList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);//truot ngang hay doc
        topSell1RecyclerView.setLayoutManager(layoutManager);
        topSell1ProductAdapter = new TopProductAdapter(this, topSellProductList);
        topSell1RecyclerView.setAdapter(topSell1ProductAdapter);
    }

    private void setTopNewRecycler(ArrayList<Product> topNewproductList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);//truot ngang hay doc
        topNewRecyclerView.setLayoutManager(layoutManager);
        topNewProductAdapter = new TopProductAdapter(this, topNewproductList);
        topNewRecyclerView.setAdapter(topNewProductAdapter);
    }

    private void setTopSaleRecycler(ArrayList<Product> productList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);//truot ngang hay doc
        topSaleRecyclerView.setLayoutManager(layoutManager);
        topSaleProductAdapter = new TopProductAdapter(this, productList);
        topSaleRecyclerView.setAdapter(topSaleProductAdapter);
    }

}