package com.example.oskar.yatzy_oskar_sammalisto;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class StartScreen extends AppCompatActivity {

    RadioGroup radioGroup;
    RadioButton radioButton;
//    final String MyPREFERENCES = "MyPREFERENCES";
//    final String NAME_KEY = "namekey";

//    EditText playerOne;
//    EditText playerTwo;

//    SharedPreferences sharedPref;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_screen);

        radioGroup = findViewById(R.id.radioGroup);

        Spinner spinnerPlayerOne = (Spinner) findViewById(R.id.avatarPlayerOne);
        Spinner spinnerPlayerTwo = (Spinner) findViewById(R.id.avatarPlayerTwo);

        ArrayAdapter<CharSequence> avatarAdapter = ArrayAdapter.createFromResource(this, R.array.avatars, android.R.layout.simple_spinner_item);

        spinnerPlayerOne.setAdapter(avatarAdapter);
        spinnerPlayerTwo.setAdapter(avatarAdapter);


    }

    public void startGame(View view){



        //saves names from EditText and sends them to MainActivity. Also starts MainActivity unless either name is empty.

        EditText playerOne = findViewById(R.id.playerOne);
        EditText playerTwo = findViewById(R.id.playerTwo);

       // sharedPref = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        String playerOneName = playerOne.getText().toString();//sharedPref.getString(NAME_KEY, null);
        String playerTwoName = playerTwo.getText().toString();//sharedPref.getString(NAME_KEY, null);


        //reads player name and sends to MainActivity

        Spinner spinnerPlayerOne = (Spinner) findViewById(R.id.avatarPlayerOne);
        Spinner spinnerPlayerTwo = (Spinner) findViewById(R.id.avatarPlayerTwo);

        int playerOneAvatarNumber = spinnerPlayerOne.getSelectedItemPosition();
        int playerTwoAvatarNumber = spinnerPlayerTwo.getSelectedItemPosition();


        //reads game mode. 2p or vsAi , 0 = vs ai, 1 = 2 player

        RadioButton playerMode = findViewById(R.id.twoPlayer);
        int gameMode = 0;

        if(playerMode.isChecked()){
            gameMode = 1;
        }


//        if (playerOneName != null )
//            playerOne.setText(playerOneName);
//
//        if (playerTwoName != null )
//            playerTwo.setText(playerTwoName);

       if(playerOneName.length() != 0 && playerTwoName.length() != 0){


        Intent startGame = new Intent(StartScreen.this, MainActivity.class);


        startGame.putExtra("playerOne", playerOneName);
        startGame.putExtra("playerTwo", playerTwoName);
        startGame.putExtra("avatar_player_one", playerOneAvatarNumber);
        startGame.putExtra("avatar_player_two", playerTwoAvatarNumber);
        startGame.putExtra("game_mode", gameMode);

        startActivity(startGame);
       }
       else {
           Toast.makeText(this, R.string.fillNameToast, Toast.LENGTH_LONG).show();
       }
    }

    public void checkButton(View view){
        //is button checked
        boolean checked = ((RadioButton) view).isChecked();
        int menuSelection = radioGroup.getCheckedRadioButtonId();
        EditText playerTwo = findViewById(R.id.playerTwo);

        radioButton = findViewById(menuSelection);

        Toast.makeText(this,  radioButton.getText() + " mode selected.", Toast.LENGTH_SHORT).show();

//        see which button is clicked
        switch (view.getId()){

            case R.id.twoPlayer:
                if (checked)

                    playerTwo.setFocusableInTouchMode(true);
                    playerTwo.setText("");

                    break;
            case  R.id.vsAi:
                if (checked)

                    playerTwo.setFocusable(false);
                    playerTwo.setText(R.string.aiName);


                    break;
        }
    }

}
