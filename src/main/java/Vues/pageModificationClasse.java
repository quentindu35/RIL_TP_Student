package Vues;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import requeteBdd.connexionBdd;
import requeteBdd.requeteBddClasse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import static Vues.pageAccueil.listView;
import static requeteBdd.requeteBddClasse.ClasseByName;
import static requeteBdd.requeteBddClasse.updateClasse;

public class pageModificationClasse {
    public static void display(String Id, String nomClasse) throws SQLException {

        // New scene
        final Stage[] thirdlyStage = {new Stage()};
        // New Grid
        GridPane root = new GridPane();
        // New Scene
        Scene scene = new Scene(root, 800, 600, Color.LIGHTGRAY);

        Label presentation = new Label("Classe : ");
        root.add(presentation,0,0);

        Label lblId = new Label("Id : ");
        root.add(lblId,0,1);


        Label lblSetId = new Label(Id);
        root.add(lblSetId,1,1);

        Label lblName = new Label("Nom : ");
        root.add(lblName,0,2);

        TextField nomClasseField = new TextField();
        nomClasseField.setText(nomClasse);
        root.add(nomClasseField,1,2);

        Button bt = new Button("Enregistrer");
        bt.setStyle("-fx-background-color: green; -fx-text-fill: white;");
        bt.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                try {
                    String nomClasse = "";
                    String idClasse = "";
                    Connection con = connexionBdd.connectionDB();
                    nomClasse = nomClasseField.getText();
                    idClasse = lblSetId.getText();


                    String mes = "\""+nomClasse+"\"";
                    System.out.println(mes);
                    // deleteClasse(con, mes);
                    updateClasse(con,mes,idClasse);

                    connexionBdd.infoBox("La modification a bien été prise en compte",null,"Ok");
                    Node n = (Node)e.getSource();
                    listView.getSelectionModel().clearSelection();
                    listView.getItems().clear();
                    requeteBddClasse.displayClasse(con, listView);
                    thirdlyStage[0] = (Stage) n.getScene().getWindow();
                    thirdlyStage[0].close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                } catch (ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                }
            }
        });
        root.add(bt,1,3);

        thirdlyStage[0].setScene(scene);
        thirdlyStage[0].setTitle("Bienvenue");
        thirdlyStage[0].show();
    }
}
