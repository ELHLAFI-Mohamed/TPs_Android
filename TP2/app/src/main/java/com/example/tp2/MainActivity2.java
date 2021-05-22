package com.example.tp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent = getIntent();
        final Button view_page = (Button) findViewById(R.id.button2);
        final Button compose_number = (Button) findViewById(R.id.button3);
        final TextView txt1 = (TextView)findViewById(R.id.textView3);
        final TextView txt2 =  (TextView)findViewById(R.id.textView4);
        final TextView txt3 =  (TextView)findViewById(R.id.textView5);
        final TextView txt4 =  (TextView)findViewById(R.id.textView6);
        txt1.setText("Ton nom est : " + intent.getStringExtra("key1"));
        txt2.setText("Ton Numero est : " + intent.getStringExtra("key2"));
        txt3.setText("Ton Age est : " + intent.getStringExtra("key3"));
        txt4.setText("Ton url  est : " + intent.getStringExtra("key4"));
        view_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = "http://"+intent.getStringExtra("key4");
                Uri monUri1 = Uri.parse(s);
                Intent intent1 = new Intent(Intent.ACTION_VIEW,monUri1);
                startActivity(intent1);

            }
        });
        compose_number.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = "tel:"+intent.getStringExtra("key2");
                Uri monUri2 = Uri.parse(s);
                Intent intent2 = new Intent(Intent.ACTION_DIAL,monUri2);
                startActivity(intent2);

            }
        });

    }
}