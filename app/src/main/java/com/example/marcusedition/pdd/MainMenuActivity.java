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

    private Button buttonStart;
    private Button buttonRools;
    private Button buttonZnak;
    private Button buttonTests;
    private Intent intent;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);

        buttonStart = (Button) findViewById(R.id.button_start);
        buttonRools = (Button) findViewById(R.id.button_rools);
        buttonTests = (Button) findViewById(R.id.button_tests);
        buttonZnak = (Button) findViewById(R.id.button_znak);

        buttonStart.setBackgroundResource(R.drawable.button2);
        buttonRools.setBackgroundResource(R.drawable.button2);
        buttonTests.setBackgroundResource(R.drawable.button2);
        buttonZnak.setBackgroundResource(R.drawable.button2);

        buttonStart.setText(getResources().getString(R.string.start));
        buttonRools.setText(getResources().getString(R.string.rool));
        buttonZnak.setText(getResources().getString(R.string.znak));
        buttonTests.setText(getResources().getString(R.string.test));
    }

    public void startButton(View view){
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
            intent = new Intent(getApplicationContext(),ListMenuActivity.class);
        } else if (view.getId() == R.id.button_tests) {
            intent = new Intent(getApplicationContext(), ActivityWithTest.class);
        } else if (view.getId() == R.id.button_znak){
            intent = new Intent(getApplicationContext(), ZnakActivity.class);
        }
        startActivity(intent);
    }
}
