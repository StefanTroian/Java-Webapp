package utils_db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {

    //jdbc driver and url
    //private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/lab_test";

    //mysql user and pass
    private static final String USER = "root";
    private static final String PASS = "12998682";

    private static Connection conn;

    private DBconnection() {
        try {
            //Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        if (conn == null)
            new DBconnection();

        return conn;
    }
}
