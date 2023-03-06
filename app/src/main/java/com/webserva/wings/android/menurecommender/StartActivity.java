package com.webserva.wings.android.menurecommender;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        Button btnStart = findViewById(R.id.btn_start);
        Button btnPost = findViewById(R.id.btn_post);
        Button btnHistory = findViewById(R.id.btn_history);
        btnStart.setOnClickListener(this);
        btnPost.setOnClickListener(this);
        btnHistory.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.btn_start:
                intent = new Intent(StartActivity.this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_post:
                intent = new Intent(StartActivity.this, PostActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_history:
                intent = new Intent(StartActivity.this, HistoryActivity.class);
                startActivity(intent);
                break;
        }
         ;


    }
}