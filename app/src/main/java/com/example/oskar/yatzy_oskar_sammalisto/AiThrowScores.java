package com.example.oskar.yatzy_oskar_sammalisto;

public class AiThrowScores {


    public static int ones(){
        int random = (int) (Math.random() *6) +1;


        return random;
    }

    public static int twos(){
        int random = (int) (Math.random() *5) +2;

        random *= 2;

        return random;
    }

    public static int threes(){

        int random = (int) (Math.random() *5) +2;

        random *= 3;

        return random;


    }

    public static int fours(){

        int random = (int) (Math.random() *5) +1;

        random *= 4;

        return random;


    }

    public static int fives(){

        int random = (int) (Math.random() *5) +1;

        random *= 5;

        return random;


    }

    public static int sixes(){

        int random = (int) (Math.random() *5) +1;

        random *= 6;

        return random;


    }

    public static int pair(){

        int random = (int) (Math.random() *5) +1;

        random *= 2;

        return random;


    }

    public static int twoPair(){

        int random = 0;

        int randomOne = (int) (Math.random() *5) +1;

        randomOne *= 2;

        int randomTwo = (int) (Math.random() *5) +1;

        randomTwo *= 2;

        if(randomOne != 0 && randomTwo != 0){
            random = randomOne + randomTwo;
        }


        return random;


    }

    public static int threeOfAKind(){

        int random = (int) (Math.random() *7);

        random *= 3;

        return random;


    }

    public static int quads(){
        int random = (int) (Math.random() *7);

        random *= 4;

        return random;


    }

    public static int smallStraight(){
        int random = (int) (Math.random() *6);

        if(random >= 3){
            random = 15;
        }
        else {
            random = 0;
        }

        return random;
    }

    public static int bigStraight(){

        int random = (int) (Math.random() *6);

        if(random >= 4){
            random = 20;
        }
        else {
            random = 0;
        }

        return random;


    }

    public static int fullHouse(){
        int random = (int) (Math.random() *6);
        int fullHouseScore = 0;

        if(random == 5){
            fullHouseScore = 28;
        }

        if(random == 4){
            fullHouseScore = 24;
        }

        if(random == 3){
            fullHouseScore = 21;
        }

        if(random == 2){
            fullHouseScore = 16;
        }

        if(random == 1){
            fullHouseScore = 13;
        }

        return fullHouseScore;
    }

    public static int chance(){
        int random = 0;
        for(int i = 0; i < 5; i++){

            random += (int)(Math.random() * 6 ) +1;
        }

        return random;

    }

    public static int yatzy(){

        int random = (int) (Math.random() *8);
        int yatzy = 0;

        if(random >= 5){
            yatzy = 50;
        }

        return yatzy;
    }







}
