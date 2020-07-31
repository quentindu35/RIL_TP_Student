package requeteBdd;

import Vues.pageAccueil;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class connexionBdd {

    static Connection con;
    public static Connection connectionDB() throws SQLException, ClassNotFoundException, IOException {
        Properties prop = new Properties();
        FileInputStream input = new FileInputStream("C:/Users/Meunier/IdeaProjects/RIL_TP_Student/src/main/resources/config.properties");
        prop.load(input);
        String dname = (String) prop.get ("db.driver");
        String url = (String) prop.get ("db.url");
        String user = (String) prop.get ("db.userName");
        String passwd = (String) prop.get ("db.password");
        Class.forName(dname);

        con = DriverManager.getConnection(url, user, passwd);

        System.out.println("Connexion réussie !");
        return con;
    }

    // Login DAO
    public static void loginAction(ActionEvent event, TextField mail, TextField mdp) throws SQLException, IOException, ClassNotFoundException {

        // Connection to DB
        Connection con = connexionBdd.connectionDB();

        PreparedStatement preparedStatement;
        ResultSet resultSet;
        Stage dialogStage ;

        // Get values's inputs (TextFlied) email/password
        String email = mail.getText();
        String password = mdp.getText();

        String sql = "SELECT * FROM administrateur Where mail = ? and mdp = ?";

        try{
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();

            if(!resultSet.next()){
                infoBox("L'email et/ou l'identifiant sont incorrects", null, "Echec");

            }else{
                infoBox("Vous êtes connectés !",null,"Connexion réussie" );
                Node node = (Node)event.getSource();
                dialogStage = (Stage) node.getScene().getWindow();
                dialogStage.close();

                // Page Accueil
                pageAccueil.display();
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }


    // Dialog Box for User
    public static void infoBox(String infoMessage, String headerText, String title){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText(infoMessage);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.showAndWait();
    }



}
