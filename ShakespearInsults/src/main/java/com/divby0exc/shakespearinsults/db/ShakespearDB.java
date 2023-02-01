package com.divby0exc.shakespearinsults.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ShakespearDB {
    private static ShakespearDB db;
    private String driver = "jdbc:mysql://localhost:3306/shakespearinsults";
    private String user = "root";
    private String pwd = "";
    private ShakespearDB() {
    }



    public Connection getConnection() throws SQLException {
        Connection con = DriverManager.getConnection(driver, user, pwd);
        return con;
    }

    public static ShakespearDB getInstance() {
        if (db == null) {
            db = new ShakespearDB();
        }
        return db;
    }
}
