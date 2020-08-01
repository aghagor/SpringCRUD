package com.aghagor;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private ConnectionFactory() {
        try {
            Driver driver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(driver);
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ConnectionFactory getInstance() {
        return Helper.FACTORY;
    }

    public Connection openConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/springdb",
                "root", "@Lvard2019!");
    }

    private static class Helper {
        private static final ConnectionFactory FACTORY = new ConnectionFactory();
    }
}
