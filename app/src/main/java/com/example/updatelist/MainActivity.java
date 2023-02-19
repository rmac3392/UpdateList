package com.example.updatelist;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    EditText textSearch;
    ArrayAdapter<String> adapter;
    ArrayList<String> list = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        list.add(new String("Alpha"));
        list.add(new String("Bravo"));
        list.add(new String("Charlie"));
        list.add(new String("Delta"));
        //
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,list);
        lv = findViewById(R.id.listView1);
        lv.setAdapter(adapter);
        textSearch = findViewById(R.id.searchText);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.getMenuInflater().inflate(R.menu.mymenu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent = new Intent(this,AddActivity.class);
        startActivityForResult(intent,0);
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == Activity.RESULT_OK){
            if(requestCode==0){
                Bundle b = data.getExtras();
                String txt = b.getString("textdata");
                list.add(txt);
                adapter.notifyDataSetChanged();
            }
        }
    }
}