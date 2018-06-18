package com.georgy.newapp;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.Map;


public class Activity extends AppCompatActivity {

    private ListView lvMain;

    final String ATRIBUTE_NAME = "name";
    final String ATRIBUTE_PHONE = "phone";
    final String ATRIBUTE_SKILLS = "skills";

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        HST companyOne = GetFromURL.getCompany();

        ArrayList<Map<String, Object>> data = MakeLayoutData.makeData(companyOne, ATRIBUTE_NAME, ATRIBUTE_PHONE, ATRIBUTE_SKILLS);

        String[] from = {ATRIBUTE_NAME, ATRIBUTE_PHONE, ATRIBUTE_SKILLS};
        int[] to = {R.id.name, R.id.phone, R.id.skills};
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, data, R.layout.onelement, from, to);

        this.lvMain = (ListView) findViewById(R.id.lvMain);
        lvMain.setAdapter(simpleAdapter);

    }
}
