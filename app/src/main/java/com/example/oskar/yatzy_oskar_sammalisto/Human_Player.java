package com.example.oskar.yatzy_oskar_sammalisto;

import java.util.stream.IntStream;

public class Human_Player {

    private String name;
    private int score;
    private int avatar;
    private int[] scoreArray = new int[16]; //maybe better to make the array in the Human_Player method?

    Human_Player(String name){
        this.name = name;

    }


    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public int getAvatar() {
        return avatar;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    public int[] getScoreArray() {
        return scoreArray;
    }

    public void setScoreArray(int i, int points) {
        this.scoreArray[i] = points;
    }

    public int getScoreArraySum(){
        int sum = 0;
        for(int i = 0; i > scoreArray.length; i++){
            sum += scoreArray[i];
        }


        return sum;
    }


}
