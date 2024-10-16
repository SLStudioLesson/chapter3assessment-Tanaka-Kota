package com.recipeapp.datahandler;

import java.util.ArrayList;
import com.recipeapp.model.Recipe;

public class CSVDataHandler implements DataHandler {
        private String filePath;

    // フィールドfilePathにapp/src/main/resources/recipes.csvを代入する
    public CSVDataHandler(){
        this.filePath = "app/src/main/resources/recipes.csv";
    }
    // フィールドfilePathに引数を代入する
    public CSVDataHandler (String filePath){
        this.filePath = filePath;
    }
    public String getMode(){ //文字列CSVを返してください。
        String CSV = "";
        return CSV;
        }

    public ArrayList<Recipe> readData(){ //以降の設問で処理を実装するため定義し、nullをreturnしてください。
        return null;
    }

    public void writeDate(Recipe recipe){} //以降の設問で処理を実装するため定義のみ行います。

    public ArrayList<Recipe> searchDate(String keyword){ //以降の設問で処理を実装するため定義し、nullをreturnしてください。
        return null;
    }
}