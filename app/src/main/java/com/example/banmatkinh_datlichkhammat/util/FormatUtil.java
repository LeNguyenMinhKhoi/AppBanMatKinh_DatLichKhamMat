package com.example.banmatkinh_datlichkhammat.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatUtil {
    static SimpleDateFormat sdfDateTime = new SimpleDateFormat("dd/MM/yyyy hh:mm aa");
    static SimpleDateFormat sdfDate = new SimpleDateFormat("dd/MM/yyyy");
    static SimpleDateFormat sdfTime = new SimpleDateFormat("hh:mm aa");

    public static String FormatDateTime(Date date){
        return sdfDateTime.format(date);
    }
    public static String FormatDate(Date date){
        return sdfDate.format(date);
    }
    public static String FormatTime(Date date){
        return sdfTime.format(date);
    }
}
