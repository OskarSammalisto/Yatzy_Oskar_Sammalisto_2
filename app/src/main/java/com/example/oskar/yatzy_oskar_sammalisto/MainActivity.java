package com.example.oskar.yatzy_oskar_sammalisto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //DiceEventListener diceSelect = findViewById(R.id.dieOne);
        //diceSelect.setOnPressDie(R.drawable.dice_one_selected);


    }

    public void rollDice(View view){
        DiceRoller diceRoller = new DiceRoller();
        DiceRoller.diceRoller();

        ToggleButton buttonOne = (ToggleButton) findViewById(R.id.toggleButtonDiceOne);
        buttonOne.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.dice_one), null,null);
        //buttonOne.setDrawableTop




        // Log.d("throw", "throw");


    }






}
