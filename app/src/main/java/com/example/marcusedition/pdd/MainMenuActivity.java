package com.example.marcusedition.pdd;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by victor on 25.09.15.
 */
public class MainMenuActivity extends Activity {

    Button buttonStart;
    Button buttonRools;
    Button buttonZnak;
    Button buttonTests;
    Intent intent;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);
        System.out.println("In onCreate Main Menu");

        buttonStart = (Button) findViewById(R.id.button_start);
        buttonRools = (Button) findViewById(R.id.button_rools);
        buttonTests = (Button) findViewById(R.id.button_tests);
        buttonZnak = (Button) findViewById(R.id.button_znak);

        buttonStart.setBackgroundResource(R.drawable.button2);
        buttonRools.setBackgroundResource(R.drawable.button2);
        buttonTests.setBackgroundResource(R.drawable.button2);
        buttonZnak.setBackgroundResource(R.drawable.button2);

        buttonStart.setText("Старт");
        buttonRools.setText("Правила");
        buttonZnak.setText("Знаки");
        buttonTests.setText("Тести");
    }

    public void startButton(View view){

        System.out.println("In onClick Main Menu");

        int visible = buttonZnak.getVisibility();
        if(visible != buttonStart.getVisibility()) {
            buttonRools.setVisibility(View.VISIBLE);
            buttonTests.setVisibility(View.VISIBLE);
            buttonZnak.setVisibility(View.VISIBLE);
        } else {
            buttonRools.setVisibility(View.INVISIBLE);
            buttonTests.setVisibility(View.INVISIBLE);
            buttonZnak.setVisibility(View.INVISIBLE);
        }
    }

    public void onClickButton(View view){
        if(view.getId() == R.id.button_start) {
            startButton(view);
            return;
        } else if (view.getId() == R.id.button_rools) {
            System.out.println("In onClick rools");
            intent = new Intent(getApplicationContext(),ListMenuActivity.class);
        } else if (view.getId() == R.id.button_tests) {
            System.out.println("In onClick test");
            intent = new Intent(getApplicationContext(), ActivityWithTest.class);
        } else if (view.getId() == R.id.button_znak){
            System.out.println("In onClick test");
            intent = new Intent(getApplicationContext(), ZnakActivity.class);
        }
        startActivity(intent);
    }
}
