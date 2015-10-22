package com.example.marcusedition.pdd;

import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import java.util.List;

/**
 * Created by victor on 29.09.15.
 */
public class ZnakAdapter extends PagerAdapter {

    private List<View> pages = null;

    /**
     * Конструктор для спеціального адаптеру під розміткову сторінку
     * @param pages
     */
    public ZnakAdapter(List<View> pages){
        this.pages = pages;
    }

    /**
     * Метод для позначення початкового елементу в тому activity де є можливість перелистувати
     * @param collection
     * @param position
     * @return
     */
    @Override
    public Object instantiateItem(View collection, int position){
        View v = pages.get(position);
        ((ViewPager) collection).addView(v, 0);
        return v;
    }

    /**
     * Метод для знищення поточного елементу
     * @param collection
     * @param position
     * @param view
     */
    @Override
    public void destroyItem(View collection, int position, Object view){
        ((ViewPager) collection).removeView((View) view);
    }

    /**
     * Метод для поврення кількості сторінок
     * @return
     */
    @Override
    public int getCount(){
        return pages.size();
    }

    /**
     * Метод визначення чи поточний View є Object
     * @param view
     * @param object
     * @return
     */
    @Override
    public boolean isViewFromObject(View view, Object object){
        return view.equals(object);
    }

    /**
     * Метод для завершення оновлення
     * @param arg0
     */
    @Override
    public void finishUpdate(View arg0){
    }

    /**
     * Метод для відновлення стану
     * @param arg0
     * @param arg1
     */
    @Override
    public void restoreState(Parcelable arg0, ClassLoader arg1){
    }

    /**
     * Метод для збереження поточного стану
     * @return
     */
    @Override
    public Parcelable saveState(){
        return null;
    }

    /**
     * Метод для початку оновлення
     * @param arg0
     */
    @Override
    public void startUpdate(View arg0){
    }
}