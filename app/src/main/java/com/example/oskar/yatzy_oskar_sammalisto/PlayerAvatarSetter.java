package com.example.oskar.yatzy_oskar_sammalisto;

import android.content.res.TypedArray;
import android.widget.ImageView;

//this class is not used

public class PlayerAvatarSetter extends MainActivity {

    PlayerAvatarSetter(int avatarNumberPlayerOne, int avatarNumberPlayerTwo){


        TypedArray avatarArray = getResources().obtainTypedArray(R.array.avatarArray);
        ImageView imageViewPlayerOne = (ImageView) findViewById(R.id.avatarOne);
        ImageView imageViewPlayerTwo = (ImageView) findViewById(R.id.avatarTwo);

        imageViewPlayerOne.setImageResource(avatarArray.getResourceId(avatarNumberPlayerOne, -1));
        imageViewPlayerTwo.setImageResource(avatarArray.getResourceId(avatarNumberPlayerTwo, -1));


        avatarArray.recycle();




    }


}
