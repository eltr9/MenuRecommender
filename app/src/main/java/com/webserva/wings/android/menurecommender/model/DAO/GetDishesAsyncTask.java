package com.webserva.wings.android.menurecommender.model.DAO;

import android.os.AsyncTask;

import com.webserva.wings.android.menurecommender.model.DTO.Dish;
import com.webserva.wings.android.menurecommender.model.RecommendManager;

import java.util.List;

public class GetDishesAsyncTask extends AsyncTask<RecommendManager,Void, List<Dish>> {
    private DishDAO dishes;
    private OnDishesReceivedListener listener;


    public GetDishesAsyncTask(DishDAO dishes, OnDishesReceivedListener listener) {
        this.dishes = dishes;
        this.listener = listener;
    }


    @Override
    protected List<Dish> doInBackground(RecommendManager... recommendManagers) {
        return dishes.getDishesByParameters(recommendManagers[0]);
    }
    @Override
    protected void onPostExecute(List<Dish> dishes) {
        // 結果を使ってUIを更新する処理などをここに書く
        listener.onDishesReceived(dishes);
    }
}
