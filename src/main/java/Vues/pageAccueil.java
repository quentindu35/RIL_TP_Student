package Vues;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class pageAccueil {
    public static void display(){
        // New scene
        Stage secondaryStage = new Stage();
        Group root = new Group();
        Scene scene = new Scene(root, 800, 600, Color.LIGHTGRAY);

        Button bt = new Button("Modifer");
        bt.setStyle("-fx-background-color: #ff8e04; -fx-text-fill: white;");
        Button bt1 = new Button("Afficher ");
        bt1.setStyle("-fx-background-color: #3c9a1a; -fx-text-fill: white;");
        Button bt2 = new Button("Supprimer");
        bt2.setStyle("-fx-background-color: #ee3737; -fx-text-fill: white;");

        VBox vBox = new VBox(bt,bt1,bt2);
        vBox.setSpacing(10);
        vBox.setLayoutX(300);

        bt1.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                System.out.println("DAO afficher tous les eleves d'une classe");
            }
        });

        Button bt3 = new Button("Modifer");
        bt3.setStyle("-fx-background-color: #ff8e04; -fx-text-fill: white;");
        Button bt4 = new Button("Afficher ");
        bt4.setStyle("-fx-background-color: #3c9a1a; -fx-text-fill: white;");
        Button bt5 = new Button("Supprimer");
        bt5.setStyle("-fx-background-color: #ee3737; -fx-text-fill: white;");

        VBox vBox2 = new VBox(bt3,bt4,bt5);
        vBox2.setSpacing(10);
        vBox2.setLayoutX(700);

        ListView<String> listView = new ListView<>();

        listView.getItems().add("Classe 1");
        listView.getItems().add("Classe  2");
        listView.getItems().add("Classe  3");

        ListView<String> listView2 = new ListView<>();

        listView2.getItems().add("Eleve 1");
        listView2.getItems().add("Eleve  2");
        listView2.getItems().add("Eleve  3");

        HBox hbox = new HBox(listView);
        HBox hbox2 = new HBox(listView2);
        hbox2.setLayoutX(400);

        secondaryStage.setScene(scene);
        secondaryStage.show();

        root.getChildren().add(hbox);
        root.getChildren().add(hbox2);
        root.getChildren().add(vBox);
        root.getChildren().add(vBox2);
        secondaryStage.setScene(scene);
        secondaryStage.setTitle("Bienvenue");
        secondaryStage.show();

    }
}
