package com.webserva.wings.android.menurecommender.model.DAO;

import com.webserva.wings.android.menurecommender.model.DTO.Dish;

import java.util.List;

public interface OnDishesReceivedListener {
    void onDishesReceived(List<Dish> dishes);

}
