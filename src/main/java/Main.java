


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import requeteBdd.connexionBdd;

import java.io.IOException;
import java.sql.*;


public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception, SQLException {

        //Creating Styling label email
        Text emailText = new Text("Email :");
        emailText.setFill(Color.BLACK);
        emailText.setStyle("-fx-font: 17 arial;");

        //Creating Styling label password
        Text mdpText = new Text("Password :");
        mdpText.setFill(Color.BLACK);
        mdpText.setStyle("-fx-font: 17 arial;");

        //Creating TextField / PasswordField
        TextField emailField = new TextField();
        PasswordField mdpField = new PasswordField();

        //Creating Styling Buttons ok/annule
        Button okBtn = new Button("   OK   ");
        okBtn.setLayoutX(250);
        okBtn.setLayoutY(150);
        Button annulBtn = new Button("ANNULE");
        annulBtn.setLayoutX(315);
        annulBtn.setLayoutY(150);

        //Creating a Grid Pane
        GridPane gridPane = new GridPane();

        //Setting size for the pane
        gridPane.setMinSize(400, 200);

        //Setting the padding
        gridPane.setPadding(new Insets(10, 10, 10, 10));

        //Setting the vertical and horizontal gaps between the columns
        gridPane.setVgap(5);
        gridPane.setHgap(5);

        //Setting the Grid alignment
        gridPane.setAlignment(Pos.CENTER);

        //Arranging all the nodes in the grid
        gridPane.add(emailText, 0, 0);
        gridPane.add(emailField, 1, 0);
        gridPane.add(mdpText, 0, 1);
        gridPane.add(mdpField, 1, 1);

        // Styling Nodes/buttons
        okBtn.setStyle("-fx-background-color: #528b3d; -fx-text-fill: white;");
        annulBtn.setStyle("-fx-background-color: #bd4747; -fx-text-fill: white;");
        emailField.setStyle("-fx-font: normal bold 20px 'serif' ");
        mdpField.setStyle("-fx-font: normal bold 20px 'serif' ");
        gridPane.setStyle("-fx-background-color: LIGHTGRAY;");

        // Event button for login
        okBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                try {
                    connexionBdd.loginAction(e,emailField,mdpField);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                } catch (ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                }
            }
        });
        //Creating root / scene
        Group root = new Group();
        Scene scene = new Scene(root, 400, 200, Color.LIGHTGRAY);

        primaryStage.setTitle("Authentification");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);

        root.getChildren().add(gridPane);
        root.getChildren().add(okBtn);
        root.getChildren().add(annulBtn);

        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
