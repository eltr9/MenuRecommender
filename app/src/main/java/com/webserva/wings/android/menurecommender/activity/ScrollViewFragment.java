package com.webserva.wings.android.menurecommender.activity;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.webserva.wings.android.menurecommender.R;
import com.webserva.wings.android.menurecommender.model.DTO.Dish;
import com.webserva.wings.android.menurecommender.model.RecommendManager;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ScrollViewFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ScrollViewFragment extends Fragment {

    private RecommendManager rm;
    public List<Dish> dishCandidates;



    public ScrollViewFragment() {
        // Required empty public constructor
    }

    @NonNull
    public static ScrollViewFragment newInstance(RecommendManager rm) {
    ScrollViewFragment fragment = new ScrollViewFragment();
    fragment.rm =rm;
    return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_scroll_view, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //LiveDataのオブザーバー(監視)を作成
        final Observer<List<Dish>> candidatesObserver = dishes -> {
            dishCandidates = dishes;
            //todo スクロール画面に表示する
        };
        //QObserverを設定
        rm.getDishCandidates().observe(getViewLifecycleOwner(),candidatesObserver);

    }

    public void updateCandidateDisplay(ArrayList<Dish> candidates){

    }
}