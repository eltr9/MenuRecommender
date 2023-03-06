package com.webserva.wings.android.menurecommender;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View btn1 = findViewById(R.id.btn1);
        View btn2 = findViewById(R.id.btn2);
        View btn3 = findViewById(R.id.btn3);
        View btn4 = findViewById(R.id.btn4);


        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int selectedButtonNum =0;
        String selectedStr ="";
        if(v.getId()==R.id.btn1){
            selectedButtonNum=1;
        }else if(v.getId()==R.id.btn2){
            selectedButtonNum=2;
        }else if(v.getId()==R.id.btn3){
            selectedButtonNum=3;
        }else if(v.getId()==R.id.btn4){
            selectedButtonNum=4;
        }
        Button btn = (Button)v;
        selectedStr = (String)(btn.getText());

        RecommendManager.manage(selectedButtonNum,selectedStr);

    }
}