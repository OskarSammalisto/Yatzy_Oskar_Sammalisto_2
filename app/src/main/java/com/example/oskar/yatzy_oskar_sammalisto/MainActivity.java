package com.example.oskar.yatzy_oskar_sammalisto;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity  {


    ToggleButton buttonOne;
    ToggleButton buttonTwo;
    ToggleButton buttonThree;
    ToggleButton buttonFour;
    ToggleButton buttonFive;

    private int[] throwArray = new int[5];
    private int throwCounter = 0;
    private int playerTurnIndicator = 1;
    public static String playerOne;
    private static String playerTwo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //takes in user names and avatar numbers from StartScreen activity
//         String playerOne = getIntent().getStringExtra("playerOne");
//         String playerTwo = getIntent().getStringExtra("playerTwo");
        int playerOneAvatar = getIntent().getIntExtra("avatar_player_one", 1);
        int playerTwoAvatar = getIntent().getIntExtra("avatar_player_two", 2);
        //DiceEventListener diceSelect = findViewById(R.id.dieOne);
        //diceSelect.setOnPressDie(R.drawable.dice_one_selected);


        //creates player one and two and applies user names and avatars
//        Human_Player playerOneCreated = new Human_Player(playerOne);
//        Human_Player playerTwoCreated = new Human_Player(playerTwo);
                                                                             //not getting the names
        playerOne = getIntent().getStringExtra("playerOne");
        playerTwo = getIntent().getStringExtra("playerTwo");

        //set avatar for players
        TypedArray avatarArray = getResources().obtainTypedArray(R.array.avatarArray);
        ImageView imageViewPlayerOne = (ImageView) findViewById(R.id.avatarOne);
        ImageView imageViewPlayerTwo = (ImageView) findViewById(R.id.avatarTwo);

        imageViewPlayerOne.setImageResource(avatarArray.getResourceId(playerOneAvatar, -1));
        imageViewPlayerTwo.setImageResource(avatarArray.getResourceId(playerTwoAvatar, -1));


        avatarArray.recycle();
//        getPlayerNames();





        // Test code to see that string from start screen is saved
        // TextView textView = (TextView) findViewById(R.id.testString);
        // textView.setText(playerOneCreated.getName());

        // testing avatar spinner int
        // textView.setText(String.valueOf(playerOneAvatar));


    }

        public void getPlayerNames(){

        playerOne = getIntent().getStringExtra("playerOne");
        playerTwo = getIntent().getStringExtra("playerTwo");

    }



    Human_Player playerOneCreated = new Human_Player(MainActivity.playerOne);  //take away avatar or change how its set
    Human_Player playerTwoCreated = new Human_Player(playerTwo);




    //warns user about going back to menu
    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setMessage(getString(R.string.backWarning))
                .setCancelable(false)
                .setPositiveButton(getString(R.string.yes), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        MainActivity.this.finish();
                    }
                })
                .setNegativeButton(getString(R.string.no), null)
                .show();
    }




    public void rollDice(View view){


        // If sats for max three throws
        if(throwCounter < 3){




        buttonOne =  findViewById(R.id.toggleButtonDiceOne);
        buttonTwo =  findViewById(R.id.toggleButtonDiceTwo);
        buttonThree = findViewById(R.id.toggleButtonDiceThree);
        buttonFour =  findViewById(R.id.toggleButtonDiceFour);
        buttonFive =  findViewById(R.id.toggleButtonDiceFive);


        ToggleButton[] buttonArray = {buttonOne, buttonTwo, buttonThree, buttonFour, buttonFive};
        //DiceRoller diceRoller = new DiceRoller();
        //DiceRoller.diceRoller();
       // int[] throwArray = DiceRoller.diceRoller();



        throwArray = DiceRoller.rollTheDice(buttonArray, throwArray);



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

        throwCounter++;
     }



        //        for(int i = 0; i < throwArray.length; i++){
//            if(!buttonArray[i].isChecked())
//            throwArray[i] = (int)(Math.random() * 6 ) +1 ;
//
//        }

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


    public void scoreboardClicked(View view){

        String id = getResources().getResourceName(view.getId());

        Toast.makeText(this, id.toString() + " clicker worked.", Toast.LENGTH_SHORT).show();

        switch (view.getId()){
            case R.id.ones:

                TextView textView = findViewById(R.id.testString);
                int setScore = YatzyScoring.ones(throwArray);
                textView.setText(Integer.toString(setScore));
                /* YatzyScoring.ones(throwArray); */
//                 TextView textView = findViewById(R.id.testString);
//                 textView.setText(playerOneCreated.getName());





                break;
            case R.id.twos:

                break;
            case R.id.threes:

                break;
            case R.id.fours:

                break;
            case R.id.fives:

                break;
            case R.id.sixes:

                break;
            case R.id.pair:

                break;
            case R.id.two_pairs:

                break;
            case R.id.three_of_a_kind:

                break;
            case R.id.quads:

                break;
            case R.id.small_straight:

                break;
            case R.id.big_straight:

                break;
            case R.id.full_house:

                break;
            case R.id.chance:

                break;
            case R.id.yatzy:

                break;








        }






    }






}
