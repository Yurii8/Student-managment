package com.company.provider;

import com.company.entity.Student;
import com.company.entity.Teacher;
import com.company.conectiondb.ConnectionDb;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SearchProvider {
    ConnectionDb connectionDb = new ConnectionDb();
    public List<Student> getStudentById(int id) {
        List<Student> studentListOneElements = new ArrayList<>();
        try {
            Connection dbConnection = connectionDb.getConnection();
            Statement statement = dbConnection.createStatement();
            ResultSet rs = statement.executeQuery("select students.id, name ,surname, groupname from students inner join groups on students.groupid = groups.id where students.id ='" + id + "'");
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setSurname(rs.getString("surname"));
                student.setGroupName(rs.getString("groupname"));
                studentListOneElements.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentListOneElements;
    }

    public List<Student> getStudentByName(String name) {
        List<Student> studentListOneElements = new ArrayList<>();
        try {
            Connection dbConnection = connectionDb.getConnection();
            Statement statement = dbConnection.createStatement();
            ResultSet rs = statement.executeQuery("select students.id, name ,surname, groupname from students inner join groups on students.groupid = groups.id where name ='" + name + "'");
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setSurname(rs.getString("surname"));
                student.setGroupName(rs.getString("groupname"));
                studentListOneElements.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentListOneElements;
    }

    public List<Teacher> getTeacherById(int id) {
        List<Teacher> teacherListOneElement = new ArrayList<>();
        try {
            Connection dbConnection = connectionDb.getConnection();
            Statement statement = dbConnection.createStatement();
            ResultSet rs = statement.executeQuery("Select * from teachers where id = '" + id + "'");
            while (rs.next()) {
                Teacher teacher = new Teacher();
                teacher.setId(rs.getInt("id"));
                teacher.setName(rs.getString("name"));
                teacher.setSurname(rs.getString("surname"));
                teacherListOneElement.add(teacher);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return teacherListOneElement;
    }

    public List<Teacher> getTeacherByName(String name) {
        List<Teacher> teacherListOneElement = new ArrayList<>();
        try {
            Connection dbConnection = connectionDb.getConnection();
            Statement statement = dbConnection.createStatement();
            ResultSet rs = statement.executeQuery("Select * from teachers where name = '" + name + "'");
            while (rs.next()) {
                Teacher teacher = new Teacher();
                teacher.setId(rs.getInt("id"));
                teacher.setName(rs.getString("name"));
                teacher.setSurname(rs.getString("surname"));
                teacherListOneElement.add(teacher);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return teacherListOneElement;
    }
}
