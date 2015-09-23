package com.example.marcusedition.pddproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.example.marcusedition.pddproject.otherActivity.MainMenuActivity;

public class MainActivity extends Activity {



    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.load_page);

        Thread logoTimer = new Thread()
        {
            public void run()
            {
                try
                {
                    int logoTimer = 0;
                    while(logoTimer < 2000)
                    {
                        sleep(100);
                        logoTimer = logoTimer +100;
                    };
                    startActivity(new Intent(getApplicationContext(), MainMenuActivity.class));
                }
                catch (InterruptedException e)
                {
                    // TODO: автоматически сгенерированный блок catch.
                    e.printStackTrace();
                }
                finally
                {
                    finish();
                }
            }
        };
        logoTimer.start();
    }

}
