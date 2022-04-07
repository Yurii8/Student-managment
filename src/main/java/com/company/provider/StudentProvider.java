package com.company.provider;

import com.company.conectiondb.ConnectionDb;
import com.company.entity.Student;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentProvider {
ConnectionDb connectionDb = new ConnectionDb();
    public List<Student> getStudentsByGroupId(int groupId) {
        List<Student> group = new ArrayList<>();
        try {
            Connection dbConnection = connectionDb.getConnection();
            Statement statement = dbConnection.createStatement();
            ResultSet rs = statement.executeQuery("select students.id, name ,surname, groupname from students inner join groups on students.groupid = groups.id where groupid ='" + groupId + "'");
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setSurname(rs.getString("surname"));
                student.setGroupName(rs.getString("groupname"));
                group.add(student);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return group;
    }

    public List<Student> getAllStudents() {
        List<Student> allStudentsList = new ArrayList<>();
        try {
            Connection dbConnection = connectionDb.getConnection();
            Statement statement = dbConnection.createStatement();
            ResultSet rs = statement.executeQuery("select students.id, name ,surname, groupname from students inner join groups on students.groupid = groups.id ");

            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setSurname(rs.getString("surname"));
                student.setGroupName(rs.getString("groupname"));
                allStudentsList.add(student);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return allStudentsList;
    }
}
