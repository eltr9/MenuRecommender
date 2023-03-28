package com.webserva.wings.android.menurecommender.model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.webserva.wings.android.menurecommender.model.DAO.DishDAO;
import com.webserva.wings.android.menurecommender.model.DAO.DishDAOImpl;
import com.webserva.wings.android.menurecommender.model.DTO.Dish;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class RecommendManager extends ViewModel /*implements Parcelable */ {
    public MutableLiveData<Question> currentQ;
    private  MutableLiveData<Question> nextQ;
    private MutableLiveData<String> queryStr;
    private MutableLiveData<Integer> qCount;

    private MutableLiveData<ArrayList<Dish>> dishCandidates;

    private MutableLiveData<int[]> params;
    private MutableLiveData<ArrayList<String>> recommendingGenres;
    private MutableLiveData<ArrayList<String>> ingredients;
    private MutableLiveData<ArrayList<String>> ing_type;
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
        this.ing_type = new MutableLiveData<>(new ArrayList<String>());
    }


//    protected RecommendManager(Parcel in) {
//        queryStr = in.readString();
//        qCount = in.readInt();
//        params = in.createIntArray();
//        recommendingGenres = in.createStringArrayList();
//        ingredients = in.createStringArrayList();
//        ing_type = in.createStringArrayList();
//    }
//    public static final Creator<RecommendManager> CREATOR = new Creator<RecommendManager>() {
//        @Override
//        public RecommendManager createFromParcel(Parcel in) {
//            return new RecommendManager(in);
//        }
//
//        @Override
//        public RecommendManager[] newArray(int size) {
//            return new RecommendManager[size];
//        }
//    };

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
        if(genre != null && genre != "") recommendingGenres.getValue().add(genre);

        String ing = null;
        if(keyExist(orderMap,"ing")) ing = (String)orderMap.get("ing");
        if(ing != null && ing != "") ingredients.getValue().add(ing);

        String ingType = null;
        if(keyExist(orderMap,"ingType")) ingType = (String)orderMap.get("ingType");
        if(ingType != null && ingType != "") ing_type.getValue().add(ingType);

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
        params.setValue(tmp);
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

    public MutableLiveData<Question> getCurrentQ() {
        return currentQ;
    }

    public MutableLiveData<Integer> getQCount() {
        return qCount;
    }

    public LiveData<ArrayList<Dish>> getDishCandidates() {
        return dishCandidates;
    }

    public void AddDish(){
        DishDAO dishDAO = new DishDAOImpl();
        ArrayList<Dish> dishes = dishDAO.getDishesByParameters(this);
        dishCandidates.setValue(new ArrayList<>(dishes));
    }

//    @Override
//    public int describeContents() {
//        return 0;
//    }
//
//    @Override
//    public void writeToParcel(@NonNull Parcel parcel, int i) {
//        parcel.writeString(queryStr);
//        parcel.writeInt(qCount);
//        parcel.writeIntArray(params);
//        parcel.writeStringList(recommendingGenres);
//        parcel.writeStringList(ingredients);
//        parcel.writeStringList(ing_type);
//    }
}