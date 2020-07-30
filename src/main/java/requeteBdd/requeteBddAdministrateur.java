package requeteBdd;

import java.sql.*;

public class requeteBddAdministrateur {
    public static ResultSet displayDataAdministrateur(Connection con) throws SQLException, ClassNotFoundException{
        Statement statement = con.createStatement();

        //Display all

        ResultSet result = statement.executeQuery("Select * from administrateur");
        if (result.next() == false) { System.out.println("La table est vide "); }
       /* System.out.println("result "+ result.next());
        while (result.next()){*/

        System.out.println("nom : " + result.getString("prenom"));
        System.out.println("-----------------------");
        /*}*/

        return result;

    }


}
