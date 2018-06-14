package Junit.extent;

import java.util.Random;

public class generateRandom{

	 
    public static void main(String args[])
    {
    	// initilized the variable
    	int min=1;
    	int max=100;
        // create instance of Random class
        Random rand = new Random();
        
        int randomNumber= min+rand.nextInt(max);
        System.out.println(randomNumber);
 
       
    }
}