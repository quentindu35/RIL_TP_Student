package Vues;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import requeteBdd.connexionBdd;
import requeteBdd.requeteBddClasse;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import static Vues.pageAccueil.listView;
import static requeteBdd.requeteBddClasse.displayEleveClasse;

public class pageClasse {

    public static void pageAdd() throws SQLException, IOException, ClassNotFoundException {
        final Stage[] addStage = {new Stage()};
        Group root = new Group();
        Scene scene = new Scene(root, 800, 600, Color.LIGHTGRAY);

        TextField nomField = new TextField();
        Button btAdd = new Button("Créer");
        btAdd.setStyle("-fx-background-color: #04b0ff; -fx-text-fill: white;");
        btAdd.setLayoutX(200);
        Button btCancel = new Button("Annuler");
        btCancel.setStyle("-fx-background-color: #ff8e04; -fx-text-fill: white;");
        btCancel.setLayoutX(300);

        root.getChildren().add(btAdd);
        root.getChildren().add(btCancel);
        root.getChildren().add(nomField);
        Connection con = connexionBdd.connectionDB();
        btAdd.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                try {
                    requeteBddClasse.addClasse(con, nomField);
                    connexionBdd.infoBox("La création a bien été prise en compte",null,"Ok");
                    Node node = (Node)e.getSource();
                    listView.getSelectionModel().clearSelection();
                    listView.getItems().clear();
                    requeteBddClasse.displayClasse(con, listView);
                    addStage[0] = (Stage) node.getScene().getWindow();
                    addStage[0].close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                }
            }
        });
        btCancel.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                try {
                    pageAccueil.display();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                } catch (ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                }
            }
        });
        addStage[0].setScene(scene);
        addStage[0].setTitle("Ajouter une classe");
        addStage[0].show();
    }



}
