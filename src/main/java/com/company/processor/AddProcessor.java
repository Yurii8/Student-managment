package com.company.processor;

import com.company.entity.Student;
import com.company.menu.StartMenu;
import com.company.provider.AddProvider;
import com.company.input.InputController;
import com.company.printer.Printer;
import com.company.provider.StudentProvider;

import java.util.List;

public class AddProcessor {
    public static final int MAX_GROUP_CAPACITY = 40;
    Printer printer = new Printer();
    InputController inputController = new InputController();
    AddProvider addProvider = new AddProvider();
    public void addProcessor() {
        printer.studentOrTeacher();
        printer.printBackMenu();
        String choice = inputController.inputString();
        while (true) {
            if (Integer.parseInt(choice) == 1) {
                addStudentProcessor();
                break;
            } else if (Integer.parseInt(choice) == 2) {
                addTeacherProcessor();
                break;
            } else if (Integer.parseInt(choice) == 0 || Integer.parseInt(choice) == 9) {
                new StartMenu().start();
                break;
            } else {
                System.out.print("Please enter a valid number:");
                choice = inputController.inputString();
            }
        }
    }

    public void addStudentProcessor() {
        System.out.print("Enter id group students:");
        String groupIdString = inputController.inputString();
        int groupId = Integer.parseInt(groupIdString);
        List<Student> studentGroup = new StudentProvider().getStudentsByGroupId(groupId);
        if(studentGroup.size()== MAX_GROUP_CAPACITY){
            System.out.println("It`s group is full");
        }else {
            System.out.print("Enter name students:");
            String name = inputController.inputString();
            System.out.print("Enter surname students:");
            String surname = inputController.inputString();
            List<Student> addStudent = addProvider.addStudents(name, surname, groupId);
                if(addStudent.size()>0) {
                    for(Student student: addStudent)
                    System.out.println("Student add. His id " + student.getId());
                }else {
                    System.out.println("Student don`t add");
                }
        }
        addGoBackButton();
    }


    public void addTeacherProcessor() {
        System.out.print("Enter name teacher:");
        String name = inputController.inputString();
        System.out.print("Enter surname teacher:");
        String surname = inputController.inputString();
        if (addProvider.addTeachers( name, surname) >0) {
            System.out.println("Teacher add");
        } else {
            System.out.println("Teacher don`t add");
        }
        addGoBackButton();
    }

    private void addGoBackButton() {
        printer.printBackMenu();
        String choice = inputController.inputString();
        while (true) {
            if (Integer.parseInt(choice) == 0) {
                addProcessor();
                break;
            } else if (Integer.parseInt(choice) == 9) {
                new StartMenu().start();
                break;
            } else {
                System.out.print("Please enter a valid number:");
                choice = inputController.inputString();
            }
        }
    }
}
