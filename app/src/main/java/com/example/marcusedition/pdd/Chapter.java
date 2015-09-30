package com.example.marcusedition.pdd;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

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
        TextView chapterText = (TextView) findViewById(R.id.textChapter);
        AssetManager assetManager = getAssets();
        InputStream is;
        try {
            String str = "";
            is = assetManager.open("chart" + numbChapter + ".txt");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            str = new String(buffer);
            chapterText.append(str);
        } catch (IOException e) {
            e.printStackTrace();
        }

//        public void readFile(File file)
//        {
//            org.apache.poi.hwpf.extractor.WordExtractor extractor = null;
//            try
//            {
//                file = new File("c:\\New.doc");
//                FileInputStream fis = new FileInputStream(file.getAbsolutePath());
//                org.apache.poi.hwpf.extractor.HWPFDocument document = new HWPFDocument(fis);
//                extractor = new org.apache.poi.hwpf.extractor.WordExtractor(document);
//                String[] fileData = extractor.getParagraphText();
//                for (int i = 0; i < fileData.length; i++)
//                {
//                    if (fileData[i] != null)
//                        System.out.println(fileData[i]);
//                }
//            }
//            catch (Exception exep)
//            {
//                exep.printStackTrace();
//            }
//        }
    }
}
