package Vues;

import javafx.collections.ObservableList;
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
import requeteBdd.connexionBdd;
import requeteBdd.requeteBddClasse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import static Vues.pageClasse.pageAdd;
import static requeteBdd.requeteBddClasse.deleteClasse;
import static requeteBdd.requeteBddClasse.displayEleveClasse;

public class pageAccueil {
    public static ListView<String> listView = new ListView<>();
    public static ListView<String> listView2 = new ListView<>();

    public static void display() throws SQLException, IOException, ClassNotFoundException {
        // New scene
        Stage secondaryStage = new Stage();
        Group root = new Group();
        Scene scene = new Scene(root, 800, 600, Color.LIGHTGRAY);

        Button bt3 = new Button("Créer");
        bt3.setStyle("-fx-background-color: #04b0ff; -fx-text-fill: #ffffff;");
        Button bt = new Button("Modifer");
        bt.setStyle("-fx-background-color: #ff8e04; -fx-text-fill: white;");
        Button bt1 = new Button("Afficher ");
        bt1.setStyle("-fx-background-color: #3c9a1a; -fx-text-fill: white;");
        Button bt2 = new Button("Supprimer");
        bt2.setStyle("-fx-background-color: #ee3737; -fx-text-fill: white;");

        VBox vBox = new VBox(bt3, bt,bt1,bt2);
        vBox.setSpacing(10);
        vBox.setLayoutX(300);

        bt1.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                System.out.println("DAO afficher tous les eleves d'une classe");
            }
        });



        Connection con = connexionBdd.connectionDB();


        requeteBddClasse.displayClasse(con, listView);


        bt2.setOnAction(e -> {
            try {
                buttonClicked();
                listView.getSelectionModel().clearSelection();
                listView.getItems().clear();
                requeteBddClasse.displayClasse(con, listView);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            } catch (ClassNotFoundException classNotFoundException) {
                classNotFoundException.printStackTrace();
            }

        });
        listView2.setVisible(false);
        bt1.setOnAction(e -> {
            try {
                listView2.getSelectionModel().clearSelection();
                listView2.getItems().clear();

                buttonClickedDisplay();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException classNotFoundException) {
                classNotFoundException.printStackTrace();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });

        bt3.setOnAction(e -> {
            try {
                pageAdd();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            } catch (ClassNotFoundException classNotFoundException) {
                classNotFoundException.printStackTrace();
            }
        });


        HBox hbox = new HBox(listView);
        HBox hbox2 = new HBox(listView2);
        hbox2.setLayoutX(400);

        secondaryStage.setScene(scene);
        secondaryStage.show();

        root.getChildren().add(hbox);
        root.getChildren().add(hbox2);
        root.getChildren().add(vBox);
        secondaryStage.setScene(scene);
        secondaryStage.setResizable(false);
        secondaryStage.setTitle("Bienvenue");
        secondaryStage.show();

    }

    private static void buttonClicked() throws SQLException, IOException, ClassNotFoundException {
        String message = "";

        ObservableList<String> classes;
        Connection con = connexionBdd.connectionDB();
        classes = listView.getSelectionModel().getSelectedItems();

        for(String c: classes){
            message += c;

            System.out.println(c);
        }

        String mes = "\""+message+"\"";
        System.out.println(mes);
        deleteClasse(con, mes);

        System.out.println(message);

    }

    private static void buttonClickedDisplay() throws SQLException, ClassNotFoundException, IOException {

        listView2.setVisible(true);
        String message = "";
        ObservableList<String> classes;
        Connection con = connexionBdd.connectionDB();
        classes = listView.getSelectionModel().getSelectedItems();

        for(String c: classes){
            message += c;
        }

        String mes = "\""+message+"\"";
        System.out.println(mes);
        displayEleveClasse(con,mes);


    }


}
