package com.webserva.wings.android.menurecommender.model.DAO;

import com.webserva.wings.android.menurecommender.model.DTO.Dish;
import com.webserva.wings.android.menurecommender.model.RecommendManager;

import java.util.List;

public interface DishDAO {
    List<Dish> getDishesByParameters(RecommendManager rm);
}
