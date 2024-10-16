package com.recipeapp.datahandler;

import java.util.ArrayList;
import com.recipeapp.model.Recipe;

public class JSONDataHandler implements DataHandler{

    public String getMode(){
        String JSON = "JSON";
        return JSON;
    }
    public ArrayList<Recipe> readData(){ //処理の実装は行わないので定義し、nullをreturnしてください。
        return null;
        }

    public void writeDate(Recipe recipe){} //処理の実装は行わないので定義のみ行います。

    public ArrayList<Recipe> searchDate(String keyword){ //処理の実装は行わないので定義し、nullをreturnしてください。
        return null;
        }
}
