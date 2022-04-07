package com.company.provider;

import com.company.conectiondb.ConnectionDb;
import com.company.entity.Teacher;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TeacherProvider {
    ConnectionDb connectionDb = new ConnectionDb();
    public List<Teacher> getTeachers() {
        List<Teacher> teacherList = new ArrayList<>();
        try {
            Connection dbConnection = connectionDb.getConnection();
            Statement statement = dbConnection.createStatement();
            ResultSet rs = statement.executeQuery("Select * from teachers");
            while (rs.next()) {
                Teacher teacher = new Teacher();
                teacher.setId(rs.getInt("id"));
                teacher.setName(rs.getString("name"));
                teacher.setSurname(rs.getString("surname"));
                teacherList.add(teacher);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return teacherList;
    }
}
