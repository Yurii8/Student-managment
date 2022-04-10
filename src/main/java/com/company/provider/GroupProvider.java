package com.company.provider;


import com.company.conectiondb.ConnectionDb;
import com.company.entity.Group;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GroupProvider {
    ConnectionDb connectionDb = new ConnectionDb();

    public List<Group> getGroupList() {
        List<Group> groupList = new ArrayList<>();
        try {
            Connection dbConnection = connectionDb.getConnection();
            Statement statement = dbConnection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * from groups");
            while (rs.next()) {
                Group group = new Group();
                group.setId(rs.getInt("id"));
                group.setGroupName(rs.getString("groupname"));
                groupList.add(group);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return groupList;
    }

    public int modifyGroup(int groupId,String newName) {
        int rows = 0;
        try {
            Connection dbConnection = connectionDb.getConnection();
            Statement statement = dbConnection.createStatement();
            rows = statement.executeUpdate("UPDATE groups SET groupname = '"
                    + newName + "' where id = '" + groupId + "'");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return rows;
    }
}

