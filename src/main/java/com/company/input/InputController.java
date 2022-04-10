package com.company.input;

import com.company.entity.Group;
import com.company.entity.Teacher;

import java.util.List;
import java.util.Scanner;

public class InputController {
    public Scanner in = new Scanner(System.in);

    public String inputString() {
        return in.next();
    }

    public boolean isKeyword(String inputValue) {
        return inputValue != null && (inputValue.equals("back") || inputValue.equals("menu")
                ||inputValue.equals("add")|| inputValue.equals("delete")||inputValue.equals("student")
                ||inputValue.equals("teacher")||inputValue.equals("modify"));
    }

    public boolean isValidGroupId(String groupIdString, List<Group> groupList) {
        int groupId = Integer.parseInt(groupIdString);
        return groupList.stream().anyMatch(group -> groupId == group.getId());
    }

    public boolean isInteger(String inputValue) {
        try {
            Integer.parseInt(inputValue);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public boolean isValidTeacherId(String teacherIdString, List<Teacher> teacherList){
        int teacherId = Integer.parseInt(teacherIdString);
        return teacherList.stream().anyMatch(teacher -> teacherId  == teacher.getId());
    }
}
