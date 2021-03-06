package com.example.marcusedition.pdd;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.TabActivity;
import android.content.DialogInterface;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TabHost;
import android.widget.TextView;

/**
 * Created by victor on 25.09.15.
 */
public class ActivityWithTest extends TabActivity {

    /**
     * Кількість питань
     */
    private static final int COUNT_QUESTION = 20;
    /**
     * Максимальна кількість варіантів відповідей
     */
    private static final int COUNT_BUTTON = 5;

    private Dialog dialog;
    private TextView[] tv = new TextView[COUNT_QUESTION];
    private RadioGroup group;
    private RadioButton[] button;
    private Button checkButton;
    private int countAnswer = 0;

    /**
     * Called when the activity is first created.
     */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_page);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        for (int i = 0; i < COUNT_QUESTION; i++) {
            tv[i] = (TextView)findViewById(R.id.test_text);
        }

        TabHost.TabContentFactory TabFactory = new TabHost.TabContentFactory() {
            @Override
            public View createTabContent(String tag) {
                int numbTag = Integer.parseInt(tag) - 1;
                tv[numbTag] = (TextView) findViewById(R.id.test_text);
                group = (RadioGroup) findViewById(R.id.group);
                fillTabs(tag, numbTag);
                for (int i = 0; i < button.length; i++) {
                    button[i].setTextColor(getResources().getColor(R.color.black));
                    group.addView(button[i]);
                }
                tv[numbTag].setTextColor(getResources().getColor(R.color.black));
                return tv[numbTag];
            }
        };
        final TabHost tabHost = getTabHost();
        TabHost.TabSpec tabSpec;

        for (int i = 1; i < COUNT_QUESTION + 1; i++) {
            tabSpec = tabHost.newTabSpec(String.valueOf(i));
            tabSpec.setContent(TabFactory);
            tabSpec.setIndicator(String.valueOf(i));
            tabHost.addTab(tabSpec);
        }
        tabHost.setCurrentTabByTag("1");
        for (int i = 0; i < COUNT_QUESTION; i++){
            tabHost.getTabWidget().getChildTabViewAt(i).setEnabled(false);
        }
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int nextTab = (Integer.parseInt(tabHost.getCurrentTabTag()) + 1);
                System.out.println(String.valueOf(nextTab));
                if (group.getCheckedRadioButtonId() == R.id.right_answer) {
                    tabHost.getTabWidget().getChildTabViewAt(nextTab - 2).setBackground(getResources().getDrawable(R.color.green));
                    countAnswer++;
                } else {
                    tabHost.getTabWidget().getChildTabViewAt(nextTab - 2).setBackground(getResources().getDrawable(R.color.red));
                }
                group.removeAllViews();
                if (nextTab == COUNT_QUESTION + 1) {
                    showDialog(1);
                }

                tabHost.setCurrentTabByTag(String.valueOf(nextTab));
            }
        });

        group.setVisibility(View.VISIBLE);
    }

    /**
     * Метод для збереження своїх даних при зміні конфігурацій
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
    }

    /**
     * Метод заповнення всіх вкладок даними
     * @param tag
     * @param numbTag
     */
    private void fillTabs(String tag, int numbTag) {
        switch (tag) {
            case "1":
                button = new RadioButton[COUNT_BUTTON - 1];
                for (int i = 0; i < button.length; i++) button[i] = new RadioButton(ActivityWithTest.this);
                tv[numbTag].setText(getResources().getString(R.string.question1));
                button[0].setText(getResources().getString(R.string.answer1_question1));
                /**
                 * Позначення одного із варіантів спеціальним ідентифікаторо - правильна відповідь
                 */
                button[0].setId(R.id.right_answer);
                button[1].setText(getResources().getString(R.string.answer2_question1));
                button[2].setText(getResources().getString(R.string.answer3_question1));
                button[3].setText(getResources().getString(R.string.answer4_question1));
                break;
            case "2":
                button = new RadioButton[COUNT_BUTTON - 3];
                for (int i = 0; i < button.length; i++) button[i] = new RadioButton(ActivityWithTest.this);
                tv[numbTag].setText(getResources().getString(R.string.question2));
                button[0].setText(getResources().getString(R.string.answer1_question2));
                button[1].setText(getResources().getString(R.string.answer2_question2));
                button[0].setId(R.id.right_answer);
                break;
            case "3":
                button = new RadioButton[COUNT_BUTTON - 2];
                for (int i = 0; i < button.length; i++) button[i] = new RadioButton(ActivityWithTest.this);
                tv[numbTag].setText(getResources().getString(R.string.question3));
                button[0].setText(getResources().getString(R.string.answer1_question3));
                button[1].setText(getResources().getString(R.string.answer2_question3));
                button[2].setText(getResources().getString(R.string.answer3_question3));
                button[2].setId(R.id.right_answer);
                break;
            case "4":
                button = new RadioButton[COUNT_BUTTON - 2];
                for (int i = 0; i < button.length; i++) button[i] = new RadioButton(ActivityWithTest.this);
                tv[numbTag].setText(getResources().getString(R.string.question4));
                button[0].setText(getResources().getString(R.string.answer1_question4));
                button[1].setText(getResources().getString(R.string.answer2_question4));
                button[2].setText(getResources().getString(R.string.answer3_question4));
                button[2].setId(R.id.right_answer);
                break;
            case "5":
                button = new RadioButton[COUNT_BUTTON - 3];
                for (int i = 0; i < button.length; i++) button[i] = new RadioButton(ActivityWithTest.this);
                tv[numbTag].setText(getResources().getString(R.string.question5));
                button[0].setText(getResources().getString(R.string.answer1_question5));
                button[1].setText(getResources().getString(R.string.answer2_question5));
                button[1].setId(R.id.right_answer);
                break;
            case "6":
                button = new RadioButton[COUNT_BUTTON - 2];
                for (int i = 0; i < button.length; i++) button[i] = new RadioButton(ActivityWithTest.this);
                tv[numbTag].setText(getResources().getString(R.string.question6));
                button[0].setText(getResources().getString(R.string.answer1_question6));
                button[1].setText(getResources().getString(R.string.answer2_question6));
                button[2].setText(getResources().getString(R.string.answer3_question6));
                button[2].setId(R.id.right_answer);
                break;
            case "7":
                button = new RadioButton[COUNT_BUTTON];
                for (int i = 0; i < button.length; i++) button[i] = new RadioButton(ActivityWithTest.this);
                tv[numbTag].setText(getResources().getString(R.string.question6));
                button[0].setText(getResources().getString(R.string.answer1_question7));
                button[1].setText(getResources().getString(R.string.answer2_question7));
                button[2].setText(getResources().getString(R.string.answer3_question7));
                button[3].setText(getResources().getString(R.string.answer4_question7));
                button[4].setText(getResources().getString(R.string.answer5_question7));
                button[2].setId(R.id.right_answer);
                break;
            case "8":
                button = new RadioButton[COUNT_BUTTON - 1];
                for (int i = 0; i < button.length; i++) button[i] = new RadioButton(ActivityWithTest.this);
                tv[numbTag].setText(getResources().getString(R.string.question8));
                button[0].setText(getResources().getString(R.string.answer1_question8));
                button[1].setText(getResources().getString(R.string.answer2_question8));
                button[2].setText(getResources().getString(R.string.answer3_question8));
                button[3].setText(getResources().getString(R.string.answer4_question8));
                button[3].setId(R.id.right_answer);
                break;
            case "9":
                button = new RadioButton[COUNT_BUTTON - 2];
                for (int i = 0; i < button.length; i++) button[i] = new RadioButton(ActivityWithTest.this);
                tv[numbTag].setText(getResources().getString(R.string.question9));
                button[0].setText(getResources().getString(R.string.answer1_question9));
                button[1].setText(getResources().getString(R.string.answer2_question9));
                button[2].setText(getResources().getString(R.string.answer3_question9));
                button[0].setId(R.id.right_answer);
                break;
            case "10":
                button = new RadioButton[COUNT_BUTTON - 2];
                for (int i = 0; i < button.length; i++) button[i] = new RadioButton(ActivityWithTest.this);
                tv[numbTag].setText(getResources().getString(R.string.question10));
                button[0].setText(getResources().getString(R.string.answer1_question10));
                button[1].setText(getResources().getString(R.string.answer2_question10));
                button[2].setText(getResources().getString(R.string.answer3_question10));
                button[0].setId(R.id.right_answer);
                break;
            case "11":
                button = new RadioButton[COUNT_BUTTON];
                for (int i = 0; i < button.length; i++) button[i] = new RadioButton(ActivityWithTest.this);
                tv[numbTag].setText(getResources().getString(R.string.question11));
                button[0].setText(getResources().getString(R.string.answer1_question11));
                button[1].setText(getResources().getString(R.string.answer2_question11));
                button[2].setText(getResources().getString(R.string.answer3_question11));
                button[3].setText(getResources().getString(R.string.answer4_question11));
                button[4].setText(getResources().getString(R.string.answer5_question11));
                button[4].setId(R.id.right_answer);
                break;
            case "12":
                button = new RadioButton[COUNT_BUTTON - 2];
                for (int i = 0; i < button.length; i++) button[i] = new RadioButton(ActivityWithTest.this);
                tv[numbTag].setText(getResources().getString(R.string.question12));
                button[0].setText(getResources().getString(R.string.answer1_question12));
                button[1].setText(getResources().getString(R.string.answer2_question12));
                button[2].setText(getResources().getString(R.string.answer3_question12));
                button[2].setId(R.id.right_answer);
                break;
            case "13":
                button = new RadioButton[COUNT_BUTTON - 2];
                for (int i = 0; i < button.length; i++) button[i] = new RadioButton(ActivityWithTest.this);
                tv[numbTag].setText(getResources().getString(R.string.question13));
                button[0].setText(getResources().getString(R.string.answer1_question13));
                button[1].setText(getResources().getString(R.string.answer2_question13));
                button[2].setText(getResources().getString(R.string.answer3_question13));
                button[0].setId(R.id.right_answer);
                break;
            case "14":button = new RadioButton[COUNT_BUTTON - 2];
                for (int i = 0; i < button.length; i++) button[i] = new RadioButton(ActivityWithTest.this);
                tv[numbTag].setText(getResources().getString(R.string.question14));
                button[0].setText(getResources().getString(R.string.answer1_question14));
                button[1].setText(getResources().getString(R.string.answer2_question14));
                button[2].setText(getResources().getString(R.string.answer3_question14));
                button[1].setId(R.id.right_answer);
                break;
            case "15":button = new RadioButton[COUNT_BUTTON - 1];
                for (int i = 0; i < button.length; i++) button[i] = new RadioButton(ActivityWithTest.this);
                tv[numbTag].setText(getResources().getString(R.string.question15));
                button[0].setText(getResources().getString(R.string.answer1_question15));
                button[1].setText(getResources().getString(R.string.answer2_question15));
                button[2].setText(getResources().getString(R.string.answer3_question15));
                button[3].setText(getResources().getString(R.string.answer4_question15));
                button[3].setId(R.id.right_answer);
                break;
            case "16":
                button = new RadioButton[COUNT_BUTTON - 2];
                for (int i = 0; i < button.length; i++) button[i] = new RadioButton(ActivityWithTest.this);
                tv[numbTag].setText(getResources().getString(R.string.question16));
                button[0].setText(getResources().getString(R.string.answer1_question16));
                button[1].setText(getResources().getString(R.string.answer2_question16));
                button[2].setText(getResources().getString(R.string.answer3_question16));
                button[2].setId(R.id.right_answer);
                break;
            case "17":
                button = new RadioButton[COUNT_BUTTON - 1];
                for (int i = 0; i < button.length; i++) button[i] = new RadioButton(ActivityWithTest.this);
                tv[numbTag].setText(getResources().getString(R.string.question17));
                button[0].setText(getResources().getString(R.string.answer1_question17));
                button[1].setText(getResources().getString(R.string.answer2_question17));
                button[2].setText(getResources().getString(R.string.answer3_question17));
                button[3].setText(getResources().getString(R.string.answer4_question17));
                button[2].setId(R.id.right_answer);
                break;
            case "18":
                button = new RadioButton[COUNT_BUTTON - 2];
                for (int i = 0; i < button.length; i++) button[i] = new RadioButton(ActivityWithTest.this);
                tv[numbTag].setText(getResources().getString(R.string.question18));
                button[0].setText(getResources().getString(R.string.answer1_question18));
                button[1].setText(getResources().getString(R.string.answer2_question18));
                button[2].setText(getResources().getString(R.string.answer3_question18));
                button[1].setId(R.id.right_answer);
                break;
            case "19":
                button = new RadioButton[COUNT_BUTTON - 2];
                for (int i = 0; i < button.length; i++) button[i] = new RadioButton(ActivityWithTest.this);
                tv[numbTag].setText(getResources().getString(R.string.question19));
                button[0].setText(getResources().getString(R.string.answer1_question19));
                button[1].setText(getResources().getString(R.string.answer2_question19));
                button[2].setText(getResources().getString(R.string.answer3_question19));
                button[0].setId(R.id.right_answer);
                break;
            case "20":button = new RadioButton[COUNT_BUTTON - 1];
                for (int i = 0; i < button.length; i++) button[i] = new RadioButton(ActivityWithTest.this);
                tv[numbTag].setText(getResources().getString(R.string.question20));
                button[0].setText(getResources().getString(R.string.answer1_question20));
                button[1].setText(getResources().getString(R.string.answer2_question20));
                button[2].setText(getResources().getString(R.string.answer3_question20));
                button[3].setText(getResources().getString(R.string.answer4_question20));
                button[2].setId(R.id.right_answer);
                break;
        }
    }

    /**
     * Кінцевий діалог для оприлюднення результату
     * @param id
     * @return
     */
    @Override
    protected Dialog onCreateDialog(int id) {
        if (id == 1) {
            AlertDialog.Builder adb = new AlertDialog.Builder(this);
            adb.setTitle("Кінець тесту");
            adb.setMessage("Ви набрали " + countAnswer + " балів.");
            adb.setPositiveButton("OK", null);
            dialog = adb.create();
            dialog.setOnShowListener(new DialogInterface.OnShowListener() {
                public void onShow(DialogInterface dialog) {
                    Log.d("Dialog", "Show");
                }
            });
            dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                public void onCancel(DialogInterface dialog) {
                    Log.d("Dialog", "Cancel");
                }
            });
            dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                public void onDismiss(DialogInterface dialog) {
                    Log.d("Dialog", "Dismiss");
                    finish();
                }
            });
            return dialog;
        }
        return super.onCreateDialog(id);
    }

    /**
     * Діалог для підтвердження виходу з тесту
     * @param id
     * @return
     */
//    @Override
//    protected Dialog onCreateDialog(int id) {
//        if (id == 1) {
//            AlertDialog.Builder adb = new AlertDialog.Builder(this);
//            adb.setTitle("Вихід");
//            adb.setMessage("Ви впевнені що хочете вийти з тесту?");
//            adb.setPositiveButton("Так", new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialog, int which) {
//                    System.exit(0);
//                }
//            });
//            adb.setNegativeButton("Ні", new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialog, int which) {
//                    return;
//                }
//            });
//            dialog = adb.create();
//            return dialog;
//        }
//        return super.onCreateDialog(id);
//    }
}