package com.system.newtikisystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.system.newtikisystem.controller.RecyclerAdapterListProduct;
import com.system.newtikisystem.dao.CategoryDAO;
import com.system.newtikisystem.entity.Categories;
import com.system.newtikisystem.entity.Products;

import java.util.ArrayList;

public class ListProduct extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_product);

        RecyclerView recyclerView = findViewById(R.id.lpRecyclerView);
        ArrayList<Products> products = new ArrayList<>();
//        for (int i = 1; i < 10; i++) {
//            products.add(new Products("Thao", 450, "https://tatyanaseverydayfood.com/wp-content/uploads/2018/07/Summer-Sangria-Cake-4.jpg"));
//            RecyclerAdapterListProduct adapter = new RecyclerAdapterListProduct(products);
//            recyclerView.setAdapter(adapter);
//            LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//            recyclerView.setLayoutManager(layoutManager);
//        }
    }
}