package com.company.provider;

import com.company.conectiondb.ConnectionDb;
import com.company.entity.Schedule;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ScheduleProvider {
    ConnectionDb connectionDb = new ConnectionDb();
    public List<Schedule> getScheduleByTeacherId(int teacherId) {
        List<Schedule> scheduleList = new ArrayList<>();
        try {
            Connection dbConnection = connectionDb.getConnection();
            Statement statement = dbConnection.createStatement();
            ResultSet rs = statement.executeQuery("Select s.id, subjectname ,audience, name, surname, groupname, timestamp, kindsubject\n" +
                    "from schedule as s\n" +
                    "         join groups as g on s.groupid = g.id\n" +
                    "    join subject as s2 on s.subjectid = s2.id\n" +
                    "         join teachers as t on s.teacherid = t.id where t.id ='" + teacherId + "'");
            while (rs.next()) {
                Schedule scheduleT = new Schedule();
                scheduleT.setId(rs.getInt("id"));
                scheduleT.setSubjectName(rs.getString("subjectname"));
                scheduleT.setAudience(rs.getInt("audience"));
                scheduleT.setTeacherName(rs.getString("name"));
                scheduleT.setTeacherSurname(rs.getString("surname"));
                scheduleT.setGroupName(rs.getString("groupname"));
                scheduleT.setTimeStamp(rs.getTimestamp("timestamp"));
                scheduleT.setKindSubject(rs.getString("kindsubject"));
                scheduleList.add(scheduleT);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return scheduleList;
    }

    public List<Schedule> getScheduleByGroupId(int groupId) {
        List<Schedule> scheduleList = new ArrayList<>();
        try {
            Connection dbConnection = connectionDb.getConnection();
            Statement statement = dbConnection.createStatement();
            ResultSet rs = statement.executeQuery("Select s.id, subjectname ,audience, name, surname, groupname, timestamp, kindsubject\n" +
                    "from schedule as s\n" +
                    "         join groups as g on s.groupid = g.id\n" +
                    "    join subject as s2 on s.subjectid = s2.id\n" +
                    "         join teachers as t on s.teacherid = t.id where g.id ='" + groupId + "'");
            while (rs.next()) {
                Schedule scheduleG = new Schedule();
                scheduleG.setId(rs.getInt("id"));
                scheduleG.setSubjectName(rs.getString("subjectname"));
                scheduleG.setAudience(rs.getInt("audience"));
                scheduleG.setTeacherName(rs.getString("name"));
                scheduleG.setTeacherSurname(rs.getString("surname"));
                scheduleG.setGroupName(rs.getString("groupname"));
                scheduleG.setTimeStamp(rs.getTimestamp("timestamp"));
                scheduleG.setKindSubject(rs.getString("kindsubject"));
                scheduleList.add(scheduleG);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return scheduleList;
    }
}
