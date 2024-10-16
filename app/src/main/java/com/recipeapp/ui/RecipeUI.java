package com.recipeapp.ui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import com.recipeapp.datahandler.CSVDataHandler;
import com.recipeapp.datahandler.DataHandler;
import com.recipeapp.model.Recipe;


public class RecipeUI {
    private BufferedReader reader;
    private DataHandler dataHandler;

    public RecipeUI(DataHandler dataHandler) {
        reader = new BufferedReader(new InputStreamReader(System.in));
        this.dataHandler = dataHandler;
    }
    
    public void displayMenu() {

        System.out.println("Current mode: " + dataHandler.getMode());

        while (true) {
            try {
                System.out.println();
                System.out.println("Main Menu:");
                System.out.println("1: Display Recipes");
                System.out.println("2: Add New Recipe");
                System.out.println("3: Search Recipe");
                System.out.println("4: Exit Application");
                System.out.print("Please choose an option: ");

                String choice = reader.readLine();

                switch (choice) {
                    case "1":
                        break;
                    case "2":
                        break;
                    case "3":
                        break;
                    case "4":
                        System.out.println("Exiting the application.");
                        return;
                    default:
                        System.out.println("Invalid choice. Please select again.");
                        break;
                }
            } catch (IOException e) { //IOExceptionを受け取った場合はError reading file: 例外のメッセージとコンソールに表示します
                System.out.println("Error reading input from user: " + e.getMessage());
            }
        }
    }
    private void displayRecipes(){
        CSVDataHandler csvDataHandler = new CSVDataHandler();
        ArrayList<Recipe> recipes = csvDataHandler.readData();
        File filePath = new File(String filePath);

        try {
            if (filePath.exists()) {
                BufferedReader reader = new BufferedReader(new FileReader(filePath));
                for(int i = 0 ;i < recipes.size() ; i++){
                System.out.println("Recipe Name: "+ recipes.get(0));
                System.out.print("Main Ingredients: ");
                    for (int j = 1 ; j < recipes.size() ; j++){
                        System.out.print(recipes.get(j));
                        if (j == recipes.size()-1){
                            System.out.println();
                        } else {
                            System.out.print(", ");
                        }
                    }
                }
            } else {
                System.out.println("No recipes available.");
            }
        } catch (IOException e) {
        System.out.println("Error reading file: " + e.getMessage());
        }
    }
    private void addNewRecipe()throws IOException{
        try{
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter recipe name: ");
            String recipeName = reader.readLine();
            System.out.print("Enter ingredients (type 'done' when finished): ");
            String ingredient = reader.readLine();
            while(ingredient.equals("done")){
                System.out.print("ingredients: ");
                ingredient =reader.readLine();
            }

            CSVDataHandler csvDataHandler = new CSVDataHandler();
            csvDataHandler.writeDate(recipe);
            System.out.println("Recipe added successfully.");

        } catch (IOException e) {
        System.out.println("Failed to add new recipe: " + e.getMessage());
        }
    }
}
