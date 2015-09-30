package com.example.marcusedition.pdd;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

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
                    while(logoTimer < 3000)
                    {
                        sleep(100);
                        logoTimer = logoTimer + 100;
                    }
                    System.out.println("In onCreate Main");
                    startActivity(new Intent(getApplicationContext(), MainMenuActivity.class));
                }
                catch (InterruptedException e)
                {
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
