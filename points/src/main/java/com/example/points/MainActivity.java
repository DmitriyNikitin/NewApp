package com.example.points;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public  int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View header;
        View footer;

        ArrayList<CheckModel> arrayList = new ArrayList();

        ListView listView = (ListView)findViewById(R.id.list);



        for(int i = 0; i < 10; i++){

            CheckModel model = new CheckModel();
            model.prise = 1500 + i*20;
            model.bonus = 500 + i*15;
            model.adress = "Новоизмайловский проспект 16. к" + (i+1);

            count = count + model.bonus;
            arrayList.add(model);
        }
        CustomListAdapter customListAdapter = new CustomListAdapter(this, arrayList, count);

        header = customListAdapter.createHeader();
        footer = customListAdapter.createFooter();

        Log.d("","");

        listView.addHeaderView(header);
        listView.addFooterView(footer);
        listView.setAdapter(customListAdapter);



    }



}
