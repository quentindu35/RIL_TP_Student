package Vues;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.sql.ResultSet;
import java.sql.SQLException;

public class pageEtudiant {
    public static void display(ResultSet ResultSet) throws SQLException {
        // New scene
        Stage secondaryStage = new Stage();
        // New Grid
        GridPane root = new GridPane();
        // New Scene
        Scene scene = new Scene(root, 800, 600, Color.LIGHTGRAY);
        // Label Presentation
        String prenom = ResultSet.getString("prenom");
        Label lblPresentation = new Label("Bonjour "+ prenom);
        root.add(lblPresentation,0,0);
        // Label Title
        Label presentation = new Label("Présentation de l'utilisateur connecter");
        presentation.setStyle("-fx-font-weight: bold");
        root.add(presentation,0,1);
        // Label Last Name
        String nom = ResultSet.getString("nom");
        Label lblNom = new Label("Nom : " + nom);
        root.add(lblNom,0,2);
        // Label First Name
        Label lblPrenom = new Label("Prénom : " + prenom);
        root.add(lblPrenom,0,3);
        // Label Name
        String mail = ResultSet.getString("mail");
        Label lblMail = new Label("Mail : " + mail);
        root.add(lblMail,0,4);

        secondaryStage.setScene(scene);
        secondaryStage.setTitle("Bienvenue");
        secondaryStage.show();

    }
}
