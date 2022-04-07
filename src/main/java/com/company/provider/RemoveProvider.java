package com.company.provider;

import com.company.conectiondb.ConnectionDb;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class RemoveProvider {
    ConnectionDb connectionDb = new ConnectionDb();
    int rows = 0;
    public int deleteStudentsById(int id) {
        try {
            Connection dbConnection = connectionDb.getConnection();
            Statement statement = dbConnection.createStatement();
            rows = statement.executeUpdate("DELETE from students where id = '" + id + "'");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return rows;
    }

    public int deleteStudentsByName(String name) {
        try {
            Connection dbConnection = connectionDb.getConnection();
            Statement statement = dbConnection.createStatement();
            rows = statement.executeUpdate("DELETE from students where name = '" + name + "'");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return rows;
    }


    public int deleteTeachersById(int id) {
        try {
            Connection dbConnection = connectionDb.getConnection();
            Statement statement = dbConnection.createStatement();
            rows = statement.executeUpdate("DELETE from teachers where id = '" + id + "'");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return rows;
    }


    public int deleteTeacherByName(String name) {
        try {
            Connection dbConnection = connectionDb.getConnection();
            Statement statement = dbConnection.createStatement();
            rows = statement.executeUpdate("DELETE from teachers where name = '" + name + "'");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return rows;
    }
    public int deleteGroupById(int id){
        try{
            Connection dbConnection = connectionDb.getConnection();
            Statement statement = dbConnection.createStatement();
            rows = statement.executeUpdate("DELETE  from groups where id = '" + id + "'");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return rows;
    }
    public int deleteGroupByName(String name){
        try {
            Connection dbConnection = connectionDb.getConnection();
            Statement statement = dbConnection.createStatement();
            rows = statement.executeUpdate("DELETE  from groups where groupname = '" + name + "'");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return rows;
    }
}
