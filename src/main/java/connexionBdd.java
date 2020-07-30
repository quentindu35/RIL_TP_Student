

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class connexionBdd {
    public static Properties loadPropertiesFiles() throws Exception{
        Properties prop = new Properties();
        FileInputStream input = new FileInputStream("C:/Users/Meunier/IdeaProjects/RIL_TP_Student/src/main/resources/config.properties");
        prop.load(input);
        return prop;
    }

    public static void closeConnection(Connection con) throws SQLException {
        con.close();
    }


}
