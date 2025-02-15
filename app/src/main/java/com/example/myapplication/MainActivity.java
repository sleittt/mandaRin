package com.example.myapplication;

import static android.content.ContentValues.TAG;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Integer counter = 0;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void one_click_button (View view){
        counter++;
        TextView TXT = (TextView)findViewById(R.id.textView2);
        TXT.setText(counter.toString());
    }
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null &&
                savedInstanceState.containsKey("counter")) {
            counter = savedInstanceState.getInt("counter");
        }
        Log.d(TAG, "onRestoreInstanceState");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt("мандарин", counter);
        Log.d("Instens","onSave");
        Toast.makeText(this, "onSave",Toast.LENGTH_LONG).show();
    }

    @Override
    protected  void onStart(){
        super.onStart();
        Log.d("Instens", "onStart");
        Toast.makeText(this, "onStart", Toast.LENGTH_LONG).show();
    }
    @Override
    protected  void onResume(){
        super.onResume();
        Log.d("Instens", "onResume");
        Toast.makeText(this, "onResume", Toast.LENGTH_LONG).show();
    }
    @Override
    protected  void onPause(){
        super.onPause();
        Log.d("Instens", "onPause");
        Toast.makeText(this, "onPause", Toast.LENGTH_LONG).show();
    }
}