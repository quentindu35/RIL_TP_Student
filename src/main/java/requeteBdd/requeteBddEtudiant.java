package requeteBdd;

import javafx.scene.control.TextField;

import java.sql.*;

public class requeteBddEtudiant {

    public static void addEleve(Connection con, TextField nom, TextField prenom, TextField mail, TextField mdp, String id_classe) throws SQLException, ClassNotFoundException{

        // the mysql insert statement
        String query = " insert into etudiant (nom, prenom, mail, mdp, id_classe)"
                + " values (?, ?, ?, ?, ?)";

        // create the mysql insert preparedstatement
        PreparedStatement preparedStmt = con.prepareStatement(query);
        preparedStmt.setString (1, nom.getText());
        preparedStmt.setString (2, prenom.getText());
        preparedStmt.setString   (3, mail.getText());
        preparedStmt.setString   (4, mdp.getText());
        preparedStmt.setString  (5, id_classe);

        // execute the preparedstatement
        preparedStmt.execute();

        System.out.println(nom +" "+ prenom + " a été ajouté ");




    }

    public static void deleteEleve(Connection con, int id_eleve) throws SQLException, ClassNotFoundException{
        String query = "Delete FROM etudiant where id_etudiant = ? ";

        try (PreparedStatement preparedStmt = con.prepareStatement(query)) {
            preparedStmt.setInt(1, id_eleve);
            preparedStmt.execute();

            System.out.println("id : " + id_eleve + " supprimé !");

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public static void updateEleve(Connection con, String nom, String prenom, String mail, int id) throws SQLException, ClassNotFoundException{
        String query = "Update etudiant set nom = ?, prenom = ?, mail = ? where id_etudiant = ?";

        PreparedStatement preparedStmt = con.prepareStatement(query);

        preparedStmt.setString(1, nom);
        preparedStmt.setString(2, prenom);
        preparedStmt.setString(3, mail);
        preparedStmt.setInt(4, id);
        preparedStmt.executeUpdate();

        System.out.println("id : " + id + " mis à jour !");


    }

    public static void displayEleve(Connection con) throws SQLException, ClassNotFoundException{
        String query = "SELECT * FROM etudiant";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);


        while (rs.next())
        {
            int id = rs.getInt("id_etudiant");
            String nom = rs.getString("nom");
            String prenom = rs.getString("prenom");
            String mail = rs.getString("mail");
            int classe = rs.getInt("id_classe");

            // print the result
            System.out.format("%s, %s, %s, %s\n", id, nom, prenom, mail, classe);
        }


    }
}
