/*
Your task in order to complete this Kata is to write a function which formats a duration, given as a number of seconds, in a human-friendly way.

        The function must accept a non-negative integer. If it is zero, it just returns "now". Otherwise, the duration is expressed as a combination of years, days, hours, minutes and seconds.

        It is much easier to understand with an example:

        TimeFormatter.formatDuration(62)   //returns "1 minute and 2 seconds"
        TimeFormatter.formatDuration(3662) //returns "1 hour, 1 minute and 2 seconds"
        For the purpose of this Kata, a year is 365 days and a day is 24 hours.

        Note that spaces are important.

        Detailed rules
        The resulting expression is made of components like 4 seconds, 1 year, etc. In general, a positive integer and one of the valid units of time, separated by a space. The unit of time is used in plural if the integer is greater than 1.

        The components are separated by a comma and a space (", "). Except the last component, which is separated by " and ", just like it would be written in English.

        A more significant units of time will occur before than a least significant one. Therefore, 1 second and 1 year is not correct, but 1 year and 1 second is.

        Different components have different unit of times. So there is not repeated units like in 5 seconds and 1 second.

        A component will not appear at all if its value happens to be zero. Hence, 1 minute and 0 seconds is not valid, but it should be just 1 minute.

        A unit of time must be used "as much as possible". It means that the function should not return 61 seconds, but 1 minute and 1 second instead. Formally, the duration specified by of a component must not be greater than any valid more significant unit of time.
*/


package com.codewars;

public class TimeFormatter {
    public static String formatDuration(int seconds) {
        if(seconds == 0){
            return "now";
        }
        if (seconds < 60) {
            return seconds + (seconds > 1 ? " seconds" : " second");
        }
        if (seconds == 60) {
            return "1 minute";
        }
        if (seconds == 3600) {
            return "1 hour";
        }
        if (seconds == 86400) {
            return "1 day";
        }
        if (seconds == 31536000) {
            return "1 year";
        }

        StringBuilder str = new StringBuilder();

        if (seconds > 86400) {
            int p = (int) Math.floor(seconds / 86400);
            int year = 0;
            if (p > 365) {
                year = (int) Math.floor(p / 365);
                str.append(year).append(year > 1 ? " years" : " year");
                p -= 365*year;
            }
            if (seconds % 86400 == 0) {
                str.append(" and ").append(p).append(p > 1 ? " days" : "day");
            } else {
                str.append(year > 0?", ":"").append(p).append(p > 1 ? " days" : "day").append(", ").append(hour(seconds - year * 365 * 86400 - p * 86400));
            }
        } else {
            str.append(hour(seconds));
        }

        return str.toString();
    }

    private static String hour(int seconds) {
        StringBuilder str = new StringBuilder();
        int hour = 0;
        if (seconds > 3600) {
            hour = (int) Math.floor(seconds / 3600);
            str.append(hour).append(hour > 1 ? " hours" : " hour");
        }
        int minute = (int) Math.floor((seconds - hour * 3600) / 60);
        int s = (seconds - minute * 60) % 60;
        if (s > 0) {
            str.append(hour > 0?", ":"").append(minute).append(minute > 1 ? " minutes" : " minute").append(" and ").append(s).append(s > 1 ? " seconds" : " second");
        } else {
            str.append(hour > 0?" and ":"").append(minute).append(minute > 1 ? " minutes" : " minute");
        }

        return str.toString();
    }
}

/*
public class TimeFormatter {

    private static int S_PER_MIN = 60;
    private static int S_PER_HR  = 60 * S_PER_MIN;
    private static int S_PER_DAY = 24 * S_PER_HR;
    private static int S_PER_YR =  365 * S_PER_DAY;

    private static String unit(int n, String kind) {
        return n == 0 ? "" : String.format("%d %s%s, ", n, kind, n == 1 ? "" : "s");
    }

    public static String formatDuration(int s) {

        if (s == 0) return "now";

        int y, d, h, m;

        s -= (y = s / S_PER_YR)  * S_PER_YR;
        s -= (d = s / S_PER_DAY) * S_PER_DAY;
        s -= (h = s / S_PER_HR)  * S_PER_HR;
        s -= (m = s / S_PER_MIN) * S_PER_MIN;

        String ret = unit(y,"year") + unit(d,"day") + unit(h,"hour") + unit(m,"minute") + unit(s,"second");
        ret = ret.substring(0, ret.length()-2); // remove trailing ', '
        return ret.lastIndexOf(",") == -1 ? ret : ret.replaceAll("(.+), (.+?)$", "$1 and $2"); // replace last , with "and"
    }

}*/
