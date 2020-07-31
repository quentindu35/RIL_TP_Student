package requeteBdd;

import java.sql.*;

public class requeteBddAdministrateur {
    public static ResultSet displayDataAdministrateur(Connection con) throws SQLException, ClassNotFoundException{
        String query = "SELECT * FROM administrateur";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);


        while (rs.next())
        {
            int id = rs.getInt("id_administrateur");
            String nom = rs.getString("nom");

            // print the result
            System.out.format("%s, %s\n", id, nom);
        }
        return rs;
    }

    public static void displayConnectionAdmin(Connection con, String mail, String mdp) throws SQLException, ClassNotFoundException{
        String query = "SELECT * FROM administrateur WHERE mail = ? AND mdp = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1,mail);
        ps.setString(2,mdp);
        ps.executeUpdate();

    }

}
