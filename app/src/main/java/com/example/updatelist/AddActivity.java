package com.example.updatelist;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity implements View.OnClickListener {
    EditText txtnewString;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        txtnewString = findViewById(R.id.newstring);
        button = findViewById(R.id.button);

        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String data = txtnewString.getText().toString();
        Intent intent = new Intent();
        intent.putExtra("textdata",data);
        setResult(Activity.RESULT_OK,intent);
        finish();
    }
}