import com.recipeapp.datahandler.CSVDataHandler;
import com.recipeapp.datahandler.DataHandler;
import com.recipeapp.datahandler.JSONDataHandler;
import com.recipeapp.ui.RecipeUI;
import java.io.*;

public class App {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Choose the file format:");
            System.out.println("1. CSV");
            System.out.println("2. JSON");
            System.out.print("Select (1/2): ");
            String choice = reader.readLine();
            
            // ユーザーの選択に応じて、CSVDataHandlerまたはJSONDataHandlerのインスタンスを生成する
            if(choice.equals("1")){
                //「1」を選択した場合、CSVDataHandlerインスタンスを生成する
                // 引数が0個のコンストラクタを実行するものとする
                CSVDataHandler csvDataHandler = new CSVDataHandler();
                RecipeUI recipe1 = new RecipeUI(csvDataHandler);
                recipe1.displayMenu();
            } else if(choice.equals("2")) {
                // 「2」を選択した場合、JSONDataHandlerインスタンスを生成する
                JSONDataHandler jsonDataHandler = new JSONDataHandler();
                RecipeUI recipe2 = new RecipeUI(jsonDataHandler);
                recipe2.displayMenu();
            } else { //不正な入力（「1」「2」以外）が与えられた場合、CSVDataHandlerインスタンスを生成する
                CSVDataHandler csvDataHandler = new CSVDataHandler();
                RecipeUI recipe1 = new RecipeUI(csvDataHandler);
                recipe1.displayMenu();
            }


        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}