package UI;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import Backend.DatabaseController;
import Backend.Player;


//Main Window Scene for selecting user.

public class UserSelect_Scene extends Scene {

    VBox root;
    Stage primaryStage;

    //Constructor
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public UserSelect_Scene(Stage stage){
        super( new VBox(), 500, 250);
        stage.setTitle("Select User");
        primaryStage = stage;

        //Build UI
        root  = (VBox)getRoot();
        root.setAlignment(Pos.CENTER);
        HBox Line1 = new HBox();
        Line1.setAlignment(Pos.CENTER);
        Label choiceBXLabel = new Label("Select User account: ");
        ChoiceBox userCB = new ChoiceBox();

        userCB.getItems().setAll(DatabaseController.players);

        Line1.getChildren().add(choiceBXLabel);
        Line1.getChildren().add(userCB);

        HBox Line2 = new HBox();
        Line2.setAlignment(Pos.CENTER   );

        //Create new User button changes scene to user creation scene
        Button createUserButton = new Button("Create New Account");
        createUserButton.setOnAction(event -> primaryStage.setScene(new CreateUser_Scene(primaryStage)));
        
        Button createNewGameButton = new Button("Add New Game");
        createNewGameButton.setOnAction(event -> primaryStage.setScene(new AddGame_Scene(primaryStage)));

        //select user button that changes window scene to used edit scene with selection box selected value
        Button selectUserButton = new Button("Select User");
        selectUserButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(userCB.getValue() != null){
                    primaryStage.setScene(new EditUser_Scene( (Player)userCB.getValue(), primaryStage ) );
                }
            }
        });


        Line2.getChildren().add(createUserButton);
        Line2.getChildren().add(selectUserButton);
        Line2.getChildren().add(createNewGameButton);

        root.getChildren().add(Line1);
        root.getChildren().add(Line2);


    }

}
