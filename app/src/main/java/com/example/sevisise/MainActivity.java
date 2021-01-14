package com.example.sevisise;

import androidx.appcompat.app.AppCompatActivity ;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.sevisise.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button start;
    private Button stop;

    Intent service = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start = findViewById(R.id.start);
        stop = findViewById(R.id.stop);

        start.setOnClickListener(this);
        stop.setOnClickListener(this);

        service = new Intent(this , MyServise.class);
    }

    @Override
    public void onClick(View v) {
        if (v.equals(start)) {
            startService(service);
        } else if (v.equals(stop)) {
            stopService(service);
        }
    }
}