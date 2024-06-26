package UI;

import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import Lab5.DatabaseController;
import Backend.GameStat;
import Backend.Player;


public class GameStatList extends ScrollPane {
    VBox root;

    GameStatListItem selectedItem = null;

    public GameStatList(Player activePlayer){
        super();
        root = new VBox();
        root.setPrefHeight(150);
        root.setPrefWidth(520);
        setContent(root);

        for (GameStat gs: DatabaseController.stats) {
            System.out.print("new game stat list item");
            if(gs.getPlayerID() == activePlayer.getID()) {
                GameStatListItem gsli = new GameStatListItem(this, gs);
                root.getChildren().add(gsli);
            }
        }

    }


    public void Deselect(){
        if(selectedItem != null) {
            selectedItem.Deselect();
            selectedItem = null;
        }
    }

    public void Select(GameStatListItem selectedItem) {
        Deselect();
        this.selectedItem = selectedItem;
        selectedItem.Select();
    }
}
