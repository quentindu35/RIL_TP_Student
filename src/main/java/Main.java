

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception, SQLException {
        primaryStage.setTitle("Connection");
        primaryStage.setWidth(150);
        primaryStage.setHeight(150);

        GridPane root = new GridPane();

        Label lbnMail = new Label("Identifiant : ");
        root.add(lbnMail, 0, 1);

        TextField txtFieldMail = new TextField();
        root.add(txtFieldMail,1,1);

        Label lbnPwd = new Label("Mot de Passe : ");
        root.add(lbnPwd, 0, 2);

        TextField txtFieldPwd = new TextField();
        root.add(txtFieldPwd,1,2);

        Button btnSubmit = new Button("Connection");
        TextField txt = new TextField();
        btnSubmit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage newWindow = new Stage();
                newWindow.setTitle("Second Stage");

                Label secondLabel = new Label(txtFieldMail.getText());

                GridPane secondaryLayout = new GridPane();
                secondaryLayout.add(secondLabel,0,0);

                // New window (Stage)

                newWindow.setScene(new Scene(secondaryLayout, 230, 100));

                newWindow.show();
            }
        });

        root.add(btnSubmit,1,3);

        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();


        /*
        Connection con = null;
        GridPane root = new GridPane();
        primaryStage.setTitle("Hello World");

        try{
            Properties prop = connexionBdd.loadPropertiesFiles();
            String url = (String) prop.get("db.url");
            String userName = (String) prop.get("db.userName");
            String password = (String) prop.get("db.password");
            String driver = (String) prop.get("db.driver");

            System.out.println("Driver : " + driver);
            Class.forName(driver);

            con = DriverManager.getConnection(url, userName, password);

            if(con !=null){
                System.out.println("Connection créée");

            }else {
                System.out.println("Pas de connection");
            }

            ResultSet resultSet = requeteBdd.displayData(con);
            System.out.println("ResultSet " + resultSet.getString("nom"));
            Label label = new Label(resultSet.getString("nom"));
            root.add(label,0,1);


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try{
                if(con != null){
                    con.close();
                }
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }



        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();*/
    }


    public static void main(String[] args) {
        launch(args);
    }
}
