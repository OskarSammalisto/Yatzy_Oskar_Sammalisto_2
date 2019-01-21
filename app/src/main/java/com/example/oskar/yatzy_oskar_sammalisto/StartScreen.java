package com.example.oskar.yatzy_oskar_sammalisto;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class StartScreen extends AppCompatActivity {

    RadioGroup radioGroup;
    RadioButton radioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_screen);

        radioGroup = findViewById(R.id.radioGroup);

    }

    public void startGame(View view){
        Intent startGame = new Intent(this, MainActivity.class);
        startActivity(startGame);
    }

    public void checkButton(View view){
        //is button checked
        boolean checked = ((RadioButton) view).isChecked();
        int menuSelection = radioGroup.getCheckedRadioButtonId();

        radioButton = findViewById(menuSelection);

        Toast.makeText(this,  radioButton.getText() + " mode selected.", Toast.LENGTH_SHORT).show();

        //see which button is clicked
        switch (view.getId()){
            case R.id.singlePlayer:
                if (checked)


                    break;
            case R.id.twoPlayer:
                if (checked)

                    break;
            case  R.id.vsAi:
                if (checked)

                    break;
        }
    }

}
