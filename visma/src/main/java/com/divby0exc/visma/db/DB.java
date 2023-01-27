package com.divby0exc.visma.db;

import org.springframework.boot.SpringApplication;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
    private static DB db;
    private String driver = "jdbc:mysql://localhost:3306/visma";
    private String user = "root";
    private String pwd = "";
    private DB() {
    }



    public Connection getConnection() throws SQLException {
        Connection con = DriverManager.getConnection(driver, user, pwd);
        return con;
    }

    public static DB getInstance() {
        if (db == null) {
                db = new DB();
            }
        return db;
    }
}
