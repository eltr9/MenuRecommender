package com.webserva.wings.android.menurecommender.model;

import android.content.Intent;
import android.os.Bundle;

import java.util.HashMap;

public class Question{
    private final int id;
    private int opLength;
    private String mainText;
    private String btnStr1;
    private String btnStr2;
    private String btnStr3;
    private String btnStr4;
    private String btnStr5;

    private String btnStr6;

    private HashMap<String,Object> orderMap1;
    private HashMap<String,Object> orderMap2;
    private HashMap<String,Object> orderMap3;
    private HashMap<String,Object> orderMap4;
    private HashMap<String,Object> orderMap5;
    private HashMap<String,Object> orderMap6;

    //選択肢数に応じたコンストラクタ(2-6個)
    public Question(int id, String mainText, String btnStr1, String btnStr2) {
        this.id = id;
        this.mainText = mainText;
        this.btnStr1 = btnStr1;
        this.btnStr2 = btnStr2;
        this.opLength = 2;
    }

    public Question(int id, String mainText, String btnStr1, String btnStr2, String btnStr3) {
        this(id, mainText, btnStr1, btnStr2);
        this.btnStr3 = btnStr3;
        this.opLength = 3;
    }

    public Question(int id, String mainText,
                    String btnStr1, String btnStr2, String btnStr3, String btnStr4) {
        this(id, mainText, btnStr1, btnStr2, btnStr3);
        this.btnStr4 = btnStr4;
        this.opLength = 4;
    }

    public Question(int id, String mainText,
                    String btnStr1, String btnStr2, String btnStr3, String btnStr4, String btnStr5) {
        this(id, mainText, btnStr1, btnStr2, btnStr3, btnStr4);
        this.btnStr5 = btnStr5;
        this.opLength = 5;
    }

    public Question(int id, String mainText,
                    String btnStr1, String btnStr2, String btnStr3, String btnStr4, String btnStr5, String btnStr6) {
        this(id, mainText, btnStr1, btnStr2, btnStr3, btnStr4, btnStr5);
        this.btnStr6 = btnStr6;
        this.opLength = 6;
    }

    public String getMainText() {
        return mainText;
    }

    public int getOpLength() {
        return opLength;
    }

    public String getBtnStr1() {
        return btnStr1;
    }

    public String getBtnStr2() {
        return btnStr2;
    }

    public String getBtnStr3() {
        return btnStr3;
    }

    public String getBtnStr4() {
        return btnStr4;
    }

    public String getBtnStr5() {
        return btnStr5;
    }

    public String getBtnStr6() {
        return btnStr6;
    }

    public HashMap<String, Object> getOrderMap1() {
        return orderMap1;
    }

    public HashMap<String, Object> getOrderMap2() {
        return orderMap2;
    }

    public HashMap<String, Object> getOrderMap3() {
        return orderMap3;
    }

    public HashMap<String, Object> getOrderMap4() {
        return orderMap4;
    }

    public HashMap<String, Object> getOrderMap5() {
        return orderMap5;
    }

    public HashMap<String, Object> getOrderMap6() {
        return orderMap6;
    }

    public void setOrderMap1(HashMap<String, Object> orderMap1) {
        this.orderMap1 = orderMap1;
    }

    public void setOrderMap2(HashMap<String, Object> orderMap2) {
        this.orderMap2 = orderMap2;
    }

    public void setOrderMap3(HashMap<String, Object> orderMap3) {
        this.orderMap3 = orderMap3;
    }

    public void setOrderMap4(HashMap<String, Object> orderMap4) {
        this.orderMap4 = orderMap4;
    }

    public void setOrderMap5(HashMap<String, Object> orderMap5) {
        this.orderMap5 = orderMap5;
    }

    public void setOrderMap6(HashMap<String, Object> orderMap6) {
        this.orderMap6 = orderMap6;
    }
}