package com.recipeapp.datahandler;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.recipeapp.model.Ingredient;
import com.recipeapp.model.Recipe;
import com.recipeapp.ui.RecipeUI;

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
        String CSV = "CSV";
        return CSV;
        }

    public ArrayList<Recipe> readData(){ //以降の設問で処理を実装するため定義し、nullをreturnしてください。
        ArrayList<Recipe> readData = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            String line;
            while ((line = reader.readLine()) != null) {
                String[] line2 = line.split(",");
                ArrayList<Ingredient> ingredients = new ArrayList<>();
                Ingredient ingredient = new Ingredient();
                for (int i = 1 ; i < line.length(); i++ ){
                    ingredient.setName(line2[i]);
                    ingredients.add(ingredient);
                    
                    Recipe recipe = new Recipe();
                    recipe.setName(line2[0]);
                    recipe.setIngredients(ingredients);
                    readData.add(recipe);
                }
            }
        } catch (IOException e) { // IOExceptionが発生したときはError reading file: 例外のメッセージとコンソールに表示します。
            System.out.println("Error reading file: " + e.getMessage());
        }
        return readData;
    }

    public void writeDate(Recipe recipe){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath,true))){
            writer.newLine();;
            writer.write(recipe + "," + recipe);

            writer.close();

        } catch (IOException e) {//IOExceptionが発生したときはError reading file: 例外のメッセージとコンソールに表示します。
            System.out.println("Error reading file: " + e.getMessage());

        }
    } //以降の設問で処理を実装するため定義のみ行います。

    public ArrayList<Recipe> searchDate(String keyword){ //以降の設問で処理を実装するため定義し、nullをreturnしてください。
        return null;
    }
}