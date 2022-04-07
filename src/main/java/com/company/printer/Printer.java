package com.company.printer;

import com.company.entity.Group;
import com.company.entity.Schedule;
import com.company.entity.Student;
import com.company.entity.Teacher;
import com.company.provider.ScheduleProvider;
import com.company.provider.StudentProvider;
import com.company.provider.TeacherProvider;

import java.util.List;

public class Printer {
    public void printMainMenu() {
        System.out.printf("%n%1s%n", "Welcome to Student Database Application");
        System.out.printf("%.39s%n", "-------------------------------------------");
        System.out.printf("%s.%13s%n", "1", "Student list");
        System.out.printf("%s.%11s%n", "2", "Group list");
        System.out.printf("%s.%13s%n", "3", "Teacher list");
        System.out.printf("%s.%9s%n", "4", "Schedule");
        System.out.printf("%s.%4s%n", "5", "Add");
        System.out.printf("%s.%7s%n", "6", "Delete");
        System.out.printf("%s.%7s%n", "7", "Search");
        System.out.printf("%s.%5s%n", "0", "Exit");
        System.out.printf("%.39s%n", "------------------------------------------------");
        System.out.printf("%s", "Choose your option:");
    }

    public void studentOrTeacher() {
        System.out.printf("%n1 | %s%n2 | %s%n", "Student", "Teacher");
    }

    public void printGroupMenu(List<Group> groups) {
        System.out.printf("%.19s|%n", "==========================");
        System.out.println("Showing groups menu|");
        System.out.printf("%.19s|%n", "============================");
        System.out.printf("%s | %-14s|%n", "id", "group_name");
        System.out.printf("%.3s+%.15s|%n", "--------", "---------------------------");
        for (Group group : groups) {
            System.out.printf("%2d | %-14s|%n", group.getId(), group.getGroupName());
        }
        System.out.println("Press group number to show group details");
    }

    public void printTeacher(List<Teacher> teachers) {
        System.out.printf("%.29s%n", "=================================================================");
        System.out.printf("%22s%8s%n", "Showing teachers", "|");
        System.out.printf("%.29s|%n", "==================================================================");
        System.out.printf("%-2s | %-10s | %-10s |%n", "id", "name", "surname");
        System.out.printf("%-2.3s+%-10.12s+%-10.12s|%n", "--------------", "--------------", "-------------------");
        for (Teacher teacher : teachers) {
            System.out.printf("%-2s | %-10s | %-10s |%n", teacher.getId(), teacher.getName(), teacher.getSurname());
        }
        System.out.printf("%-2.3s|%-10.12s|%-10.12s|%n", "_______________", "______________________", "__________________________");
    }

    public void printStudentByGroupId(int groupId) {
        System.out.printf("%.48s%n", "=================================================================");
        System.out.printf("%44s%5s%n", "Showing students from group with id = " + groupId, "|");
        System.out.printf("%.48s|%n", "==================================================================");
        System.out.printf("%-3s | %-10s | %-14s | %-12s|%n", "id", "name", "surname", "group");
        System.out.printf("%-3.4s+%-10.12s+%-14.16s+%-12.13s|%n", "--------------", "--------------", "-------------------", "---------------");
        List<Student> students = new StudentProvider().getStudentsByGroupId(groupId);
        for (Student student : students) {
            System.out.printf("%-3s | %-10s | %-14s | %-12s|%n", student.getId(), student.getName(), student.getSurname(), student.getGroupName());
        }
        System.out.printf("%-3.4s|%-10.12s|%-14.16s|%-12.13s|%n", "_______________", "______________________", "__________________________", "_____________________________");
    }

    public void printAllStudents() {
        System.out.printf("%.48s%n", "=================================================================");
        System.out.printf("%35s%14s%n", "Showing all students", "|");
        System.out.printf("%.48s|%n", "==================================================================");
        System.out.printf("%-3s | %-10s | %-14s | %-12s|%n", "id", "name", "surname", "group");
        System.out.printf("%-3.4s+%-10.12s+%-14.16s+%-12.13s|%n", "--------------", "--------------", "-------------------", "---------------");
        List<Student> students = new StudentProvider().getAllStudents();
        for (Student student : students) {
            System.out.printf("%-3s | %-10s | %-14s | %-12s|%n", student.getId(), student.getName(), student.getSurname(), student.getGroupName());
        }
        System.out.printf("%-3.4s|%-10.12s|%-14.16s|%-12.13s|%n", "_______________", "______________________", "__________________________", "_____________________________");
    }

    public void printScheduleTeacher(int teacherId) {
        System.out.printf("%.125s%n", "=============================================================================================================================================================");
        System.out.printf("%70s%n", "Showing group schedule ");
        System.out.printf("%.125s%n", "============================================================================================================================================================");
        System.out.printf("%-3s| %-34s| %-9s| %-18s| %-6s| %-30s| %-12s|%n", "id", "subject", "audience", "teacher", "group", "time", "kindsubject");
        System.out.printf("%.3s+%.35s+%.10s+%.19s+%.7s+%.31s+%.13s|%n", "----------", "-----------------------------------------------", "-----------------", "----------------------------------------", "--------------------", "------------------------------------------", "-------------------");
        List<Schedule> schedules = new ScheduleProvider().getScheduleByTeacherId(teacherId);
        for (Schedule schedule : schedules) {
            System.out.printf("%-3d| %-34s| %-9d| %-18s| %-6s| %-30tc| %-12s|%n", schedule.getId(), schedule.getSubjectName(), schedule.getAudience(), schedule.getTeacherName() + " " + schedule.getTeacherSurname(), schedule.getGroupName(), schedule.getTimeStamp(), schedule.getKindSubject());
        }
    }

    public void printScheduleGroup(int groupId) {
        System.out.printf("%.125s%n", "=============================================================================================================================================================");
        System.out.printf("%70s%n", "Showing group schedule ");
        System.out.printf("%.125s%n", "============================================================================================================================================================");
        System.out.printf("%-3s| %-34s| %-9s| %-18s| %-6s| %-30s| %-12s|%n", "id", "subject", "audience", "teacher", "group", "time", "kindsubject");
        System.out.printf("%.3s+%.35s+%.10s+%.19s+%.7s+%.31s+%.13s|%n", "----------", "-----------------------------------------------", "-----------------", "----------------------------------------", "--------------------", "------------------------------------------", "-------------------");
        List<Schedule> schedules = new ScheduleProvider().getScheduleByGroupId(groupId);
        for (Schedule schedule : schedules) {
            System.out.printf("%-3d| %-34s| %-9d| %-18s| %-6s| %-30tc| %-12s|%n", schedule.getId(), schedule.getSubjectName(), schedule.getAudience(), schedule.getTeacherName() + " " + schedule.getTeacherSurname(), schedule.getGroupName(), schedule.getTimeStamp(), schedule.getKindSubject());
        }
    }

    public void printBackMenu() {
        System.out.printf("+%.6s+%.11s+%n", "----------", "--------------");
        System.out.printf("|%5s | %-10s|%n", "Back", "Main Menu");
        System.out.printf("+%.6s+%.11s+%n ", "-----------", "---------------");
        System.out.printf("%s", "Choose your option: ");
    }
    public void printUpdateMenu(){
        System.out.printf("+%.5s+%.8s+%n", "----------", "--------------");
        System.out.printf("|%4s | %-7s|%n", "Add", "Delete");
        System.out.printf("+%.5s+%.8s+%n", "-----------", "---------------");
    }
}
