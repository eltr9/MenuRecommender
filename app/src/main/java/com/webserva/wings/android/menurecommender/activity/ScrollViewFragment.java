package com.webserva.wings.android.menurecommender.activity;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.webserva.wings.android.menurecommender.R;
import com.webserva.wings.android.menurecommender.model.DTO.Dish;
import com.webserva.wings.android.menurecommender.model.RecommendManager;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ScrollViewFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ScrollViewFragment extends Fragment {

    private RecommendManager rm;



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

      //  rm.getDishCandidates().observe(getViewLifecycleOwner(),candidates ->updateCandidateDisplay(candidates));
    }

    public void updateCandidateDisplay(ArrayList<Dish> candidates){

    }
}