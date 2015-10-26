package com.example.marcusedition.pdd;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
    private Button buttonExit;
    private Intent intent;
    private Dialog dialog;

    /**
     * Метод для створення активності та залежностей між об'єктами
     * @param savedInstanceState
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);

        buttonStart = (Button) findViewById(R.id.button_start);
        buttonRools = (Button) findViewById(R.id.button_rools);
        buttonTests = (Button) findViewById(R.id.button_tests);
        buttonZnak = (Button) findViewById(R.id.button_znak);
        buttonExit = (Button) findViewById(R.id.button_exit);

        buttonStart.setBackgroundResource(R.drawable.but);
        buttonRools.setBackgroundResource(R.drawable.but);
        buttonTests.setBackgroundResource(R.drawable.but);
        buttonZnak.setBackgroundResource(R.drawable.but);
        buttonExit.setBackgroundResource(R.drawable.but);

        buttonStart.setText(getResources().getString(R.string.start));
        buttonRools.setText(getResources().getString(R.string.rool));
        buttonZnak.setText(getResources().getString(R.string.znak));
        buttonTests.setText(getResources().getString(R.string.test));
        buttonExit.setText(getResources().getString(R.string.exit));
    }

    /**
     * Метод для збереження даних
     * @param outState
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    /**
     * Метод для відновлення даних
     * @param savedInstanceState
     */
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d("Restore", "onRestoreInstanceState");
    }

    /**
     * Обробка кнопки start, поява інших кнопок після натискання, або зникнення
     * @param view
     */
    public void startButton(View view){
        int visible = buttonZnak.getVisibility();

        if(visible != buttonStart.getVisibility()) {
            buttonRools.setVisibility(View.VISIBLE);
            buttonTests.setVisibility(View.VISIBLE);
            buttonZnak.setVisibility(View.VISIBLE);
            buttonExit.setVisibility(View.VISIBLE);
        } else {
            buttonRools.setVisibility(View.INVISIBLE);
            buttonTests.setVisibility(View.INVISIBLE);
            buttonZnak.setVisibility(View.INVISIBLE);
            buttonExit.setVisibility(View.INVISIBLE);
        }
    }

    /**
     * Метод для обробки різних кнопок, при натисканні
     * на поточну кнопку перехід у відповідне вікно
     * @param view
     */
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
        } else if (view.getId() == R.id.button_exit) {
            showDialog(1);
            return;
        }
        startActivity(intent);
    }

    /**
     * Метод для діалогу з користувачем про підтвердження виходу
     * @param id
     * @return
     */
    @Override
    protected Dialog onCreateDialog(int id) {
        if (id == 1) {
            AlertDialog.Builder adb = new AlertDialog.Builder(this);
            adb.setTitle("Вихід");
            adb.setMessage("Ви впевнені що хочете вийти?");
            adb.setPositiveButton("Так", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    System.exit(0);
                }
            });
            adb.setNegativeButton("Ні", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    return;
                }
            });
            dialog = adb.create();
            return dialog;
        }
        return super.onCreateDialog(id);
    }

    /**
     * Дія при натисканні на кнопку повернення з головного меню
     */
//    @Override
//    public void onBackPressed() {
//        new AlertDialog.Builder(this)
//                .setIcon(android.R.drawable.ic_dialog_alert)
//                .setTitle("Вихід")
//                .setMessage("Ви впевнені, що хочете вийти?")
//                .setPositiveButton("Так", new DialogInterface.OnClickListener()
//                {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.);
//                        if (drawer.isDrawerOpen(GravityCompat.START)) {
//                            drawer.closeDrawer(GravityCompat.START);
//                        } else {
//                            MainMenuActivity.super.onBackPressed();
//                        }
//                        finish();
//                    }
//                })
//                .setNegativeButton("Ні", null)
//                .show();
//    }
}
