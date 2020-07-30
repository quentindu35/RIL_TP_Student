package requeteBdd;

import java.sql.*;

public class requeteBddClasse {

    public static void displayClasse(Connection con) throws SQLException, ClassNotFoundException{
        String query = "SELECT * FROM classe";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);


        while (rs.next())
        {
            int id = rs.getInt("id_classe");
            String nom = rs.getString("nom");

            // print the result
            System.out.format("%s, %s\n", id, nom);
        }


    }

    public static void addClasse(Connection con, String nom) throws SQLException, ClassNotFoundException{

        // the mysql insert statement
        String query = " insert into classe (nom)"
                + " values (?)";

        // create the mysql insert preparedstatement
        PreparedStatement preparedStmt = con.prepareStatement(query);
        preparedStmt.setString (1, nom);

        // execute the preparedstatement
        preparedStmt.execute();

        System.out.println(nom +" "+ nom + " a été ajouté ");




    }

    public static void deleteClasse(Connection con, int id_classe) throws SQLException, ClassNotFoundException{
        String query = "Delete FROM classe where id_classe = ? ";

        try (PreparedStatement preparedStmt = con.prepareStatement(query)) {
            preparedStmt.setInt(1, id_classe);
            preparedStmt.execute();

            System.out.println("id : " + id_classe + " supprimé !");

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public static void updateClasse(Connection con, String nom, int id) throws SQLException, ClassNotFoundException{
        String query = "Update classe set nom = ? where id_classe = ?";

        PreparedStatement preparedStmt = con.prepareStatement(query);

        preparedStmt.setString(1, nom);
        preparedStmt.setInt(2, id);
        preparedStmt.executeUpdate();

        System.out.println("id : " + id + " mis à jour !");


    }

    public static void displayEleveClasse(Connection con, int id_classe) throws SQLException, ClassNotFoundException{
        String query = "SELECT distinct(classe.nom), etudiant.* FROM classe inner join etudiant on classe.id_classe = etudiant.id_classe where classe.id_classe = " + id_classe;
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);

        con.prepareStatement(query);

        while (rs.next())
        {
            String nom = rs.getString("etudiant.nom");
            String nomClasse = rs.getString("classe.nom");

            // print the result
            System.out.format("Pour la classe %s", nomClasse);
            System.out.format("%s, %s\n", id_classe, nom);

        }



    }

}
