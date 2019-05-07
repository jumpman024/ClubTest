package utils;

import java.util.Random;

public class TestHelper {

    public static int randomInt(){
        Random rn = new Random();
       // return rn.nextInt();
        return 100000 + rn.nextInt(900000);
    }
}
