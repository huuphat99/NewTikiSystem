package com.system.newtikisystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import com.system.newtikisystem.controller.RecyclerAdapterFavoriteProducts;
import com.system.newtikisystem.dao.ProductTDAO;
import com.system.newtikisystem.entity.FavoriteProduct;
import com.system.newtikisystem.entity.Products;

import java.util.ArrayList;

public class favoriteProducts extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite_products);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        RecyclerView recyclerView = findViewById(R.id.fpRecyclerView);
        ProductTDAO productTDAO = new ProductTDAO();
        ArrayList<FavoriteProduct> products = productTDAO.getListProductFavorite("linhphuong@gmail.com");
        RecyclerAdapterFavoriteProducts adapter = new RecyclerAdapterFavoriteProducts(products);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
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
}