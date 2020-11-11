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

        public static PersonalCartItems getCartOfUser(String email) {
            PersonalCartItems pCart = new PersonalCartItems();
            ArrayList<PersonalCartItems> listPersonalCartItems = Constants.personalCart.listPersonalCartItems;
            if (listPersonalCartItems.size() != 0) {
                for (PersonalCartItems p : listPersonalCartItems) {
                    if (p.getEmail() == email) {
                        pCart = p;
                    }
                }
            }
            return pCart;
        }

        public static void setCartOfUser(CartItem item, String email) {
            PersonalCartItems pCart = getCartOfUser(email);
            ArrayList<CartItem> listItem = pCart.getCartItems();
            if (listItem != null) {
                listItem.add(item);
                pCart.setCartItems(listItem);
            } else {
                ArrayList<CartItem> items = new ArrayList<>();
                items.add(item);
                pCart.setEmail(email);
                pCart.setCartItems(items);
            }
            Constants.personalCart.listPersonalCartItems.add(pCart);
        }

        public static int totalCost(String email) {
            int totalPrice = 0;
            if (getCartOfUser(email) != null) {
                for (CartItem item : getCartOfUser(email).getCartItems()) {
                    totalPrice += item.getSale() * item.getQuantity();
                }
            }
            return totalPrice;
        }

        public static ArrayList<PersonalCartItems> listPersonalCartItems = new ArrayList<>();
    }
}
