package utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Random;
import java.util.Date;

public class TestHelper {

    public static int randomInt(){
        Random rn = new Random();
        return 100000 + rn.nextInt(900000);
    }




    public static LocalDate selectDate(){

//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//        Date date = new Date();
//        System.out.println(dateFormat.format(date)); //2015/10/26 12:10:39
//        return date;

        LocalDate today = LocalDate.now();
        return today;

    }

    public static LocalTime selectTime(){
        LocalTime today = LocalTime.now();
        return today;
    }





    }




