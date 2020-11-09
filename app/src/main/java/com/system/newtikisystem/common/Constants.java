package com.system.newtikisystem.common;

import com.system.newtikisystem.entity.CartItem;
import com.system.newtikisystem.entity.PersonalCartItems;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Constants {
    final static int random = new Random().nextInt(9999) + 1000; // [0, 60] + 20 => [20, 80]

    public static class getRandomNumber {
        public static final String numberRandom = String.valueOf(random);
        public static final int numberCheck = Integer.parseInt(numberRandom);
    }

    public static class statusLogin {
        public static boolean checkLogin;
    }

    public static class accountSave {
        public static String emailAccount = "";
    }

    public static class personalCart {
        public static ArrayList<PersonalCartItems> getData() {
            ArrayList<PersonalCartItems> listPersonalCartItems = new ArrayList<>();
            ArrayList<CartItem> items = new ArrayList<>();

            for (int i = 1; i < 5; i++) {
                items.add(new CartItem(i, "Logitech" + i, "https://product.hstatic.net/1000026716/product/gvn_log_g304_3df28cd60a48412b8fb1d2ff762dc6a9.png", 2, i * 1000000, i * 1000000 - 500000));
            }
            listPersonalCartItems.add(new PersonalCartItems("123123@gmail.com", items));
            return listPersonalCartItems;
        }

        public static ArrayList<PersonalCartItems> listPersonalCartItems = getData();
    }
}
