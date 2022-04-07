package com.company.conectiondb;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class ConnectionDb {
    public Connection getConnection() {
        String urlDb = "jdbc:postgresql://localhost:5432/student_managment";
        String username = "yurii";
        String password = "12345678";
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException(e.getMessage());
        }
        try {
            return DriverManager.getConnection(urlDb, username, password);
        } catch (SQLException e) {
            System.out.print("Could`n connect to database ");
                throw new IllegalStateException(e.getMessage());
        }
    }
}
