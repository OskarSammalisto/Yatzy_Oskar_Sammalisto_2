package com.example.oskar.yatzy_oskar_sammalisto;

import java.util.Arrays;

//  based on  https://github.com/bratanon/Yatzy/blob/master/src/Rules.java

public class YatzyScoring {

    public static int sumCalculator(int die, int[] throwArray) {

        int[] diceArray = throwArray;

        int sum = 0;
        for(int i = 0; i < throwArray.length; i++){

            if(throwArray[i] == die) {
                sum += throwArray[i];
            }
        }

        return sum;

    }

    public static int ones(int[] throwArray) {

        return sumCalculator(1, throwArray);
    }

    public static int twos(int[] throwArray) {

        return sumCalculator(2, throwArray);
    }

    public static int threes(int[] throwArray) {

        return sumCalculator(3, throwArray);
    }

    public static int fours(int[] throwArray) {

        return sumCalculator(4, throwArray);
    }

    public static int fives(int[] throwArray) {

        return sumCalculator(5, throwArray);
    }

    public static int sixes(int[] throwArray) {

        return sumCalculator(6, throwArray);
    }

    public static int pair(int[] throwArray) {
        Arrays.sort(throwArray);

        for(int i = throwArray.length -1; i > 0 ;i--) {
            if(throwArray[i] == throwArray[i -1]){
                return throwArray[i] + throwArray[i -1];
            }
        }
        return 0;
    }

    public static int twoPairs(int[] throwArray) {
        Arrays.sort(throwArray);
        int sum = 0;

        for (int i = throwArray.length -1; i > 0 ;i--){
            if(throwArray[i] == throwArray[ i-1]){
                sum = throwArray[i] + throwArray [i-1];
                if (i > 2){
                    for (int j = i -2; j > 0; j--){
                        if (throwArray[j] == throwArray [j -1]){
                            return sum + throwArray[j] + throwArray[j -1];
                        }
                    }
                }
            }

        }
        return 0;
    }

    public static int threeOfaKind(int[] throwArray) {

        Arrays.sort(throwArray);

        for(int i = throwArray.length -1; i > 1; i--) {
            if (throwArray[i] == throwArray[i -1] && throwArray[i] == throwArray[i - 2]){
                return throwArray[i] + throwArray [i - 1] + throwArray [i - 2];
            }
        }
        return 0;
    }

    public static int quads(int[] throwArray){
        Arrays.sort(throwArray);
        for(int i = throwArray.length -1; i > 2; i--){
            if(throwArray[i] == throwArray[i - 1] && throwArray[i] == throwArray[i - 2] && throwArray[i] == throwArray[i - 3] ){
                return throwArray[i] + throwArray [i - 1] + throwArray[i - 2] + throwArray[i - 3];
            }
        }
        return 0;
    }

    public static int smallStraight(int[] throwArray){
        Arrays.sort(throwArray);

        int[] smallStraightTrue = {1, 2, 3, 4, 5};
        boolean match = true;
        for(int i = 0; i < smallStraightTrue.length; i++){
            if(smallStraightTrue[i] != throwArray[i]){
                match = false;
            }
        }

        if (match){
            return  15;
        }

        return 0;
    }

    public static int bigStraight(int[] throwArray){
        Arrays.sort(throwArray);

        int[] bigStraightTrue = { 2, 3, 4, 5, 6};
        boolean match = true;
        for(int i = 0; i < bigStraightTrue.length; i++){
            if(bigStraightTrue[i] != throwArray[i]){
                match = false;
            }
        }

        if (match){
            return  20;
        }

        return 0;
    }
                                                    //full house is wrong, returns top three, plus top two. 6+6+6+5+5 returns 3*6 + 2*6!!!!!
    public static int fullHouse(int[] throwArray){
        Arrays.sort(throwArray);
        int[] firstTwo = {throwArray[0], throwArray[1]};
        int[] lastThree = {throwArray[2], throwArray[3], throwArray[4]};
        int[] firstThree = {throwArray[0], throwArray[1], throwArray[2]};
        int[] lastTwo = {throwArray[3], throwArray[4]};


//        if(pair(throwArray) > 0 && threeOfaKind(throwArray) > 0){
//            return pair(throwArray) + threeOfaKind(throwArray);
//        }

        if(pair(firstTwo) > 0 && threeOfaKind(lastThree) > 0){
            return pair(firstTwo) + threeOfaKind(lastThree);
        }

        if(pair(lastTwo) > 0 && threeOfaKind(firstThree) > 0){
            return pair(lastTwo) + threeOfaKind(firstThree);
        }

        
        return 0;
    }

    public static int chance(int[] throwArray){
        int sum = 0;

        for(int i = 0; i < throwArray.length; i++){
            sum += throwArray[i];
        }
        return sum;
    }

    public static int yatzy(int[] throwArray){

        Arrays.sort(throwArray);

        if(throwArray[0] == throwArray[4]){
            return 50;
        }
        return 0;

    }




}
