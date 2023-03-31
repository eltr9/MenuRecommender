package com.webserva.wings.android.menurecommender.activity;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.webserva.wings.android.menurecommender.R;
import com.webserva.wings.android.menurecommender.model.GenerateQuestion;
import com.webserva.wings.android.menurecommender.model.Question;
import com.webserva.wings.android.menurecommender.model.RecommendManager;

import java.util.HashMap;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ButtonViewFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ButtonViewFragment extends Fragment {
    private RecommendManager rm;
    public Question currentQ;
    public LiveData<Integer> qCount;

    public ButtonViewFragment() {
        // Required empty public constructor
    }

    @NonNull
    public static ButtonViewFragment newInstance(RecommendManager rm) {
        ButtonViewFragment fragment = new ButtonViewFragment();
        fragment.rm =rm;
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button btn1 = (Button)view.findViewById(R.id.btn1);
        Button btn2 = (Button)view.findViewById(R.id.btn2);
        Button btn3 = (Button)view.findViewById(R.id.btn3);
        Button btn4 = (Button)view.findViewById(R.id.btn4);
        Button btn5 = (Button)view.findViewById(R.id.btn5);
        Button btn6 = (Button)view.findViewById(R.id.btn6);

        btn1.setOnClickListener(v -> {
            HashMap<String,Object> map = currentQ.getOrderMap1();
            rm.inputOrders(map);
            rm.setNextQ(map);
            rm.CreateQueryStr();
            rm.AddDishes();

        });
        btn2.setOnClickListener(v -> {
            HashMap<String,Object>  map = currentQ.getOrderMap2();
            rm.inputOrders(map);
            rm.setNextQ(map);
            rm.CreateQueryStr();
            rm.AddDishes();
        });
        btn3.setOnClickListener(v -> {
            if(currentQ.getOpLength() > 2){
                HashMap<String,Object>  map = currentQ.getOrderMap3();
                rm.inputOrders(map);
                rm.setNextQ(map);
                rm.CreateQueryStr();
                rm.AddDishes();
            }
        });
        btn4.setOnClickListener(v -> {
            if(3 < currentQ.getOpLength()){
                HashMap<String,Object>  map = currentQ.getOrderMap3();
                rm.inputOrders(map);
                rm.CreateQueryStr();
                rm.AddDishes();
                rm.setNextQ(map);
            }
        });
        btn5.setOnClickListener(v -> {
            if(currentQ.getOpLength() > 4){
                HashMap<String,Object>  map = currentQ.getOrderMap3();
                rm.inputOrders(map);
                rm.setNextQ(map);
                rm.CreateQueryStr();
                rm.AddDishes();
            }
        });
        btn6.setOnClickListener(v -> {
            if(currentQ.getOpLength() > 5){
                HashMap<String,Object>  map = currentQ.getOrderMap3();
                rm.inputOrders(map);
                rm.setNextQ(map);
                rm.CreateQueryStr();
                rm.AddDishes();
            }
        });


        //LiveDataのオブザーバー(監視)を作成
        final Observer<Question> QObserver = Q -> {
            currentQ = Q;
            qCount = rm.getQCount();
            setButton(btn1,btn2,btn3,btn4,btn5,btn6);
        };
        //QObserverを設定
        rm.getCurrentQ().observe(getViewLifecycleOwner(),QObserver);



    }

    private void updateButtonView(Question question) {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_button_view, container, false);
    }

    public void setButton(Button btn1,Button btn2,Button btn3,
                          Button btn4,Button btn5,Button btn6){
        if(currentQ != null) {

            int ln = currentQ.getOpLength();
            if (ln == 2) {
                btn1.setText(currentQ.getBtnStr1());
                btn2.setText(currentQ.getBtnStr2());

                btn1.setVisibility(View.VISIBLE);
                btn2.setVisibility(View.VISIBLE);
                btn3.setVisibility(View.INVISIBLE);
                btn4.setVisibility(View.INVISIBLE);
                btn5.setVisibility(View.INVISIBLE);
                btn6.setVisibility(View.INVISIBLE);
            } else if (ln == 3) {
                btn1.setText(currentQ.getBtnStr1());
                btn2.setText(currentQ.getBtnStr2());
                btn3.setText(currentQ.getBtnStr3());

                btn1.setVisibility(View.VISIBLE);
                btn2.setVisibility(View.VISIBLE);
                btn3.setVisibility(View.VISIBLE);
                btn4.setVisibility(View.INVISIBLE);
                btn5.setVisibility(View.INVISIBLE);
                btn6.setVisibility(View.INVISIBLE);
            } else if (ln == 4) {
                btn1.setText(currentQ.getBtnStr1());
                btn2.setText(currentQ.getBtnStr2());
                btn3.setText(currentQ.getBtnStr3());
                btn4.setText(currentQ.getBtnStr4());

                btn1.setVisibility(View.VISIBLE);
                btn2.setVisibility(View.VISIBLE);
                btn3.setVisibility(View.VISIBLE);
                btn4.setVisibility(View.VISIBLE);
                btn5.setVisibility(View.INVISIBLE);
                btn6.setVisibility(View.INVISIBLE);
            } else if (ln == 5) {
                btn1.setText(currentQ.getBtnStr1());
                btn2.setText(currentQ.getBtnStr2());
                btn3.setText(currentQ.getBtnStr3());
                btn4.setText(currentQ.getBtnStr4());
                btn5.setText(currentQ.getBtnStr5());

                btn1.setVisibility(View.VISIBLE);
                btn2.setVisibility(View.VISIBLE);
                btn3.setVisibility(View.VISIBLE);
                btn4.setVisibility(View.VISIBLE);
                btn5.setVisibility(View.VISIBLE);
                btn6.setVisibility(View.INVISIBLE);
            } else if (ln == 6) {
                btn1.setText(currentQ.getBtnStr1());
                btn2.setText(currentQ.getBtnStr2());
                btn3.setText(currentQ.getBtnStr3());
                btn4.setText(currentQ.getBtnStr4());
                btn5.setText(currentQ.getBtnStr5());
                btn6.setText(currentQ.getBtnStr6());

                btn1.setVisibility(View.VISIBLE);
                btn2.setVisibility(View.VISIBLE);
                btn3.setVisibility(View.VISIBLE);
                btn4.setVisibility(View.VISIBLE);
                btn5.setVisibility(View.VISIBLE);
                btn6.setVisibility(View.VISIBLE);
            }
        }else{
            btn1.setVisibility(View.INVISIBLE);
            btn2.setVisibility(View.INVISIBLE);
            btn3.setVisibility(View.INVISIBLE);
            btn4.setVisibility(View.INVISIBLE);
            btn5.setVisibility(View.INVISIBLE);
            btn6.setVisibility(View.INVISIBLE);
        }

    }

//    public void reStart(){
//        FragmentTransaction ft = getParentFragmentManager().beginTransaction();
//        ft.detach( ButtonViewFragment.this)
//                .attach(ButtonViewFragment.this)
//                .commit();
//    }
}