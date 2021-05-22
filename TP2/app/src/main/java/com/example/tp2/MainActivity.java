package com.example.tp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button submit = (Button) findViewById(R.id.button);
        final EditText Nom = (EditText) findViewById(R.id.editTextTextPersonName2);
        final EditText Age = (EditText) findViewById(R.id.editTextTextPersonName4);
        final EditText number = (EditText) findViewById(R.id.editTextTextPersonName5);
        final EditText URL = (EditText) findViewById(R.id.editTextTextPersonName6);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent monIntent = new Intent(getApplicationContext(), MainActivity2.class);

                monIntent.putExtra("key1",Nom.getText().toString());
                monIntent.putExtra("key2",Age.getText().toString());
                monIntent.putExtra("key3",number.getText().toString());
                monIntent.putExtra("key4",URL.getText().toString());
                startActivity(monIntent);

            }
        });

    }
}


