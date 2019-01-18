package com.example.oskar.yatzy_oskar_sammalisto;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

public class DiceEventListener extends AppCompatImageView {


    private Drawable defaultImage;
    private int onPressDie;


    public DiceEventListener(Context context) {
        super(context);
        selectNewName();
    }

    public DiceEventListener(Context context, AttributeSet attrs) {
        super(context, attrs);
        selectNewName();
    }

    public DiceEventListener(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        selectNewName();
    }

    private void selectNewName(){

    }





}
