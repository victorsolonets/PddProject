package com.example.marcusedition.pdd;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Arrays;
import java.util.List;

/**
 * Created by victor on 23.09.15.
 */
public class ListMenuActivity extends ListActivity {

    /**
     * Дані для роботи зі списком
     */
    private Intent intent;
    private String[] str = new String[34];
    private ArrayAdapter mAdapter = null;

    /**
     * Метод для створення activity
     * @param savedInstanceState
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onResume();
        fillList();

        List<String> charts = Arrays.asList(str);
        mAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, charts);
        setListAdapter(mAdapter);
    }

    /**
     * Заповнення всіх назв глав - зчитується з файлу xml
     */
    private void fillList() {
        str[0] = getResources().getString(R.string.chapter1);
        str[1] = getResources().getString(R.string.chapter2);
        str[2] = getResources().getString(R.string.chapter3);
        str[3] = getResources().getString(R.string.chapter4);
        str[4] = getResources().getString(R.string.chapter5);
        str[5] = getResources().getString(R.string.chapter6);
        str[6] = getResources().getString(R.string.chapter7);
        str[7] = getResources().getString(R.string.chapter8);
        str[8] = getResources().getString(R.string.chapter9);
        str[9] = getResources().getString(R.string.chapter10);
        str[10] = getResources().getString(R.string.chapter11);
        str[11] = getResources().getString(R.string.chapter12);
        str[12] = getResources().getString(R.string.chapter13);
        str[13] = getResources().getString(R.string.chapter14);
        str[14] = getResources().getString(R.string.chapter15);
        str[15] = getResources().getString(R.string.chapter16);
        str[16] = getResources().getString(R.string.chapter17);
        str[17] = getResources().getString(R.string.chapter18);
        str[18] = getResources().getString(R.string.chapter19);
        str[19] = getResources().getString(R.string.chapter20);
        str[20] = getResources().getString(R.string.chapter21);
        str[21] = getResources().getString(R.string.chapter22);
        str[22] = getResources().getString(R.string.chapter23);
        str[23] = getResources().getString(R.string.chapter24);
        str[24] = getResources().getString(R.string.chapter25);
        str[25] = getResources().getString(R.string.chapter26);
        str[26] = getResources().getString(R.string.chapter27);
        str[27] = getResources().getString(R.string.chapter28);
        str[28] = getResources().getString(R.string.chapter29);
        str[29] = getResources().getString(R.string.chapter30);
        str[30] = getResources().getString(R.string.chapter31);
        str[31] = getResources().getString(R.string.chapter32);
        str[32] = getResources().getString(R.string.chapter33);
        str[33] = getResources().getString(R.string.chapter34);
    }


    /**
     * Обробка натискання на вибраний елемент списку і передача в нього номеру в списку
     * @param l
     * @param v
     * @param position
     * @param id
     */
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        int chapter = position + 1;
        intent = new Intent(this, Chapter.class);
        intent.putExtra("numbChapter", chapter);
        this.onStop();
        startActivity(intent);
    }
}