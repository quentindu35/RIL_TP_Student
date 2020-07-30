

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import requeteBdd.requeteBddAdministrateur;
import requeteBdd.requeteBddClasse;
import requeteBdd.requeteBddEtudiant;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception, SQLException {
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

            ResultSet resultSet = requeteBddAdministrateur.displayDataAdministrateur(con);
            System.out.println("ResultSet " + resultSet.getString("nom"));
            Label label = new Label(resultSet.getString("nom"));
            root.add(label,0,1);

            //SCRUD ELEVE
            //requeteBdd.requeteBdd.addEleve(con, "test", "test", "test.test@gmail.com", 1);
            //requeteBdd.requeteBdd.deleteEleve(con, 1);
            //requeteBdd.requeteBdd.updateEleve(con, "Coucou", "Coucou", "coucou.cou@..", 3);
            //requeteBddEtudiant.displayEleve(con);

            //CRUD CLASSE
            //requeteBddClasse.displayClasse(con);
            //requeteBddClasse.addClasse(con, "RIL");
            //requeteBddClasse.deleteClasse(con, 1);
            //requeteBddClasse.updateClasse(con, "Test", 2);
            requeteBddClasse.displayEleveClasse(con, 2);

            connexionBdd.closeConnection(con);

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
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
