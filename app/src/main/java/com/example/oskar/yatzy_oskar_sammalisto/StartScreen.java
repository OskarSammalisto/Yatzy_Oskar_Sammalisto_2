package com.example.oskar.yatzy_oskar_sammalisto;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class StartScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_screen);

    }

    public void startGame(View view){
        Intent startGame = new Intent(this, MainActivity.class);
        startActivity(startGame);
    }

}
