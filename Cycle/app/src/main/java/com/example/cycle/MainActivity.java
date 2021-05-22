package com.example.cycle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
        int cptAppel= 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cptAppel++;
        Log.i("Etat,","----> Appel N"+cptAppel+":methode OnCreate");
    }

    protected void onStart() {
        super.onStart();
        cptAppel++;
        Log.i("Etat,","----> Appel N"+cptAppel+":methode OnStart");

    }
    protected void onPause() {
        super.onPause();
        cptAppel++;
        Log.i("Etat,","----> Appel N"+cptAppel+":methode OnPause");

    }
    protected void onRestart() {
        super.onRestart();
        cptAppel++;
        Log.i("Etat,","----> Appel N"+cptAppel+":methode OnRestart");

    }
    protected void onResume() {
        super.onResume();
        cptAppel++;
        Log.i("Etat,","----> Appel N"+cptAppel+":methode OnResume");

    }
    protected void onStop() {
        super.onStop();
        cptAppel++;
        Log.i("Etat,","----> Appel N"+cptAppel+":methode OnStop");

    }
    protected void onDestroy() {
        super.onDestroy();
        cptAppel++;
        Log.i("Etat,","----> Appel N"+cptAppel+":methode OnDestroy");

    }
}