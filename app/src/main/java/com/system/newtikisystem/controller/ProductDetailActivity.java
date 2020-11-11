package com.system.newtikisystem.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.smarteist.autoimageslider.SliderView;
import com.system.newtikisystem.R;
import com.system.newtikisystem.common.Constants;
import com.system.newtikisystem.dao.ProductDAO;
import com.system.newtikisystem.entity.CartItem;
import com.system.newtikisystem.entity.ImageSliderModel;
import com.system.newtikisystem.entity.PersonalCartItems;
import com.system.newtikisystem.entity.Product;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;

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
    int productId;
    Product product;

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
        productId = intent.getIntExtra("productId", -1);
        ProductDAO productDAO = new ProductDAO();
        product = productDAO.getProductDetail(productId);
        name.setText(product.getName());
        if (product.getSale() != 0) {
            realPrice.setText(String.valueOf((int) (product.getPrice() * (1 - product.getSale() / 100))));
            price.setText(String.valueOf(product.getPrice()));
            sale.setText(String.valueOf(product.getSale()) + "%");
        } else {
            realPrice.setText(String.valueOf(product.getPrice()));
        }
        producer.setText("Producer: " + product.getProducer());
        origin.setText("Origin: " + product.getOrigin());
        gurantee.setText("Guarantee: " + product.getGuarantee());
        descriptionDetail.setText(product.getDescription());

        //ads auto slider
        imageSliderModelList = new ArrayList<>();
        sliderView = findViewById(R.id.imageSlider);
        imageSliderModelList = productDAO.getImageUrls(productId);

        sliderView.setSliderAdapter(new ProductImageSliderAdapter(this, imageSliderModelList));
    }

    public void onAddProductToCartClick(View view) {
        String email;
        if (!Constants.accountSave.emailAccount.equalsIgnoreCase("")) {
            email = Constants.accountSave.emailAccount;
            int itemId = productId;
            String itemName = product.getName();
            String itemImageUrl = product.getAvatar();
            int itemQuantity = 1;
            int itemPrice = product.getPrice();
            int salePrice = (int) (product.getPrice() * (1 - product.getSale() / 100));
            CartItem newItem = new CartItem(itemId, itemName, itemImageUrl, itemQuantity, itemPrice, salePrice);
            Constants.personalCart.setCartOfUser(newItem, email);
        }
        Intent intent;
        if (Constants.statusLogin.checkLogin) {
            intent = new Intent(this, ShoppingCartActivity.class);
        } else {
            intent = new Intent(this, MainActivity.class);
        }
        startActivity(intent);
    }
}