package util;

import java.util.Date;

public class CommonUtil {
    public static int calculateHoursForOneDay(String startDate, String endDate){
        String[] s1=startDate.split(" ");
        int hour_1=Integer.parseInt(s1[1]);

        String[] s2=endDate.split(" ");
        int hour_2=Integer.parseInt(s2[1]);

        return hour_2-hour_1;
    }
    public static int calculateHours(String startDate, String endDate){
        String[] s1=startDate.split(" ");
        String date_1=s1[0];
        int hour_1=Integer.parseInt(s1[1]);
        int days_1=Integer.parseInt(date_1.split("-")[0]);

        String[] s2=endDate.split(" ");
        String date_2=s2[0];
        int hour_2=Integer.parseInt(s2[1]);
        int days_2=Integer.parseInt(date_2.split("-")[0]);

        int daysDiff=days_2-days_1;

        return daysDiff*24-hour_1+hour_2;
    }
}
