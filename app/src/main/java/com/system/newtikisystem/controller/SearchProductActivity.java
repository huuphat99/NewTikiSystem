package com.system.newtikisystem.controller;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mancj.materialsearchbar.MaterialSearchBar;
import com.system.newtikisystem.R;
import com.system.newtikisystem.dao.ProductDAO;
import com.system.newtikisystem.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class SearchProductActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    SearchAdapter searchAdapter;

    MaterialSearchBar materialSearchBar;
    ProductDAO productDAO;
    List<String> suggestList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_product);
        getSupportActionBar().hide();

        recyclerView = findViewById(R.id.recycler_search);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        productDAO = new ProductDAO();

        materialSearchBar = findViewById(R.id.search_bar);
        //Setup DB
        materialSearchBar.setHint("Search");
        materialSearchBar.setCardViewElevation(10);
        loadSuggestList();
        materialSearchBar.addTextChangeListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                List<String> suggest = new ArrayList<>();
                for (String search : suggestList) {
                    if(search.toLowerCase().contains(materialSearchBar.getText().toLowerCase()))
                        suggest.add(search);
                }
                materialSearchBar.setLastSuggestions(suggest);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        materialSearchBar.setOnSearchActionListener(new MaterialSearchBar.OnSearchActionListener() {
            @Override
            public void onSearchStateChanged(boolean enabled) {
                if (!enabled) {
                    // recyclerView.setAdapter(searchAdapter);
                    productDAO = new ProductDAO();
                    searchAdapter = new SearchAdapter(getBaseContext(), productDAO.getAllProducts());
                    recyclerView.setAdapter(searchAdapter);
                }

            }

            @Override
            public void onSearchConfirmed(CharSequence text) {
                startSearch(text.toString());
            }

            @Override
            public void onButtonClicked(int buttonCode) {

            }
        });

        //init adapter default set all products
        searchAdapter = new SearchAdapter(this,productDAO.getAllProducts());
        recyclerView.setAdapter(searchAdapter);
    }

    private void loadSuggestList() {
        suggestList = new ArrayList<>();
        suggestList = productDAO.getAllProductsName();
        materialSearchBar.setLastSuggestions(suggestList);
    }

    private void startSearch(String keyword) {
        List<Product> list = new ArrayList<>();
        productDAO = new ProductDAO();
        list = productDAO.getProductsByName(keyword);
        searchAdapter = new SearchAdapter(this, list);
        recyclerView.setAdapter(searchAdapter);
    }
}