package com.example.oskar.yatzy_oskar_sammalisto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {


    ToggleButton buttonOne;
    ToggleButton buttonTwo;
    ToggleButton buttonThree;
    ToggleButton buttonFour;
    ToggleButton buttonFive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //DiceEventListener diceSelect = findViewById(R.id.dieOne);
        //diceSelect.setOnPressDie(R.drawable.dice_one_selected);


    }

    public void rollDice(View view){

        buttonOne =  findViewById(R.id.toggleButtonDiceOne);
        buttonTwo =  findViewById(R.id.toggleButtonDiceTwo);
        buttonThree = findViewById(R.id.toggleButtonDiceThree);
        buttonFour =  findViewById(R.id.toggleButtonDiceFour);
        buttonFive =  findViewById(R.id.toggleButtonDiceFive);

        int[] throwArray = new int[5];
        ToggleButton[] buttonArray = {buttonOne, buttonTwo, buttonThree, buttonFour, buttonFive};
        //DiceRoller diceRoller = new DiceRoller();
        //DiceRoller.diceRoller();
       // int[] throwArray = DiceRoller.diceRoller();



        for(int i = 0; i < throwArray.length; i++){
            if(!buttonArray[i].isChecked())
            throwArray[i] = (int)(Math.random() * 6 ) +1 ;

        }






        for(int i = 0; i < buttonArray.length; i++){
            if(!buttonArray[i].isChecked()){
                if (throwArray[i] == 1)
                    buttonArray[i].setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.dice_one), null, null);

                else if (throwArray[i] == 2)
                    buttonArray[i].setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.dice_two), null, null);

                else if (throwArray[i] == 3)
                    buttonArray[i].setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.dice_three), null, null);

                else if (throwArray[i] == 4)
                    buttonArray[i].setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.dice_four), null, null);

                else if (throwArray[i] == 5)
                    buttonArray[i].setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.dice_five), null, null);

                else if (throwArray[i] == 6)
                    buttonArray[i].setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.dice_six), null, null);

                else
                    buttonArray[i].setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.dice_six_selected), null, null);
            }
        }

//        if(!buttonOne.isChecked()) {
//            if (throwArray[1] == 1)
//                buttonOne.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.dice_one), null, null);
//
//            else if (throwArray[1] == 2)
//                buttonOne.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.dice_two), null, null);
//
//            else if (throwArray[1] == 3)
//                buttonOne.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.dice_three), null, null);
//
//            else if (throwArray[1] == 4)
//                buttonOne.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.dice_four), null, null);
//
//            else if (throwArray[1] == 5)
//                buttonOne.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.dice_five), null, null);
//
//            else if (throwArray[1] == 6)
//                buttonOne.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.dice_six), null, null);
//
//            else
//                buttonOne.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.dice_six_selected), null, null);
//            //buttonOne.setDrawableTop
//
//        }






    }






}
