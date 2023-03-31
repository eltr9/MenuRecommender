package com.webserva.wings.android.menurecommender.model.DAO;

import static android.content.ContentValues.TAG;

import android.util.Log;

import com.webserva.wings.android.menurecommender.model.DTO.Dish;
import com.webserva.wings.android.menurecommender.model.RecommendManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DishDAOImpl implements DishDAO{
    private static final String CONNECTION_URL = "jdbc:mysql://localhost:3306/menuDB";
    private static final String USER = "root";
    private static final String PASSWORD = "0952";
    @Override
    public List<Dish> getDishesByParameters(RecommendManager rm) {

        List<Dish> dishes =  new ArrayList<>();
        try{
            //データベースに接続する
            Connection connection = DriverManager.getConnection(CONNECTION_URL,USER,PASSWORD);
            //SQLクエリをrmから受け取り、準備する
            String query = rm.getQueryStr().getValue();
            PreparedStatement stmt = connection.prepareStatement(query);
            //クエリを実行して結果を取得する
            ResultSet resultSet = stmt.executeQuery();

            // 結果をDishオブジェクトに変換してリストに追加する
            HashMap<Integer, Dish> dishesMap = new HashMap<>();

            while (resultSet.next()) {
                int dishId = resultSet.getInt("dish_id");
                String ingName = resultSet.getString("ing_name");
                String ingType = resultSet.getString("ing_type");

                if (!dishesMap.containsKey(dishId)) {
                    //dishMapにdishIdが存在しなければ新しくDishデータを作成して各パラメータを格納
                    Dish dish = new Dish();
                    dish.setDish_id(dishId);
                    dish.setName(resultSet.getString("name"));
                    dish.setGenre(resultSet.getString("genre"));
                    dish.setWeight(resultSet.getInt("weight"));
                    dish.setFat(resultSet.getInt("fat"));
                    dish.setSalty(resultSet.getInt("salty"));
                    dish.setSpicy(resultSet.getInt("spicy"));
                    dish.setSweet(resultSet.getInt("sweet"));
                    dish.setDifficulty(resultSet.getInt("difficulty"));
                    dish.getIngredients().add(ingName);
                    dish.getIngTypes().add(ingType);
                    //DishMapに登録
                    dishesMap.put(dishId, dish);
                } else {
                    //dishMapにdishIdが存在する場合は、そのDishのIngredientsにadd
                    Dish existingDish = dishesMap.get(dishId);
                    existingDish.getIngredients().add(ingName);
                    //ingTypesにingTypeが既にある場合を除き、ingTypeをそのDishのingTypesにadd
                    if(!existingDish.getIngTypes().contains(ingType)){
                        existingDish.getIngTypes().add(ingType);
                    }
                }
            }


            // リソースを閉じる
            resultSet.close();
            stmt.close();
            connection.close();
        }catch(SQLException e){
            Log.e(TAG,"SQL exception:" ,e);
            e.printStackTrace();
        }

        return dishes;
    }
}
