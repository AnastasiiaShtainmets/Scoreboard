package com.example.tablo2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Integer flamingos = 0;
    private Integer fox = 0;
    private TextView flamingosTextView;
    private TextView foxTextView;

    private static final String TAG = "MainActivity";
    @SuppressLint("SetTextI18n")
    @Override
    protected void onResume() {
        super.onResume();
        resetUI();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        flamingosTextView = findViewById(R.id.flamingos_score);
        foxTextView = findViewById(R.id.fox_score);
    }
    @SuppressLint("SetTextI18n")
    public void onClickAddFlamingos(View view) {
        flamingos++;
        flamingosTextView.setText(flamingos.toString());
    }
    @SuppressLint("SetTextI18n")
    public void onClickAddDucks(View view) {
        fox++;
        foxTextView.setText(fox.toString());
    }
    @SuppressLint("SetTextI18n")
    public void onClickButtonClear(View view) {
        flamingos = 0;
        fox = 0;
        resetUI();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("flamingos", flamingos);
        outState.putInt("fox", fox);
        Log.d(TAG, "onSaveInstanceState");
    }
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null && savedInstanceState.containsKey("flamingos")) {
            flamingos= savedInstanceState.getInt("flamingos");
        }
        if ((savedInstanceState != null && savedInstanceState.containsKey("fox"))) {
            fox= savedInstanceState.getInt("fox");
        }
        Log.d(TAG, "onRestoreInstanceState");
    }
    @SuppressLint("SetTextI18n")
    private void resetUI() {
        flamingosTextView.setText(flamingos.toString());
        foxTextView.setText(fox.toString());
        Log.d(TAG, "resetUI");
    }
}