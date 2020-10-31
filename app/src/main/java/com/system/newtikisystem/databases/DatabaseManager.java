package com.system.newtikisystem.databases;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.system.newtikisystem.databases.models.Advertisements;
import com.system.newtikisystem.databases.models.Favorites;
import com.system.newtikisystem.databases.models.Productrating;
import com.system.newtikisystem.databases.models.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DatabaseManager {
    private static final String TAG = "DatabaseManager";

    private static final String Advertisements = "advertisements";
    private static final String Categories = "categories";
    private static final String Comments = "comments";
    private static final String Favorites = "favorites";
    private static final String Notifications = "notifications";
    private static final String Order_product = "order_product";
    private static final String Orders = "orders";
    private static final String Paymentmethods = "paymentmethods";
    private static final String Product_pictures = "product_pictures";
    private static final String Product_subcategory = "product_subcategory";
    private static final String Productrating = "productrating";
    private static final String Products = "products";
    private static final String Searchhistories = "searchhistories";
    private static final String Searchkeywords = "searchkeywords";
    private static final String Subcategories = "subcategories";
    private static final String User = "user";


    private SQLiteDatabase sqLiteDatabase;
    private AssetHelper assetHelper;

    private static DatabaseManager databaseManager;

    public DatabaseManager(Context context) {
        assetHelper = new AssetHelper(context);
    }

    public static DatabaseManager getInstance(Context context) {
        if (databaseManager == null) {
            databaseManager = new DatabaseManager(context);
        }
        return databaseManager;
    }

    public List<Productrating> getListTopic() {
        List<Productrating> testData = new ArrayList<>();
        sqLiteDatabase = assetHelper.getReadableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery("select * from " + Productrating, null);
        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {
            //read data
//            int id = cursor.getInt(0);
//            String name = cursor.getString(1);
//            String imageUrl = cursor.getString(3);
//            String category = cursor.getString(4);
//            String color = cursor.getString(5);
//            String lastTime = cursor.getString(6);
            int productId = cursor.getInt(0);
            String  email = cursor.getString(1);
            String ratingContent = cursor.getString(2);
            Float stars = cursor.getFloat(3);


            testData.add(new Productrating(productId, email, ratingContent, stars));
            //next row
            cursor.moveToNext();
        }

        Log.d(TAG, "getListTopic: " + testData);

        return testData;
    }

    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        sqLiteDatabase = assetHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from " + User, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            User user = new User();
            user.setEmail(cursor.getString(0));
            user.setPassword(cursor.getString(1));
            user.setName(cursor.getString(2));
            user.setPhone(cursor.getString(3));
            user.setDob(cursor.getString(4));
            users.add(user);
            cursor.moveToNext();
        }

        return users;
    }
}
