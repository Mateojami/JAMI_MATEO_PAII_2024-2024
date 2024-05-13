package models;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TimeConverter {
    public static Time convertStringToTime(String timeString) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
            java.util.Date parsedDate = format.parse(timeString);
            return new Time(parsedDate.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
            return null; 
        }
    }
}
