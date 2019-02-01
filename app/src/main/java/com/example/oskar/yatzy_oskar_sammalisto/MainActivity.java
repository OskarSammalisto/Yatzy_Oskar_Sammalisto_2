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
    private int roundCounter = 0;
    private static String playerOne;
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
//        createPlayers();





        // Test code to see that string from start screen is saved
        // TextView textView = (TextView) findViewById(R.id.testString);
        // textView.setText(playerOneCreated.getName());

        // testing avatar spinner int
        // textView.setText(String.valueOf(playerOneAvatar));


    }

//        public void createPlayers(){
//
//        playerOne = getIntent().getStringExtra("playerOne");
//        playerTwo = getIntent().getStringExtra("playerTwo");
//
//
//
//    }



    Human_Player playerOneCreated = new Human_Player(playerOne);  //take away avatar or change how its set
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

        if(roundCounter < 30){








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


            //untoggle buttons at start of round
            if(throwCounter == 0){

                buttonOne.setChecked(false);
                buttonTwo.setChecked(false);
                buttonThree.setChecked(false);
                buttonFour.setChecked(false);
                buttonFive.setChecked(false);


            }


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








        }

    }


    public void scoreboardClicked(View view){

        String id = getResources().getResourceName(view.getId());

       // Toast.makeText(this, id.toString() + " clicker worked.", Toast.LENGTH_SHORT).show();
        int toastRuler = 0;

    if(throwCounter!= 0) {
        switch (view.getId()) {
            case R.id.ones:


                if (playerTurnIndicator == 1 && playerOneCreated.getFieldCheck(0) != 1) {

                    playerOneCreated.setScoreArray(0, YatzyScoring.ones(throwArray));
                    playerOneCreated.setFieldChecker(0);

                    TextView textView = findViewById(R.id.onesOne);
                    textView.setText(Integer.toString(playerOneCreated.getScoreArray()[0]));

                    roundCounter++;
                    playerTurnIndicator = 2;
                    throwCounter = 0;

//                int setScore = YatzyScoring.ones(throwArray);
//                textView.setText(Integer.toString(setScore));


                    /* YatzyScoring.ones(throwArray); */
//                 TextView textView = findViewById(R.id.testString);
//                String name = playerOneCreated.getName();
//                 textView.setText(name);

                }

                else if(playerTurnIndicator == 2 && playerTwoCreated.getFieldCheck(0) != 1) {
                    playerTwoCreated.setScoreArray(0, YatzyScoring.ones(throwArray));
                    playerTwoCreated.setFieldChecker(0);

                    TextView textView = findViewById(R.id.onesTwo);
                    textView.setText(Integer.toString(playerTwoCreated.getScoreArray()[0]));

                    roundCounter++;
                    playerTurnIndicator = 1;
                    throwCounter = 0;
                }

                else {
                    Toast.makeText(this, "This field is already played!.", Toast.LENGTH_SHORT).show();
                    toastRuler = 1;
                }


                break;
            case R.id.twos:

                if (playerTurnIndicator == 1) {

                    playerOneCreated.setScoreArray(1, YatzyScoring.twos(throwArray));
                    playerOneCreated.setFieldChecker(1);

                    TextView textView = findViewById(R.id.twosOne);
                    textView.setText(Integer.toString(playerOneCreated.getScoreArray()[1]));

                    roundCounter++;
                    playerTurnIndicator = 2;
                    throwCounter = 0;



                } else {
                    playerTwoCreated.setScoreArray(1, YatzyScoring.twos(throwArray));
                    playerTwoCreated.setFieldChecker(1);

                    TextView textView = findViewById(R.id.twosTwo);
                    textView.setText(Integer.toString(playerTwoCreated.getScoreArray()[1]));

                    roundCounter++;
                    playerTurnIndicator = 1;
                    throwCounter = 0;
                }

                break;
            case R.id.threes:

                if (playerTurnIndicator == 1) {

                    playerOneCreated.setScoreArray(2, YatzyScoring.threes(throwArray));
                    playerOneCreated.setFieldChecker(2);

                    TextView textView = findViewById(R.id.threesOne);
                    textView.setText(Integer.toString(playerOneCreated.getScoreArray()[2]));

                    roundCounter++;
                    playerTurnIndicator = 2;
                    throwCounter = 0;



                } else {
                    playerTwoCreated.setScoreArray(2, YatzyScoring.threes(throwArray));
                    playerTwoCreated.setFieldChecker(2);

                    TextView textView = findViewById(R.id.threesTwo);
                    textView.setText(Integer.toString(playerTwoCreated.getScoreArray()[2]));

                    roundCounter++;
                    playerTurnIndicator = 1;
                    throwCounter = 0;
                }

                break;
            case R.id.fours:

                if (playerTurnIndicator == 1) {

                    playerOneCreated.setScoreArray(3, YatzyScoring.fours(throwArray));
                    playerOneCreated.setFieldChecker(3);

                    TextView textView = findViewById(R.id.foursOne);
                    textView.setText(Integer.toString(playerOneCreated.getScoreArray()[3]));

                    roundCounter++;
                    playerTurnIndicator = 2;
                    throwCounter = 0;



                } else {
                    playerTwoCreated.setScoreArray(3, YatzyScoring.fours(throwArray));
                    playerTwoCreated.setFieldChecker(3);

                    TextView textView = findViewById(R.id.foursTwo);
                    textView.setText(Integer.toString(playerTwoCreated.getScoreArray()[3]));

                    roundCounter++;
                    playerTurnIndicator = 1;
                    throwCounter = 0;
                }

                break;
            case R.id.fives:

                if (playerTurnIndicator == 1) {

                    playerOneCreated.setScoreArray(4, YatzyScoring.fives(throwArray));
                    playerOneCreated.setFieldChecker(4);

                    TextView textView = findViewById(R.id.fivesOne);
                    textView.setText(Integer.toString(playerOneCreated.getScoreArray()[4]));

                    roundCounter++;
                    playerTurnIndicator = 2;
                    throwCounter = 0;



                } else {
                    playerTwoCreated.setScoreArray(4, YatzyScoring.fives(throwArray));
                    playerTwoCreated.setFieldChecker(4);

                    TextView textView = findViewById(R.id.fivesTwo);
                    textView.setText(Integer.toString(playerTwoCreated.getScoreArray()[4]));

                    roundCounter++;
                    playerTurnIndicator = 1;
                    throwCounter = 0;
                }


                break;
            case R.id.sixes:

                if (playerTurnIndicator == 1) {

                    playerOneCreated.setScoreArray(5, YatzyScoring.sixes(throwArray));
                    playerOneCreated.setFieldChecker(5);

                    TextView textView = findViewById(R.id.sixesOne);
                    textView.setText(Integer.toString(playerOneCreated.getScoreArray()[5]));

                    roundCounter++;
                    playerTurnIndicator = 2;
                    throwCounter = 0;



                } else {
                    playerTwoCreated.setScoreArray(5, YatzyScoring.sixes(throwArray));
                    playerTwoCreated.setFieldChecker(5);

                    TextView textView = findViewById(R.id.sixesTwo);
                    textView.setText(Integer.toString(playerTwoCreated.getScoreArray()[5]));

                    roundCounter++;
                    playerTurnIndicator = 1;
                    throwCounter = 0;
                }

                break;
            case R.id.pair:

                if (playerTurnIndicator == 1) {

                    playerOneCreated.setScoreArray(7, YatzyScoring.pair(throwArray));
                    playerOneCreated.setFieldChecker(7);

                    TextView textView = findViewById(R.id.pairOne);
                    textView.setText(Integer.toString(playerOneCreated.getScoreArray()[7]));

                    roundCounter++;
                    playerTurnIndicator = 2;
                    throwCounter = 0;



                } else {
                    playerTwoCreated.setScoreArray(7, YatzyScoring.pair(throwArray));
                    playerTwoCreated.setFieldChecker(7);

                    TextView textView = findViewById(R.id.pairTwo);
                    textView.setText(Integer.toString(playerTwoCreated.getScoreArray()[7]));

                    roundCounter++;
                    playerTurnIndicator = 1;
                    throwCounter = 0;
                }

                break;
            case R.id.two_pairs:

                if (playerTurnIndicator == 1) {

                    playerOneCreated.setScoreArray(8, YatzyScoring.twoPairs(throwArray));
                    playerOneCreated.setFieldChecker(8);

                    TextView textView = findViewById(R.id.twoPairOne);
                    textView.setText(Integer.toString(playerOneCreated.getScoreArray()[8]));

                    roundCounter++;
                    playerTurnIndicator = 2;
                    throwCounter = 0;



                } else {
                    playerTwoCreated.setScoreArray(8, YatzyScoring.twoPairs(throwArray));
                    playerTwoCreated.setFieldChecker(8);

                    TextView textView = findViewById(R.id.twoPairTwo);
                    textView.setText(Integer.toString(playerTwoCreated.getScoreArray()[8]));

                    roundCounter++;
                    playerTurnIndicator = 1;
                    throwCounter = 0;
                }

                break;
            case R.id.three_of_a_kind:

                if (playerTurnIndicator == 1) {

                    playerOneCreated.setScoreArray(9, YatzyScoring.threeOfaKind(throwArray));
                    playerOneCreated.setFieldChecker(9);

                    TextView textView = findViewById(R.id.threeOfOne);
                    textView.setText(Integer.toString(playerOneCreated.getScoreArray()[9]));

                    roundCounter++;
                    playerTurnIndicator = 2;
                    throwCounter = 0;



                } else {
                    playerTwoCreated.setScoreArray(9, YatzyScoring.threeOfaKind(throwArray));
                    playerTwoCreated.setFieldChecker(9);

                    TextView textView = findViewById(R.id.threeOfTwo);
                    textView.setText(Integer.toString(playerTwoCreated.getScoreArray()[9]));

                    roundCounter++;
                    playerTurnIndicator = 1;
                    throwCounter = 0;
                }

                break;
            case R.id.quads:

                if (playerTurnIndicator == 1) {

                    playerOneCreated.setScoreArray(10, YatzyScoring.quads(throwArray));
                    playerOneCreated.setFieldChecker(10);

                    TextView textView = findViewById(R.id.quadsOne);
                    textView.setText(Integer.toString(playerOneCreated.getScoreArray()[10]));

                    roundCounter++;
                    playerTurnIndicator = 2;
                    throwCounter = 0;



                } else {
                    playerTwoCreated.setScoreArray(10, YatzyScoring.quads(throwArray));
                    playerTwoCreated.setFieldChecker(10);

                    TextView textView = findViewById(R.id.quadsTwo);
                    textView.setText(Integer.toString(playerTwoCreated.getScoreArray()[10]));

                    roundCounter++;
                    playerTurnIndicator = 1;
                    throwCounter = 0;
                }

                break;
            case R.id.small_straight:

                if (playerTurnIndicator == 1) {

                    playerOneCreated.setScoreArray(11, YatzyScoring.smallStraight(throwArray));
                    playerOneCreated.setFieldChecker(11);

                    TextView textView = findViewById(R.id.smallStOne);
                    textView.setText(Integer.toString(playerOneCreated.getScoreArray()[11]));

                    roundCounter++;
                    playerTurnIndicator = 2;
                    throwCounter = 0;



                } else {
                    playerTwoCreated.setScoreArray(11, YatzyScoring.smallStraight(throwArray));
                    playerTwoCreated.setFieldChecker(11);

                    TextView textView = findViewById(R.id.smallStTwo);
                    textView.setText(Integer.toString(playerTwoCreated.getScoreArray()[11]));

                    roundCounter++;
                    playerTurnIndicator = 1;
                    throwCounter = 0;
                }

                break;
            case R.id.big_straight:

                if (playerTurnIndicator == 1) {

                    playerOneCreated.setScoreArray(12, YatzyScoring.bigStraight(throwArray));
                    playerOneCreated.setFieldChecker(12);

                    TextView textView = findViewById(R.id.largeStOne);
                    textView.setText(Integer.toString(playerOneCreated.getScoreArray()[12]));

                    roundCounter++;
                    playerTurnIndicator = 2;
                    throwCounter = 0;



                } else {
                    playerTwoCreated.setScoreArray(12, YatzyScoring.bigStraight(throwArray));
                    playerTwoCreated.setFieldChecker(12);

                    TextView textView = findViewById(R.id.largeStTwo);
                    textView.setText(Integer.toString(playerTwoCreated.getScoreArray()[12]));

                    roundCounter++;
                    playerTurnIndicator = 1;
                    throwCounter = 0;
                }

                break;
            case R.id.full_house:

                if (playerTurnIndicator == 1) {

                    playerOneCreated.setScoreArray(13, YatzyScoring.fullHouse(throwArray));
                    playerOneCreated.setFieldChecker(13);

                    TextView textView = findViewById(R.id.fullHouseOne);
                    textView.setText(Integer.toString(playerOneCreated.getScoreArray()[13]));

                    roundCounter++;
                    playerTurnIndicator = 2;
                    throwCounter = 0;



                } else {
                    playerTwoCreated.setScoreArray(13, YatzyScoring.fullHouse(throwArray));
                    playerTwoCreated.setFieldChecker(13);

                    TextView textView = findViewById(R.id.fullHouseTwo);
                    textView.setText(Integer.toString(playerTwoCreated.getScoreArray()[13]));

                    roundCounter++;
                    playerTurnIndicator = 1;
                    throwCounter = 0;
                }

                break;
            case R.id.chance:

                if (playerTurnIndicator == 1) {

                    playerOneCreated.setScoreArray(14, YatzyScoring.chance(throwArray));
                    playerOneCreated.setFieldChecker(14);

                    TextView textView = findViewById(R.id.chanceOne);
                    textView.setText(Integer.toString(playerOneCreated.getScoreArray()[14]));

                    roundCounter++;
                    playerTurnIndicator = 2;
                    throwCounter = 0;



                } else {
                    playerTwoCreated.setScoreArray(14, YatzyScoring.chance(throwArray));
                    playerTwoCreated.setFieldChecker(14);

                    TextView textView = findViewById(R.id.chanceTwo);
                    textView.setText(Integer.toString(playerTwoCreated.getScoreArray()[14]));

                    roundCounter++;
                    playerTurnIndicator = 1;
                    throwCounter = 0;
                }

                break;
            case R.id.yatzy:

                if (playerTurnIndicator == 1) {

                    playerOneCreated.setScoreArray(15, YatzyScoring.yatzy(throwArray));
                    playerOneCreated.setFieldChecker(15);

                    TextView textView = findViewById(R.id.yatzyOne);
                    textView.setText(Integer.toString(playerOneCreated.getScoreArray()[15]));

                    roundCounter++;
                    playerTurnIndicator = 2;
                    throwCounter = 0;



                } else {
                    playerTwoCreated.setScoreArray(15, YatzyScoring.yatzy(throwArray));
                    playerTwoCreated.setFieldChecker(15);

                    TextView textView = findViewById(R.id.yatzyTwo);
                    textView.setText(Integer.toString(playerTwoCreated.getScoreArray()[15]));

                    roundCounter++;
                    playerTurnIndicator = 1;
                    throwCounter = 0;
                }

                break;


        }
    }

        if(playerTurnIndicator == 1 && toastRuler != 1){
            Toast.makeText(this, "Player Ones Turn!.", Toast.LENGTH_SHORT).show();
        }

        if (playerTurnIndicator == 2 && toastRuler != 1){
            Toast.makeText(this, "Player Twos Turn!.", Toast.LENGTH_SHORT).show();
        }


                                                                                //always returns zero
        TextView textView = findViewById(R.id.totalOne);
        int sumPlayerOne = playerOneCreated.getScoreArraySum();
        textView.setText(Integer.toString(sumPlayerOne));

        TextView textViewTwo = findViewById(R.id.totalTwo);
        int sumPlayerTwo = playerTwoCreated.getScoreArraySum();
        textViewTwo.setText(Integer.toString(sumPlayerTwo));


        toastRuler = 0;

    }






}
