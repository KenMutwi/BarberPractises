package com.ken.mypractises;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class DisplayList extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<Baberfruit> arrayList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_list);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        DisplayData1();

    }
    public void DisplayData1(){
        DatabaseHelper databaseHelper = new DatabaseHelper(this);
        SQLiteDatabase sqLiteDatabase = databaseHelper.getReadableDatabase();

        Cursor cursor = databaseHelper.getAllData1();

        cursor.moveToFirst();
        do{
            Baberfruit baberfruit=new Baberfruit(cursor.getInt(0),cursor.getInt(1),cursor.getInt(2),cursor.getInt(3),cursor.getInt(4));
            arrayList.add(baberfruit);

        }while (cursor.moveToNext());
        databaseHelper.close();

        adapter = new RecyclerAdapter(arrayList);
        recyclerView.setAdapter(adapter);

    }
}
