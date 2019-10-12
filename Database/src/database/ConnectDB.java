package database;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectDB {
    public static Connection getConnection() throws SQLException 
    {
        Connection conn = null;
        String url       = "jdbc:mysql://localhost:3307/GEW?serverTimezone=UTC";
        String user      = "root";
        String password  = "Loemak123";

        conn = DriverManager.getConnection(url, user, password);

        return conn;
    }
}

