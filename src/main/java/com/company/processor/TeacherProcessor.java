package com.company.processor;

import com.company.entity.Teacher;
import com.company.input.InputController;
import com.company.menu.StartMenu;
import com.company.printer.Printer;
import com.company.provider.TeacherProvider;

import java.util.List;

public class TeacherProcessor {

    Printer printer = new Printer();
    InputController inputController = new InputController();
    TeacherProvider teacherProvider = new TeacherProvider();
    public void showTeacher() {
        List<Teacher> teachers = teacherProvider.getTeachers();
        printer.printTeacher(teachers);
        printer.printBackMenu();
        String choice = inputController.inputString();
        while (true) {
            if (inputController.isKeyword(choice)) {
                if (choice.equals("back")|| choice.equals("menu")) {
                    new StartMenu().start();
                    break;
                }
            } else {
                System.out.println("Please enter a valid number");
                choice = inputController.inputString();
            }
        }
    }
}
