package Vues;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.sql.ResultSet;
import java.sql.SQLException;

public class pageModificationClasse {
    public static void display() throws SQLException {
        // New scene
        Stage secondaryStage = new Stage();
        // New Grid
        GridPane root = new GridPane();
        // New Scene
        Scene scene = new Scene(root, 800, 600, Color.LIGHTGRAY);

        Label tot = new Label("olfgo");
        root.add(tot,0,0);

        secondaryStage.setScene(scene);
        secondaryStage.setTitle("Bienvenue");
        secondaryStage.show();

    }
}
