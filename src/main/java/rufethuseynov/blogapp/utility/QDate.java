package rufethuseynov.blogapp.utility;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class QDate {

    public static String getCurrentDate() {
        Date date = new Date();
        return convertDateToString(date);
    }

    public static Long getDateTimeLong() {
        String st = getCurrentDate()+getCurrentHour() + getCurrentMinute() + getCurrentSecond();
        return Long.parseLong(st);
    }

    public static Long getCurrentDateTime() {
        return Long.parseLong(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS")));
    }

    public static String convertDateToString(Date dt) {

        String stYear = Integer.toString(dt.getYear() + 1900);
        String stMonth = Integer.toString(dt.getMonth() + 1);
        if (stMonth.length() == 1) {
            stMonth = "0" + stMonth;
        }
        String stDay = Integer.toString(dt.getDate());
        if (stDay.length() == 1) {
            stDay = "0" + stDay;
        }

        return stYear + stMonth + stDay;
    }

    public static String getCurrentHour() {
        String st = String.valueOf(Calendar.getInstance().get(Calendar.HOUR_OF_DAY));
        if (st.length() == 1) {
            st = "0" + st;
        }
        return st;
    }

    public static String getCurrentMinute() {
        String st = String.valueOf(Calendar.getInstance().get(Calendar.MINUTE));
        if (st.length() == 1) {
            st = "0" + st;
        }
        return st;
    }

    public static String getCurrentSecond() {
        String st = String.valueOf(Calendar.getInstance().get(Calendar.SECOND));
        if (st.length() == 1) {
            st = "0" + st;
        }
        return st;
    }
}
