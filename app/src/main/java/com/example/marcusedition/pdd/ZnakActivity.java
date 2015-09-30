package com.example.marcusedition.pdd;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by victor on 27.09.15.
 */
public class ZnakActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LayoutInflater inflater = LayoutInflater.from(this);
        List<View> pages = new ArrayList<View>();
        System.out.println("String1 = "+R.string.znak1_1);
        System.out.println("String2 = "+ (R.string.znak1_2 - R.string.znak1_1));
        System.out.println("String3 = "+ (R.string.znak1_3 - R.string.znak1_2));
        System.out.println("String4 = "+R.string.znak1_4);

        System.out.println("draw1 = "+R.drawable.znak_1_1);
        System.out.println("draw2 = "+R.drawable.znak_1_2);
        System.out.println("draw3 = "+R.drawable.znak_1_3);
        System.out.println("draw4 = "+R.drawable.znak_1_4);
        int idString = R.string.znak1_1;
        int idDraw = R.drawable.znak_1_1;
        int count = 2;
        for (int i = 0; i < 23; i++) {
            View page = inflater.inflate(R.layout.znak_page, null);
            TextView textView = (TextView) page.findViewById(R.id.text_view);
            ImageView imageView = (ImageView) page.findViewById(R.id.imageView);
            imageView.setImageDrawable(getResources().getDrawable(idDraw));
            textView.setText(getResources().getString(idString));
            pages.add(page);
            idDraw+=count;
            idString+=count;
        }
//        page = inflater.inflate(R.layout.znak_page, null);
//        textView = (TextView) page.findViewById(R.id.text_view);
//        textView.setText("Страница 2");
//        pages.add(page);
//
//        page = inflater.inflate(R.layout.znak_page, null);
//        textView = (TextView) page.findViewById(R.id.text_view);
//        textView.setText("Страница 3");
//        pages.add(page);

        ZnakAdapter pagerAdapter = new ZnakAdapter(pages);
        ViewPager viewPager = new ViewPager(this);
        viewPager.setAdapter(pagerAdapter);
        viewPager.setCurrentItem(1);

        setContentView(viewPager);
    }
}