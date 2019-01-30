package com.example.oskar.yatzy_oskar_sammalisto;

import android.view.View;
import android.widget.ToggleButton;

import java.util.Arrays;
import java.util.Random;

public class DiceRoller extends MainActivity{




    public static int[] rollTheDice(ToggleButton[] buttonArray, int[] throwArray){  //shall be static and not void,


        for(int i = 0; i < throwArray.length; i++){
            if(!buttonArray[i].isChecked())
                throwArray[i] = (int)(Math.random() * 6 ) +1 ;

        }

        return throwArray;

    }

//    public  void setDiceButtons (ToggleButton[] buttonArray){
//
//
//        buttonOne =  findViewById(R.id.toggleButtonDiceOne);
//        buttonTwo =  findViewById(R.id.toggleButtonDiceTwo);
//        buttonThree = findViewById(R.id.toggleButtonDiceThree);
//        buttonFour =  findViewById(R.id.toggleButtonDiceFour);
//        buttonFive =  findViewById(R.id.toggleButtonDiceFive);
//
//
//
//
//        for(int i = 0; i < buttonArray.length; i++){
//            if(!buttonArray[i].isChecked()){
//                if (throwArray[i] == 1)
//                    buttonArray[i].setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.dice_one), null, null);
//
//                else if (throwArray[i] == 2)
//                    buttonArray[i].setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.dice_two), null, null);
//
//                else if (throwArray[i] == 3)
//                    buttonArray[i].setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.dice_three), null, null);
//
//                else if (throwArray[i] == 4)
//                    buttonArray[i].setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.dice_four), null, null);
//
//                else if (throwArray[i] == 5)
//                    buttonArray[i].setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.dice_five), null, null);
//
//                else if (throwArray[i] == 6)
//                    buttonArray[i].setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.dice_six), null, null);
//
//                else
//                    buttonArray[i].setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.dice_six_selected), null, null);
//            }
//        }
//    }

//    public int[] getThrowArray() {
//        return throwArray;
//    }
}


//        buttonOne =  findViewById(R.id.toggleButtonDiceOne);
//        buttonTwo =  findViewById(R.id.toggleButtonDiceTwo);
//        buttonThree = findViewById(R.id.toggleButtonDiceThree);
//        buttonFour =  findViewById(R.id.toggleButtonDiceFour);
//        buttonFive =  findViewById(R.id.toggleButtonDiceFive);
//
//
//        ToggleButton[] buttonArray = {buttonOne, buttonTwo, buttonThree, buttonFour, buttonFive};
//DiceRoller diceRoller = new DiceRoller();
//DiceRoller.diceRoller();
// int[] throwArray = DiceRoller.diceRoller();


//        for(int i = 0; i < buttonArray.length; i++){
//            if(!buttonArray[i].isChecked()){
//                if (throwArray[i] == 1)
//                    buttonArray[i].setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.dice_one), null, null);
//
//                else if (throwArray[i] == 2)
//                    buttonArray[i].setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.dice_two), null, null);
//
//                else if (throwArray[i] == 3)
//                    buttonArray[i].setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.dice_three), null, null);
//
//                else if (throwArray[i] == 4)
//                    buttonArray[i].setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.dice_four), null, null);
//
//                else if (throwArray[i] == 5)
//                    buttonArray[i].setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.dice_five), null, null);
//
//                else if (throwArray[i] == 6)
//                    buttonArray[i].setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.dice_six), null, null);
//
//                else
//                    buttonArray[i].setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.dice_six_selected), null, null);
//            }
//        }