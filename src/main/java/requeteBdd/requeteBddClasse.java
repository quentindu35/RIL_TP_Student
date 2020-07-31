package requeteBdd;

import Vues.pageModificationClasse;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


import java.sql.*;

import static Vues.pageAccueil.listView2;

public class requeteBddClasse {

    public static void displayClasse(Connection con, ListView<String> listView) throws SQLException, ClassNotFoundException{

        String query = "SELECT * FROM classe";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);

        String id = "";
        String nom = "";
        while (rs.next())
        {
            id = rs.getString("id_classe");
            nom = rs.getString("nom");
            listView.getItems().add(nom);
            // print the result
            System.out.format("%s, %s\n", id, nom);
        }
        System.out.println("-------------------------------------------");
        System.out.println(id + " " + nom);

    }

    public static void displayClasseCombo(Connection con, ComboBox<String> comboBox) throws SQLException, ClassNotFoundException{

        String query = "SELECT * FROM classe";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);

        String id = "";
        String nom = "";
        while (rs.next())
        {
            id = rs.getString("id_classe");
            nom = rs.getString("nom");
            comboBox.getItems().addAll(nom);
            // print the result
            System.out.format("%s, %s\n", id, nom);
        }
        System.out.println("-------------------------------------------");
        System.out.println(id + " " + nom);
        pageModificationClasse.display(id,nom);

    }

    public static void ClasseByName (Connection con, String nom) throws SQLException, ClassNotFoundException{
        String query = "SELECT * FROM classe WHERE nom = "+ nom;
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);

        String id = "";
        String nom2 = "";
        while (rs.next())
        {
            id = rs.getString("id_classe");
            nom2 = rs.getString("nom");
            // print the result
            System.out.format("%s, %s\n", id, nom);
        }

        pageModificationClasse.display(id,nom2);


    }

    public static void addClasse(Connection con, TextField nom) throws SQLException, ClassNotFoundException{

        // the mysql insert statement
        String query = " insert into classe (nom)"
                + " values (?)";

        // create the mysql insert preparedstatement
        PreparedStatement preparedStmt = con.prepareStatement(query);
        preparedStmt.setString (1, nom.getText());

        // execute the preparedstatement
        preparedStmt.execute();

        System.out.println(nom +" "+ nom + " a été ajouté ");




    }

    public static void deleteClasse(Connection con, String nom) throws SQLException, ClassNotFoundException{
        String query = "Delete FROM classe where nom = "+ nom;

        try (Statement preparedStmt = con.createStatement()) {
            preparedStmt.execute(query);
            System.out.println(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public static void updateClasse(Connection con, String nom, String id) throws SQLException, ClassNotFoundException{
        String query = "UPDATE classe SET nom = " + nom + " WHERE id_classe = ?";

        PreparedStatement preparedStmt = con.prepareStatement(query);

        preparedStmt.setString(1, id);
        preparedStmt.executeUpdate();

        System.out.println("id : " + id + " mis à jour !");


    }

    public static void displayEleveClasse(Connection con, String classe) throws SQLException, ClassNotFoundException{
        String query = "SELECT distinct(classe.nom), etudiant.* FROM classe inner join etudiant on classe.id_classe = etudiant.id_classe where classe.nom = " + classe;
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);

        con.prepareStatement(query);

        while (rs.next())
        {
            String nom = rs.getString("etudiant.nom ");
            //String nomClasse = rs.getString("classe.nom");

            // print the result
            //System.out.format("Pour la classe %s", nomClasse);
            System.out.format("%s\n",nom);
            listView2.getItems().add(nom);
        }



    }

}
