package com.webserva.wings.android.menurecommender.model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.webserva.wings.android.menurecommender.model.DAO.DishDAO;
import com.webserva.wings.android.menurecommender.model.DAO.DishDAOImpl;
import com.webserva.wings.android.menurecommender.model.DAO.GetDishesAsyncTask;
import com.webserva.wings.android.menurecommender.model.DAO.OnDishesReceivedListener;
import com.webserva.wings.android.menurecommender.model.DTO.Dish;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class RecommendManager extends ViewModel implements OnDishesReceivedListener {
    public MutableLiveData<Question> currentQ;
    private  MutableLiveData<Question> nextQ;
    private MutableLiveData<String> queryStr;
    private MutableLiveData<Integer> qCount;

    private MutableLiveData<List<Dish>> dishCandidates;


    private MutableLiveData<List<String>> recommendingGenres;
    private MutableLiveData<List<String>> ingredients;
    private MutableLiveData<List<String>> ing_types;
    private MutableLiveData<int[]> params;
    static final int WEIGHT = 0;
    static final int FAT = 1;
    static final int SALTY = 2;
    static final int SPICY = 3;
    static final int SWEET = 4;
    static final int DIFFICULTY = 5;

    private static final int FIRST_Q = 1;
    private static final int CUISINE_Q = 2;
    private static final int GENRE_Q = 3;
    private static final int WEIGHT_Q = 4;
    private static final int ING_TYPE_Q = 5;
    private static final int TASTE_Q = 6;
    private static final int COOK_OR_GO_Q = 7;
    private static final int DIFFICULTY_Q = 8;
    private static final int Q_END = 0;



    public RecommendManager() {
        this.currentQ = new MutableLiveData<>(GenerateQuestion.firstQ());
        this.qCount = new MutableLiveData<>(0);
        this.queryStr = new MutableLiveData<>("SELECT * FROM Dishes WHERE");
        this.params = new MutableLiveData<>(new int[]{3, 3, 3, 3, 3, 3});
        this.recommendingGenres = new MutableLiveData<>(new ArrayList<String>());
        this.ingredients = new MutableLiveData<>(new ArrayList<String>());
        this.ing_types = new MutableLiveData<>(new ArrayList<String>());
        this.dishCandidates = new MutableLiveData<>(new ArrayList<Dish>());
    }

    private int getIntFromMap(HashMap<String, Object> hashMap, String key) {
        Object value;
        if(keyExist(hashMap,key)) {
            value = hashMap.get(key);
            if (value instanceof Integer) {
                return (int) value;
            } else {
                return 0; // ヌルポチェックのために、デフォルト値として0を返す
            }
        }else{
            return 0;
        }
    }

    private boolean keyExist(HashMap<String, Object> hashMap, String key){
        String value;
        if (hashMap.containsKey(key)) {
            return true;
        } else {
            return false;
        }

    }

    public void inputOrders(HashMap<String,Object> orderMap){
        String genre = null;
        if(keyExist(orderMap,"genre")) genre = (String) orderMap.get("genre");
        if(genre != null && genre != "") this.recommendingGenres.getValue().add(genre);

        String ing = null;
        if(keyExist(orderMap,"ing")) ing = (String)orderMap.get("ing");
        if(ing != null && ing != "") this.ingredients.getValue().add(ing);

        String ingType = null;
        if(keyExist(orderMap,"ingType")) ingType = (String)orderMap.get("ingType");
        if(ingType != null && ingType != "") this.ing_types.getValue().add(ingType);

        int[] p = new int[6];
        int[] tmp = new int[6];
        p[WEIGHT] += getIntFromMap(orderMap, "weight");
        p[FAT] += getIntFromMap(orderMap, "fat");
        p[SALTY] += getIntFromMap(orderMap, "salty");
        p[SPICY] += getIntFromMap(orderMap, "spicy");
        p[SWEET] += getIntFromMap(orderMap, "sweet");
        p[DIFFICULTY] += getIntFromMap(orderMap, "difficulty");

        for(int i= WEIGHT; i <= DIFFICULTY; i++){
            tmp[i] = Objects.requireNonNull(params.getValue())[i] + p[i];
            if(tmp[i] < 0) tmp[i] = 0;
            else if (tmp[i] > 5) tmp[i] = 5;
        }
        this.params.setValue(tmp);
    }

    public void setNextQ(HashMap<String,Object> orderMap){
        int Q_ID = getIntFromMap(orderMap,"nextQ");

        switch (Q_ID){
            case CUISINE_Q:
                currentQ.setValue(GenerateQuestion.cuisineQ());
                break;
            case GENRE_Q:
                currentQ.setValue(GenerateQuestion.genreQ());
                break;
            case WEIGHT_Q:
                currentQ.setValue(GenerateQuestion.weightQ());
                break;
            case ING_TYPE_Q:
                currentQ.setValue(GenerateQuestion.ingTypeQ());
                break;
            case TASTE_Q:
                currentQ.setValue(GenerateQuestion.tasteQ());
                break;
            case COOK_OR_GO_Q:
                currentQ.setValue(GenerateQuestion.cookOrGoQ());
                break;
            case DIFFICULTY_Q:
                currentQ.setValue(GenerateQuestion.difficultyQ());
                break;
            case Q_END:
                currentQ =null;
                break;
        }
    }
    public void AddDishes(){

        DishDAO dishDAO = new DishDAOImpl();
        GetDishesAsyncTask task = new GetDishesAsyncTask(dishDAO,this);
        task.execute(this);
    }
    @Override
    public void onDishesReceived(List<Dish> dishes) {
        this.dishCandidates.setValue(dishes);
    }

    public void CreateQueryStr(){
        //genre
        StringBuilder genresStr = new StringBuilder();
        if(!Objects.requireNonNull(this.recommendingGenres.getValue()).isEmpty()){
            List<String> list = this.recommendingGenres.getValue();
            genresStr.append("(D.genre = '");
            for(int i = 0 ; i < list.size(); i++) {
                if (i < list.size() -1 ) {
                    genresStr.append(list.get(i)).append("' OR D.genre = '");
                } else {
                    genresStr.append(list.get(i)).append("')");
                }
            }
        }

        //ing_types
        StringBuilder ingTypesStr = new StringBuilder();
        if(!Objects.requireNonNull(this.ing_types.getValue()).isEmpty()){
            List<String> list = this.ing_types.getValue();
            ingTypesStr.append("(I.ing_type = '");
            for(int i = 0 ; i < list.size(); i++) {
                if (i < list.size() -1 ) {
                    ingTypesStr.append(list.get(i)).append("' OR I.ing_type = '");
                } else {
                    ingTypesStr.append(list.get(i)).append("')");
                }
            }
        }else{
            ingTypesStr.append("");
        }


        // weight
        int n = this.params.getValue()[WEIGHT];
        int minWeight = Math.max(n - 2, 0);
        int maxWeight = Math.min(n + 2, 5);
        String weightStr = "(D.weight >= " + minWeight + " AND D.weight <= " + maxWeight + ")";

        // fat
        n = this.params.getValue()[FAT];
        int minFat = Math.max(n - 2, 0);
        int maxFat = Math.min(n + 2, 5);
        String fatStr = "(D.fat >= " + minFat + " AND D.fat <= " + maxFat + ")";

        // salty
        n = this.params.getValue()[SALTY];
        int minSalty = Math.max(n - 2, 0);
        int maxSalty = Math.min(n + 2, 5);
        String saltyStr = "(D.salty >= " + minSalty + " AND D.salty <= " + maxSalty + ")";

        // spicy
        n = this.params.getValue()[SPICY];
        int minSpicy = Math.max(n - 2, 0);
        int maxSpicy = Math.min(n + 2, 5);
        String spicyStr = "(D.spicy >= " + minSpicy + " AND D.spicy <= " + maxSpicy + ")";

        // sweet
        n = this.params.getValue()[SWEET];
        int minSweet = Math.max(n - 2, 0);
        int maxSweet = Math.min(n + 2, 5);
        String sweetStr = "(D.sweet >= " + minSweet + " AND D.sweet <= " + maxSweet + ")";

        // difficulty
        n = this.params.getValue()[DIFFICULTY];
        int minDifficulty = Math.max(n - 2, 0);
        int maxDifficulty = Math.min(n + 2, 5);
        String difficultyStr = "(D.difficulty >= " + minDifficulty + " AND D.difficulty <= " + maxDifficulty + ")";





        String str = "SELECT D.dish_id," +
                " D.dish_name," +
                " D.genre," +
                " D.weight, D.fat, D.salty, D.spicy, D.sweet, D.difficulty," +
                " I.ing_name," +
                " I.ing_type" +
                " FROM Dishes D" +
                " LEFT JOIN dish_ing D_I ON dishes.dish_id = dish_ing.dish_id" +
                " LEFT JOIN ingredients I ON dish_ing.ing_id = ingredients.ing_id" +
                " WHERE " +
                "AND " + genresStr +
                "AND " + ingTypesStr +
                "AND " + weightStr +
                "AND " + fatStr +
                "AND " + saltyStr +
                "AND " + spicyStr +
                "AND " + sweetStr +
                "AND " + difficultyStr ;

        this.queryStr.setValue(str);
    }

    public MutableLiveData<Question> getCurrentQ() {
        return currentQ;
    }

    public MutableLiveData<Integer> getQCount() {
        return qCount;
    }

    public MutableLiveData<List<Dish>> getDishCandidates() {
        return dishCandidates;
    }

    public MutableLiveData<String> getQueryStr() {
        return queryStr;
    }


}