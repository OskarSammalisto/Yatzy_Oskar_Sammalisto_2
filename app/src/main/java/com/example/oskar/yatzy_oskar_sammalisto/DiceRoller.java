package com.example.oskar.yatzy_oskar_sammalisto;

import java.util.Arrays;
import java.util.Random;

public class DiceRoller {

   // Random random = new Random();

   public static int[] diceRoller(){

        int[] throwArray = new int[5];

        for(int i = 0; i < throwArray.length; i++){
           // Random random = new Random();
            throwArray[i] = (int)(Math.random() * 6 ) +1 ;

        }




        return throwArray;
    }
}
