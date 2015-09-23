package com.example.marcusedition.pddproject.otherActivity;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import com.example.marcusedition.pddproject.R;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by victor on 23.09.15.
 */
public class Chapter extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chapter);
        int numbChapter = getIntent().getExtras().getInt("numbChapter");
        TextView chapterText = (TextView)findViewById(R.id.textChapter);
        AssetManager assetManager = getAssets();
        InputStream is;
        try {
            String str = "";
            is = assetManager.open("chart"+numbChapter+".txt");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            str = new String(buffer);
            chapterText.append(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
        chapterText.setMovementMethod(new ScrollingMovementMethod());
    }
}
