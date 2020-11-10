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

        public static PersonalCartItems getCartOfUser() {
            PersonalCartItems pCart = new PersonalCartItems();
            String email = accountSave.emailAccount;
            for (PersonalCartItems p : personalCart.listPersonalCartItems) {
                if (p.getEmail() == email) {
                    pCart = p;
                }
            }
            return pCart;
        }

        public static int totalCost() {
            int totalPrice = 0;
            for (CartItem item : getCartOfUser().getCartItems()) {
                totalPrice += item.getSale() * item.getQuantity();
            }
            return totalPrice;
        }

        public static ArrayList<PersonalCartItems> listPersonalCartItems = new ArrayList<>();
    }
}
