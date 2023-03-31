package com.webserva.wings.android.menurecommender.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.os.Parcelable;
import android.widget.ImageView;
import android.widget.TextView;

import com.webserva.wings.android.menurecommender.R;
import com.webserva.wings.android.menurecommender.model.Question;
import com.webserva.wings.android.menurecommender.model.RecommendManager;

import java.io.Serializable;
import java.util.List;

public class MainActivity extends AppCompatActivity{
    RecommendManager rm;
    Question currentQ;
    List<String> dishCandidates;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rm = new ViewModelProvider(this).get(RecommendManager.class);
        currentQ = rm.getCurrentQ().getValue();

        //LiveDataのオブザーバーを追加
         //currentQ
        final Observer<Question> QObserver = Q -> {
            currentQ = Q;
            ImageView ivCharacter = findViewById(R.id.ivCharacter);
            TextView tvQ = findViewById(R.id.tvQuestion);
            tvQ.setText(currentQ.getMainText());
        };
        rm.getCurrentQ().observe(this,QObserver);


        //fragmentにviewModelを渡す
        ScrollViewFragment scrollViewFragment = ScrollViewFragment.newInstance(rm);
        ButtonViewFragment buttonViewFragment = ButtonViewFragment.newInstance(rm);

        //fragmentを表示
        FragmentTransaction btTransaction
                =getSupportFragmentManager()
                .beginTransaction();
        btTransaction.add(R.id.fragment_container_scrollView,scrollViewFragment)
                .add(R.id.fragment_container_buttonView,buttonViewFragment).commit();





    }

//    public void onButtonClick(Question currentQ){
//        ImageView ivCharacter = findViewById(R.id.ivCharacter);
//        TextView tvQ = findViewById(R.id.tvQuestion);
//        tvQ.setText(currentQ.getMainText());
//    }


}