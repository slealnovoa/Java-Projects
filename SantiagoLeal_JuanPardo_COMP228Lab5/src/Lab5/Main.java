package Lab5;

import javafx.application.Application;
import javafx.stage.Stage;
import Lab5_UI.UserSelect_Scene;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new UserSelect_Scene(primaryStage));
        primaryStage.show();
    }


    public static void main(String[] args) {

        DatabaseController.testFetch();


        launch(args);
    }
}