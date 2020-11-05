package com.system.newtikisystem.common;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Common {
    public String changeDateToString(Date date) {
        String pattern = "HH:mm dd/MM/yyyy";
        DateFormat df = new SimpleDateFormat(pattern);
        String dateAsString = df.format(date);
        return dateAsString;
    }
}
