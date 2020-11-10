package com.system.newtikisystem.common;

import java.util.ArrayList;
import java.util.List;
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

}
