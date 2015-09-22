package com.example.marcusedition.pddproject;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity implements OnTouchListener
{
    private ViewFlipper flipper = null;
    private float fromPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Устанавливаем listener касаний, для последующего перехвата жестов
        RelativeLayout mainLayout = (RelativeLayout) findViewById(R.id.main_screen);
        mainLayout.setOnTouchListener(this);

        // Получаем объект ViewFlipper
        flipper = (ViewFlipper) findViewById(R.id.flipper);

        // Создаем View и добавляем их в уже готовый flipper
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        int layouts[] = new int[]{R.layout.choser_menu,R.layout.main_menu};
        for (int layout : layouts) {
            flipper.addView(inflater.inflate(layout, null));
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onTouch(View v, MotionEvent e)
    {
        findViewById(R.id.main_text).setVisibility(View.INVISIBLE);
        findViewById(R.id.textMenu).setVisibility(View.VISIBLE);
        findViewById(R.id.textChoser).setVisibility(View.VISIBLE);
        switch (e.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                fromPosition = e.getX();
                break;
            case MotionEvent.ACTION_UP:
                float toPosition = e.getX();
                if (fromPosition > toPosition)
                {
                    flipper.setInAnimation(AnimationUtils.loadAnimation(this, R.anim.go_next_in));
                    flipper.setOutAnimation(AnimationUtils.loadAnimation(this,R.anim.go_next_out));
                    flipper.showNext();
                }
                else if (fromPosition < toPosition)
                {
                    flipper.setInAnimation(AnimationUtils.loadAnimation(this,R.anim.go_prev_in));
                    flipper.setOutAnimation(AnimationUtils.loadAnimation(this,R.anim.go_prev_out));
                    flipper.showPrevious();
                }
            default:
                break;
        }
        return true;
    }
}