package com.webserva.wings.android.menurecommender;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View btn1 = findViewById(R.id.btn1);
        View btn2 = findViewById(R.id.btn2);
        View btn3 = findViewById(R.id.btn3);
        View btn4 = findViewById(R.id.btn4);

        ImageView ivCharacter = findViewById(R.id.ivCharacter);
        TextView tvQ = findViewById(R.id.tvQuestion);

        tvQ.setText("何食べたい？"); // TODO: 初期質問を指定






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

        //manager へ答えを渡す
        RecommendManager.manage(selectedButtonNum,selectedStr);
        // TODO:managerから次の質問を取得

        //質問を表示
        showNextQ();


    }

    public void showNextQ(){

    }
}