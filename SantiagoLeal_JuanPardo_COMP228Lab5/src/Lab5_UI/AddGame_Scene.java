package Lab5_UI;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import Lab5.DatabaseController;
import Lab5.Game;

public class AddGame_Scene extends Scene{

    TextField gTitleTextField;


    public AddGame_Scene(Stage primaryStage){

        super(new VBox(), 300, 60);
        VBox root = (VBox)getRoot();
        primaryStage.setTitle("Add Game");

        HBox gTitleRow = new HBox();
        Label gTitleLabel = new Label("Title :");
        gTitleLabel.setPrefWidth(100);
        gTitleLabel.setAlignment(Pos.CENTER_RIGHT);
        gTitleTextField = new TextField();
        gTitleRow.getChildren().add(gTitleLabel);
        gTitleRow.getChildren().add(gTitleTextField);

        
        Button cancelButton = new Button("Cancel");
        cancelButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                primaryStage.setScene(new UserSelect_Scene(primaryStage));
            }
        });
        

        Button createButton = new Button("Create");

        createButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Game newGame = new Game(gTitleTextField.getText());
                DatabaseController.addNewGame(newGame);

                primaryStage.setScene(new UserSelect_Scene(primaryStage));
            }
        });

        HBox buttonRow = new HBox();
        buttonRow.getChildren().add(cancelButton);
        buttonRow.getChildren().add(createButton);
        root.getChildren().add(gTitleRow);


        root.getChildren().add(buttonRow);

}}