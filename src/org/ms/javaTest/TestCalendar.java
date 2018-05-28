package org.ms.javaTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TestCalendar {

    public static void main(String[] args) {
        yearLastDayInWhichWeek();
    }

    public static void yearLastDayInWhichWeek(){
        // Calendar cal = Calendar.getInstance();
        // cal.set(2017, Calendar.DECEMBER, 31);
        //
        // // Date date = new Date();
        // // date.setTime(cal.getTimeInMillis());
        // // SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        // // System.out.println(sdf.format(date));
        //
        // System.out.println(cal.get(Calendar.WEEK_OF_YEAR));

        // String today = "2018-12-31";
        // String today = "2019-01-01";
        String today = "2019-01-06";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = format.parse(today);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        calendar.setTime(date);
        System.out.println(calendar.get(Calendar.WEEK_OF_YEAR));

    }

}
