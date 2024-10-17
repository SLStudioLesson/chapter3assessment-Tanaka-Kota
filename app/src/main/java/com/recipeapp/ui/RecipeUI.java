package com.recipeapp.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.recipeapp.datahandler.CSVDataHandler;
import com.recipeapp.datahandler.DataHandler;
import com.recipeapp.model.Ingredient;
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
                        displayRecipes();
                        break;
                    case "2":
                        addNewRecipe();
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
            } catch (IOException e) {
                System.out.println("Error reading input from user: " + e.getMessage());
            }
        }
    }
    private void displayRecipes() throws IOException {
        CSVDataHandler csvDataHandler = new CSVDataHandler();
        ArrayList<Recipe> recipes = csvDataHandler.readData();

        if (recipes.size() > 0) {
            System.out.println("Recipes:");
            for(int i = 0 ;i < recipes.size() ; i++){
                System.out.println("-----------------------------------");
                Recipe recipe = recipes.get(i);
                System.out.println("Recipe Name: "+ recipe.getName());
                System.out.print("Main Ingredients: ");
                for (int j = 0 ; j < recipe.getIngredients().size() ; j++){
                    Ingredient ingredient = recipe.getIngredients().get(j);
                    System.out.print(ingredient.getName());
                    if (j == recipe.getIngredients().size()-1){
                        System.out.println();
                    } else {
                        System.out.print(", ");
                    }
                }
            }
        } else {
            System.out.println("No recipes available.");
        }

    }

    // - ユーザーからレシピ名と主な材料を入力させ、DataHandlerを使用してrecipes.csvに新しいレシピを追加します。
    private void addNewRecipe()throws IOException{
        try{
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Adding a new recipe.");
            System.out.print("Enter recipe name: ");
            String recipeName = reader.readLine();
            System.out.println("Enter ingredients (type 'done' when finished): ");
            String ingredient = "";
            // - 材料の入力はdoneと入力するまで入力を受け付けます。
            ArrayList<Ingredient> ingredients = new ArrayList<>();
            while(!ingredient.equals("done")){
                System.out.print("ingredients: ");
                ingredient = reader.readLine();
                Ingredient ingredient2 = new Ingredient(ingredient);
                ingredients.add(ingredient2);
            }


            Recipe recipe = new Recipe(recipeName, ingredients);

            CSVDataHandler csvDataHandler = new CSVDataHandler();
            csvDataHandler.writeData(recipe);
            System.out.println("Recipe added successfully.");

        } catch (IOException e) {//- IOExceptionを受け取った場合はFailed to add new recipe: 例外のメッセージとコンソールに表示してください。
        System.out.println("Failed to add new recipe: " + e.getMessage());
        }
    }
}
