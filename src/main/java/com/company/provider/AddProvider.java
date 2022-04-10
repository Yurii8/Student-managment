package com.company.provider;

import com.company.conectiondb.ConnectionDb;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AddProvider {
    ConnectionDb connectionDb = new ConnectionDb();
    int rows = 0;
    public int addStudents( String name, String surname, int groupId) {
        try {
            Connection dbConnection = connectionDb.getConnection();
            Statement statement = dbConnection.createStatement();
            rows = statement.executeUpdate("INSERT into students (name,surname,groupid) VALUES ('" + name + "', '" + surname + "','" + groupId + "')");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return rows;
    }

    public int addTeachers( String name, String surname) {
        try {
            Connection dbConnection = connectionDb.getConnection();
            Statement statement = dbConnection.createStatement();
            rows = statement.executeUpdate("INSERT into teachers (name,surname) VALUES ('"
                    + name + "', '" + surname + "')");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return rows;
    }
    public int addGroup(String groupName){
        try{
            Connection dbConnection = connectionDb.getConnection();
            Statement statement = dbConnection.createStatement();
            rows = statement.executeUpdate("INSERT into groups (id,groupname) VALUES ('"
                    + groupName +"')");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return rows;
    }
}

