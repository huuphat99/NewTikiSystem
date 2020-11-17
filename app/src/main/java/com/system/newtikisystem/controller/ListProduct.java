package com.system.newtikisystem.controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.system.newtikisystem.R;
import com.system.newtikisystem.adapter.RecyclerAdapterListProduct;
import com.system.newtikisystem.dao.ProductTDAO;
import com.system.newtikisystem.entity.ProductList;

import java.util.ArrayList;

public class ListProduct extends AppCompatActivity implements RecyclerAdapterListProduct.OnViewProductDetailListener {
    ArrayList<ProductList> products;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_product);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        int subCategoryID;
        Intent intent = getIntent();
        subCategoryID = intent.getIntExtra("subcategoryID", -1);
        ProductTDAO productTDAO = new ProductTDAO();
        products = productTDAO.getListProductBySubCategory(subCategoryID);
        RecyclerView recyclerView = findViewById(R.id.lpRecyclerView);
        RecyclerAdapterListProduct adapter = new RecyclerAdapterListProduct(products,this);
        recyclerView.setAdapter(adapter);
        GridLayoutManager layoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent= new Intent(this, HomeActivity.class);
                startActivity(intent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onProductClick(int position) {
        int productID= products.get(position).getId();
        Intent intent= new Intent(this, ProductDetailActivity.class);
        intent.putExtra("productId",productID);
        startActivity(intent);
    }
}