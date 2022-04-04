package utils;

import java.util.Random;

public class RandomDouble {
    public static Double inRange(Double min, Double max) {
        Random rd = new Random();
        return rd.nextDouble(max - min) + min;
    }
}
