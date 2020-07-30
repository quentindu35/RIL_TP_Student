

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class connexionBdd {
    public static Properties loadPropertiesFiles() throws Exception{
        Properties prop = new Properties();
        FileInputStream input = new FileInputStream("D:/CESI Le Mans/23 - Module 23 Java avancer/tp_student/src/main/resources/config.properties");
        prop.load(input);
        //input.close();
        return prop;
    }


}
