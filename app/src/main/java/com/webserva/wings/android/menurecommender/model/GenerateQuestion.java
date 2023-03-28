package com.webserva.wings.android.menurecommender.model;

import android.os.Bundle;

import androidx.annotation.NonNull;

import com.webserva.wings.android.menurecommender.activity.MainActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class GenerateQuestion {

    private static final int FIRST_Q = 1;
    private static final int CUISINE_Q = 2;
    private static final int GENRE_Q = 3;
    private static final int WEIGHT_Q = 4;
    private static final int ING_TYPE_Q = 5;
    private static final int TASTE_Q = 6;
    private static final int COOK_OR_GO_Q = 7;
    private static final int DIFFICULTY_Q = 8;
    private static final int Q_END = 0;

    private static HashMap<String,Object> defaultHashMap(){
        HashMap<String,Object> map = new HashMap<>();
        map.put("genre","");
        map.put("weight",0);
        map.put("fat",0);
        map.put("salty",0);
        map.put("spicy",0);
        map.put("sweet",0);
        map.put("cookOrGo","");
        map.put("ingType","");
        map.put("difficulty",0);
        map.put("nextQ",0);
        return map;
    }
    public static Question firstQ(){
        Question Q = new Question(1,"ヤッホー","気分で選ぶ","材料で選ぶ");

        HashMap<String,Object> map1 = defaultHashMap();
        map1.put("genre","");
        map1.put("weight",0);
        map1.put("fat",0);
        map1.put("salty",0);
        map1.put("spicy",0);
        map1.put("sweet",0);
        map1.put("difficulty",0);
        map1.put("nextQ",CUISINE_Q);
        Q.setOrderMap1(map1);

        HashMap<String,Object> map2 = defaultHashMap();
        map2.put("genre","");
        map2.put("weight",0);
        map2.put("fat",0);
        map2.put("salty",0);
        map2.put("spicy",0);
        map2.put("sweet",0);
        map2.put("difficulty",0);
        map2.put("nextQ",ING_TYPE_Q);
        Q.setOrderMap2(map2);


        return Q;
    }

    public static Question cuisineQ(){
        Question Q = new Question(2, "いつ食べる？",
                "朝ごはん", "昼ごはん", "晩ごはん", "夜食", "おやつ");

        HashMap<String,Object> map1 = defaultHashMap();
        map1.put("genre","");
        map1.put("weight",-1);
        map1.put("fat",-1);
        map1.put("salty",0);
        map1.put("spicy",-1);
        map1.put("sweet",0);
        map1.put("difficulty",-2);
        map1.put("nextQ",GENRE_Q);
        Q.setOrderMap1(map1);

        HashMap<String,Object> map2 = defaultHashMap();
        map2.put("genre","");
        map2.put("weight",0);
        map2.put("fat",0);
        map2.put("salty",0);
        map2.put("spicy",0);
        map2.put("sweet",0);
        map2.put("difficulty",0);
        map2.put("nextQ",GENRE_Q);
        Q.setOrderMap2(map2);

        HashMap<String,Object> map3 = defaultHashMap();
        map3.put("genre","");
        map3.put("weight",0);
        map3.put("fat",0);
        map3.put("salty",0);
        map3.put("spicy",0);
        map3.put("sweet",0);
        map3.put("difficulty",0);
        map3.put("nextQ",GENRE_Q);
        Q.setOrderMap3(map3);

        HashMap<String,Object> map4 = defaultHashMap();
        map4.put("genre","");
        map4.put("weight",0);
        map4.put("fat",0);
        map4.put("salty",0);
        map4.put("spicy",0);
        map4.put("sweet",0);
        map4.put("difficulty",0);
        map4.put("nextQ",GENRE_Q);
        Q.setOrderMap4(map4);

        HashMap<String,Object> map5 = defaultHashMap();
        map5.put("genre","");
        map5.put("weight",0);
        map5.put("fat",0);
        map5.put("salty",0);
        map5.put("spicy",0);
        map5.put("sweet",0);
        map5.put("difficulty",0);
        map5.put("nextQ",GENRE_Q);
        Q.setOrderMap5(map5);

        return Q;
    }
    public static Question genreQ(){
        Question Q = new Question(3, "どれがいい？",
                "和食", "洋食", "中華", "イタリアン", "エスニック","決まってない");
        HashMap<String,Object> map1 = defaultHashMap();
        map1.put("genre","和食");
        map1.put("nextQ",ING_TYPE_Q);
        Q.setOrderMap1(map1);

        HashMap<String,Object> map2 = defaultHashMap();
        map2.put("genre","洋食");
        map2.put("nextQ",ING_TYPE_Q);
        Q.setOrderMap2(map2);

        HashMap<String,Object> map3 = defaultHashMap();
        map3.put("genre","中華");
        map3.put("nextQ",ING_TYPE_Q);
        Q.setOrderMap3(map3);

        HashMap<String,Object> map4 = defaultHashMap();
        map4.put("genre","イタリアン");
        map4.put("nextQ",ING_TYPE_Q);
        Q.setOrderMap4(map4);

        HashMap<String,Object> map5 = defaultHashMap();
        map5.put("genre","エスニック");
        map5.put("nextQ",ING_TYPE_Q);
        Q.setOrderMap5(map5);

        HashMap<String,Object> map6 = defaultHashMap();
        map6.put("nextQ",ING_TYPE_Q);
        Q.setOrderMap6(map6);

        return Q;
    }

    public static Question weightQ(){
        Question Q = new Question(4,"お腹減ってる？","食欲ない","普通に減ってる","結構減ってる","めっちゃ減ってる");
        HashMap<String,Object> map1 = defaultHashMap();
        map1.put("weight",-2);
        map1.put("nextQ",ING_TYPE_Q);
        Q.setOrderMap1(map1);

        HashMap<String,Object> map2 = defaultHashMap();
        map2.put("mainIng",-1);
        map2.put("nextQ", ING_TYPE_Q);
        Q.setOrderMap2(map2);

        HashMap<String,Object> map3 = defaultHashMap();
        map3.put("mainIng",0);
        map3.put("nextQ",ING_TYPE_Q);
        Q.setOrderMap3(map3);

        HashMap<String,Object> map4 = defaultHashMap();
        map4.put("mainIng",1);
        map4.put("nextQ",ING_TYPE_Q);
        Q.setOrderMap4(map4);
        return Q;
    }


    public  static Question ingTypeQ(){
        Question Q = new Question(5,"ふむふむ。メインの食材は決まってる？",
                "肉","魚,海鮮","野菜","卵","ご飯/麺","決まってない");
        HashMap<String,Object> map1 = defaultHashMap();
        map1.put("ingType","meat");
        map1.put("nextQ",TASTE_Q);
        Q.setOrderMap1(map1);

        HashMap<String,Object> map2 = defaultHashMap();
        map2.put("ingType","fish");
        map2.put("nextQ",TASTE_Q);
        Q.setOrderMap2(map2);

        HashMap<String,Object> map3 = defaultHashMap();
        map3.put("ingType","vege");
        map3.put("nextQ",TASTE_Q);
        Q.setOrderMap3(map3);

        HashMap<String,Object> map4 = defaultHashMap();
        map4.put("ingType","egg");
        map4.put("nextQ",TASTE_Q);
        Q.setOrderMap4(map4);

        HashMap<String,Object> map5 = defaultHashMap();
        map5.put("ingType","carbo");
        map5.put("nextQ",TASTE_Q);
        Q.setOrderMap5(map5);

        HashMap<String,Object> map6 = defaultHashMap();
        map6.put("nextQ",TASTE_Q);
        Q.setOrderMap6(map6);

        return Q;
    }

    public static Question tasteQ(){
        Question Q = new Question(6,"なるほど。味の好みはある？",
                "辛い","甘い","塩っぱい","脂っこい");
        HashMap<String,Object> map1 = defaultHashMap();
        map1.put("spicy",2);
        map1.put("sweet",-1);
        map1.put("nextQ",COOK_OR_GO_Q);
        Q.setOrderMap1(map1);

        HashMap<String,Object> map2 = defaultHashMap();
        map2.put("salty",-2);
        map2.put("spicy",-2);
        map2.put("sweet",2);
        map2.put("nextQ",COOK_OR_GO_Q);
        Q.setOrderMap2(map2);

        HashMap<String,Object> map3 = defaultHashMap();
        map3.put("salty",1);
        map3.put("sweet",-1);
        map3.put("nextQ",COOK_OR_GO_Q);
        Q.setOrderMap3(map3);

        HashMap<String,Object> map4 = defaultHashMap();
        map4.put("fat",2);
        map4.put("nextQ",COOK_OR_GO_Q);
        Q.setOrderMap4(map4);

        return Q;
    }

    public static Question cookOrGoQ(){
        Question Q = new Question(7,"自分で作る？外食にする？","作る","外食にする");
        HashMap<String,Object> map1 = defaultHashMap();
        map1.put("cookOrGo","cook");
        map1.put("nextQ",DIFFICULTY_Q);
        Q.setOrderMap1(map1);

        HashMap<String,Object> map2 = defaultHashMap();
        map2.put("cookOrGo","go");
        map2.put("nextQ",Q_END);
        Q.setOrderMap2(map2);

        return Q;
    }

    public static Question difficultyQ(){
        Question Q = new Question(8,"作る元気ある？",
                "かなりある","まあまあある","あんまりない","やっぱ外食にする");
        HashMap<String,Object> map1 = defaultHashMap();
        map1.put("cookOrGo","cook");
        map1.put("difficulty",+2);
        map1.put("nextQ",Q_END);
        Q.setOrderMap1(map1);

        HashMap<String,Object> map2 = defaultHashMap();
        map2.put("cookOrGo","cook");
        map2.put("difficulty",0);
        map2.put("nextQ",Q_END);
        Q.setOrderMap2(map2);

        HashMap<String,Object> map3 = defaultHashMap();
        map3.put("cookOrGo","cook");
        map3.put("difficulty",-1);
        map3.put("nextQ",Q_END);
        Q.setOrderMap3(map3);

        HashMap<String,Object> map4 = defaultHashMap();
        map4.put("cookOrGo","go");
        map4.put("nextQ",Q_END);
        Q.setOrderMap4(map4);

        return Q;
    }

}


