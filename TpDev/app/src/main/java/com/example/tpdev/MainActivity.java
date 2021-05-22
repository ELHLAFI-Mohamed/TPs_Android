package com.example.tpdev;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         Button bt1 = (Button) findViewById(R.id.button22);
         Button bt2 = (Button) findViewById(R.id.button23);
         Button bt3 = (Button) findViewById(R.id.button24);
         Button bt4 = (Button) findViewById(R.id.button25);
         ImageView imageView = (ImageView)  findViewById(R.id.imageView);
         bt1.setOnClickListener(new View.OnClickListener(){
                                    public void onClick(View V){

                                        imageView.setImageResource(R.drawable.summer);
             }
                                }
         );
        bt2.setOnClickListener(new View.OnClickListener(){
                                   public void onClick(View V){
                                       imageView.setImageResource(R.drawable.autumn);
                                   }
                               }
        );
        bt3.setOnClickListener(new View.OnClickListener(){
                                   public void onClick(View V){
                                       imageView.setImageResource(R.drawable.hiver);
                                   }
                               }
        );
        bt4.setOnClickListener(new View.OnClickListener(){
                                   public void onClick(View V){
                                       imageView.setImageResource(R.drawable.spring);
                                   }
                               }
        );


    }
}