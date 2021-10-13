package base;

import java.util.Random;

public class utils  {

    Random rand = new Random();

    public int randomInt(int min, int max){
        return min + rand.nextInt(max+1-min);
    }

    public double randomDouble(int min, int max, int dp){
        double num = min + rand.nextDouble()*(max-min);
        double factor = Math.pow(10,dp);
        return Math.round(num*factor)/factor;
    }
}

