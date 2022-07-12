/**
 * @author : Isuru Lakmal G K A
 * Date    : $(DATE)
 **/

package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbconnection {
    private static Dbconnection dbconnection=null;
    private Connection connection;

    private Dbconnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql:localhost:3306/ijse","root","Isuru#lak9924");
    }

    public static Dbconnection getInstance() throws SQLException, ClassNotFoundException {
        if (dbconnection==null){
            dbconnection = new Dbconnection();
        }
        return dbconnection;
    }

    public Connection getConnection() {
        return connection;
    }
}
