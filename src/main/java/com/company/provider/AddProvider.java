package com.company.provider;

import com.company.conectiondb.ConnectionDb;
import com.company.entity.Student;
import com.company.entity.Teacher;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.SynchronousQueue;

public class AddProvider {
    ConnectionDb connectionDb = new ConnectionDb();
    int rows = 0;
    public List<Student> addStudents(String name, String surname, int groupId) {
        List<Student > addStudent = new ArrayList<>();
        try {
            Connection dbConnection = connectionDb.getConnection();
            Statement statement = dbConnection.createStatement();
            statement.executeUpdate("INSERT into students (name,surname,groupid) VALUES ('" + name + "', '" + surname + "','" + groupId + "')");
            ResultSet rs = statement.executeQuery("Select * from students where name = '" + name + "',surname = '" + surname +"',groupid = '" + groupId +"'");
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setSurname(rs.getString("surname"));
                student.setGroupName(rs.getString("groupid"));
                addStudent.add(student);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return addStudent;
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

