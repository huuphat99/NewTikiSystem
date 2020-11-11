package com.system.newtikisystem.controller;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.smarteist.autoimageslider.SliderView;
import com.system.newtikisystem.R;
import com.system.newtikisystem.common.Constants;
import com.system.newtikisystem.common.Constants;
import com.system.newtikisystem.dao.CommentDAO;
import com.system.newtikisystem.dao.ProductDAO;
import com.system.newtikisystem.entity.CartItem;
import com.system.newtikisystem.entity.Comment;
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

    //for comment
    RecyclerView commemtRecyclerView;
    CommentAdapter commentAdapter;
    List<Comment> commentList;
    CommentDAO commentDAO;
    Product product;
    EditText makeComment;
    Button buttonSend;


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
        makeComment = findViewById(R.id.makeComment);
        buttonSend = findViewById(R.id.buttonSend);

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
        sliderView.setSliderAdapter(new ProductImageSliderAdapter(this, imageSliderModelList));

        //comments
        commemtRecyclerView = findViewById(R.id.commentsRecyclerView);
        commentDAO = new CommentDAO();
        commentList = commentDAO.getCommentsByProductId(productId);
        setCommentRecyclerView(commentList);

        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String comment = makeComment.getText().toString();
                    if (Constants.statusLogin.checkLogin) {
                        if(comment.isEmpty()) {
                            showMakeCommentAlert();
                        } else {
                            String email = Constants.accountSave.emailAccount;
                            commentDAO.insertComment(email,productId,comment);
                            commentList = commentDAO.getCommentsByProductId(productId);
                            setCommentRecyclerView(commentList);
                            makeComment.setText("");
                        }
                    } else {
                       showLoginAlert();
                }
        }
    });

    }

    private void showMakeCommentAlert() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Comment must not be empty");
        builder.setPositiveButton("OKE", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        builder.create();
        builder.show();
    }

    private void showLoginAlert() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("You have to login first");
        builder.setPositiveButton("Go to log in", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent loginIntent = new Intent(ProductDetailActivity.this, MainActivity.class);
                startActivity(loginIntent);
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.create();
        builder.show();
    }



    private void setCommentRecyclerView(List<Comment> commentList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        commemtRecyclerView.setLayoutManager(layoutManager);
        commentAdapter = new CommentAdapter(this, commentList);
        commemtRecyclerView.setAdapter(commentAdapter);
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
            intent = new Intent(this, HomeActivity.class);
            Toast toast = Toast.makeText(this, "Add successfully", Toast.LENGTH_LONG);
            toast.show();
        } else {
            intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }
}