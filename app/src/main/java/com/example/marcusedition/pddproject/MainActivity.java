package com.example.marcusedition.pddproject;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends ListActivity {

    String[] str = {
            "§ 1. Загальні положення",
            "§ 2. Обов’язки і права водіїв механічних транспортних засобів",
            "§ 3. Рух транспортних засобів із спеціальними сигналами",
            "§ 4. Обов’язки і права пішоходів",
            "§ 5. Обов’язки і права пасажирів",
            "§ 6. Вимоги до велосипедистів",
            "§ 7. Вимоги до осіб, які керують гужовим транспортом, і погоничів тварин",
            "§ 8. Регулювання дорожнього руху",
            "§ 9. Попереджувальні сигнали",
            "§ 10. Початок руху та зміна його напрямку",
            "§ 11. Розташування транспортних засобів на дорозі",
            "§ 12. Швидкість руху",
            "§ 13. Дистанція, інтервал, зустрічний роз’їзд",
            "§ 14. Обгін",
            "§ 15. Зупинка і стоянка",
            "§ 16. Проїзд перехресть",
            "§ 17. Переваги маршрутних транспортних засобів",
            "§ 18. Проїзд пішохідних переходів і зупинок транспортних засобів",
            "§ 19. Kористування зовнішніми світловими приладами",
            "§ 20. Рух через залізничні переїзди",
            "§ 21. Перевезення пасажирів",
            "§ 22. Перевезення вантажу",
            "§ 23. Буксирування та експлуатація транспортних составів",
            "§ 24. Навчальна їзда",
            "§ 25. Рух транспортних засобів у колонах",
            "§ 26. Рух у житловій та пішохідній зоні",
            "§ 27. Рух по автомагістралях і дорогах для автомобілів",
            "§ 28. Рух по гірських дорогах і на крутих спусках",
            "§ 29. Міжнародний рух",
            "§ 30. Номерні, розпізнавальні знаки, написи і позначення",
            "§ 31. Технічний стан транспортних засобів та їх обладнання",
            "§ 32. Питання, що потребують узгодження з ДАІ",
            "§ 33. Дорожні знаки",
            "§ 34. Дорожня розмітка"};


    List<String> charts = Arrays.asList(str);

    private ArrayAdapter mAdapter = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, charts);

        setListAdapter(mAdapter);
        this.startActivity(this.getIntent());
    }


    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Toast.makeText(getApplicationContext(),
                "Ви вибрали " + l.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();

    }
}
