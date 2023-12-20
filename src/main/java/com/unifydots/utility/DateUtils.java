package com.unifydots.utility;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {

    /**
     * This method is used to get a particular date in a particular format.
     *
     * @param offsetFromToday Number of days to be added or subtracted from today.
     * @param format          Required format of the date example dd.MM.yyyy
     * @return date in String format
     */
    @SuppressWarnings("static-method")
    public String getDateInFormattedString(int offsetFromToday, String format) {

        DateFormat df = new SimpleDateFormat(format);
        Calendar today = Calendar.getInstance();
        today.add(Calendar.DATE, offsetFromToday);
        return df.format(today.getTime());

    }

    /**
     * This method is used to get a particular date in a particular format.
     *
     * @param offsetFromTodayInMonths Number of months to be added or subtracted
     *                                from today.
     * @param format                  Required format of the date example dd.MM.yyyy
     * @return date in String format
     */
    @SuppressWarnings("static-method")
    public String getDateInFormattedStringMonths(int offsetFromTodayInMonths, String format) {

        DateFormat df = new SimpleDateFormat(format);
        Calendar today = Calendar.getInstance();
        today.add(Calendar.MONTH, offsetFromTodayInMonths);
        return df.format(today.getTime());

    }

    /**
     * Method which returns the date object from the String date passed. String date
     * has to be in the format of 'hours:minutes:seconds'
     *
     * @param date String date which has to be converted
     * @return formatted date object; used internally
     */
    @SuppressWarnings("static-method")
    private Date getCurrentDateFormat(String date) {

        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
        Date dateObj = null;
        try {
            dateObj = sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dateObj;
    }


    /**
     * Used internally to format system date as per the requirement.
     *
     * @return formatted date as per the requirement
     */
    protected Date dateFormatConversion() {

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
        String dateConvert = sdf.format(date);
        return getCurrentDateFormat(dateConvert);
    }

}
