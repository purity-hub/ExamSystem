package com.lhy.examsystem.util;

public class TimeUtil {
    public String AddTime(String time, int add) {
        String[] timeArray = time.split(" ");
        String[] time1 = timeArray[0].split("-");
        String[] time2 = timeArray[1].split(":");
        int year = Integer.parseInt(time1[0]);
        int month = Integer.parseInt(time1[1]);
        int day = Integer.parseInt(time1[2]);
        int hour = Integer.parseInt(time2[0]);
        int minute = Integer.parseInt(time2[1]);
        minute += add;
        if (minute >= 60) {
            hour += minute / 60;
            minute = minute % 60;
        }
        if (hour >= 24) {
            day += hour / 24;
            hour = hour % 24;
        }
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            if (day > 31) {
                month += day / 31;
                day = day % 31;
            }
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            if (day > 30) {
                month += day / 30;
                day = day % 30;
            }
        } else {
            if (day > 28) {
                month += day / 28;
                day = day % 28;
            }
        }
        if (month > 12) {
            year += month / 12;
            month = month % 12;
        }
        String result = year + "-" + month + "-" + day + " " + hour + ":" + minute + ":00";
        return result;
    }
}
