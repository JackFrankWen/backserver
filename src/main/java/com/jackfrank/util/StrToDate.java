package com.jackfrank.util;

import org.w3c.dom.ranges.RangeException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by jack on 17-12-13.
 */
public class StrToDate {
    public static Date StringToDate(String date) {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date newDate = new Date();
        try {
            newDate = formatter.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        } catch(RangeException e) {
            throw e;
        }
        return newDate;
    }
}
