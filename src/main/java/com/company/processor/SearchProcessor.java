package com.company.processor;

import com.company.menu.StartMenu;
import com.company.provider.SearchProvider;
import com.company.entity.Student;
import com.company.entity.Teacher;
import com.company.input.InputController;
import com.company.printer.Printer;

import java.util.List;

public class SearchProcessor {

    Printer printer = new Printer();
    InputController inputController = new InputController();
    SearchProvider searchProvider = new SearchProvider();

    public void search() {
        printer.studentOrTeacher();
        printer.printBackMenu();
        String choice = inputController.inputString();
        while (true) {
            if (inputController.isKeyword(choice)) {
                if (choice.equals("student")) {
                    searchStudent();
                    break;
                }
                if (choice.equals("teachers")) {
                    searchTeacher();
                    break;
                }
                if (choice.equals("back") || choice.equals("menu")) {
                    new StartMenu().start();
                    break;
                }
            } else {
                System.out.print("Please enter a valid number:");
                choice = inputController.inputString();
            }
        }
    }


    public void searchStudent() {
        System.out.print("Search by id will be?(Y/N)");
        char cha = inputController.inputChar();
        if (cha == 'Y' || cha == 'y') {
            System.out.print("Enter an id:");
            String id = inputController.inputString();
            List<Student> students = searchProvider.getStudentById(Integer.parseInt(id));
            while (true) {
                if (inputController.isInteger(id)) {
                    for (Student student : students) {
                        System.out.printf("%-3s | %-10s | %-14s | %-12s|%n", student.getId(), student.getName(), student.getSurname(), student.getGroupName());
                    }
                    if (students.size() == 0) {
                        System.out.println("Student not found");
                    }
                    break;
                } else {
                    System.out.print("Please enter a number: ");
                    id = inputController.inputString();
                }
            }
        } else {
            System.out.print("Enter a name:");

            String name = inputController.inputString();
            List<Student> students = searchProvider.getStudentByName(name);
            for (Student student : students) {
                System.out.printf("%-3s | %-10s | %-14s | %-12s|%n", student.getId(), student.getName(), student.getSurname(), student.getGroupName());
            }
            if (students.size() == 0) {
                System.out.println("Student not found");
            }
        }
        printer.printBackMenu();
        addGoBackButton();
    }

    public void searchTeacher() {
        System.out.print("Search by id will be?(Y/N)");
        char cha = inputController.inputChar();
        if (cha == 'Y' || cha == 'y') {
            System.out.print("Enter an id:");
            String id = inputController.inputString();
            List<Teacher> teachers = searchProvider.getTeacherById(Integer.parseInt(id));
            while (true) {
                if (inputController.isInteger(id)) {
                    for (Teacher teacher : teachers) {
                        System.out.printf("%-2s | %-10s | %-10s |%n", teacher.getId(), teacher.getName(), teacher.getSurname());
                    }
                    if (teachers.size() == 0) {
                        System.out.println("Teacher not found");
                    }
                    break;
                } else {
                    System.out.print("Please enter a number: ");
                    id = inputController.inputString();
                }
            }
        } else {
            System.out.print("Enter a name:");
            String name = inputController.inputString();
            List<Teacher> teachers = searchProvider.getTeacherByName(name);
            for (Teacher teacher : teachers) {
                System.out.printf("%-2s | %-10s | %-10s |%n", teacher.getId(), teacher.getName(), teacher.getSurname());
            }
            if (teachers.size() == 0) {
                System.out.println("Teacher not found");
            }
        }
        printer.printBackMenu();
        addGoBackButton();
    }

    private void addGoBackButton() {
        String choice = inputController.inputString();
        while (true) {
            if (inputController.isKeyword(choice)) {
                if (choice.equals("back")) {
                    search();
                    break;
                }
                if (choice.equals("menu")) {
                    new StartMenu().start();
                    break;
                }
            }
        }
    }
}

