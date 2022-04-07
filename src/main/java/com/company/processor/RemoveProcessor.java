package com.company.processor;

import com.company.menu.StartMenu;
import com.company.provider.RemoveProvider;
import com.company.input.InputController;
import com.company.printer.Printer;

public class RemoveProcessor {
    Printer printer = new Printer();
    InputController inputController = new InputController();
    RemoveProvider removeProvider = new RemoveProvider();

    public void removeProcessor() {
        printer.studentOrTeacher();
        printer.printBackMenu();
        String choice = inputController.inputString();
        while (true) {
            if (inputController.isKeyword(choice)) {
                if (choice.equals("student")) {
                    removeStudentProcessor();
                    break;
                }
                if (choice.equals("teacher")) {
                    removeTeacherProcessor();
                    break;
                }
                if (choice.equals("back") || choice.equals("menu")) {
                    new StartMenu().start();
                    break;
                }
            } else {
                System.out.print("Please enter a valid number: ");
                choice = inputController.inputString();
            }
        }
    }

    public void removeStudentProcessor() {
        System.out.print("Delete by id will be?(Y/N)");
        char cha = inputController.in.next().charAt(0);
        if (cha == 'Y' || cha == 'y') {
            System.out.print("Enter an id:");
            String id = inputController.inputString();
            while (true) {
                if (inputController.isInteger(id)) {
                    if (removeProvider.deleteStudentsById(Integer.parseInt(id)) > 0) {
                        System.out.println("Student removed");
                    } else {
                        System.out.println("Student don`t removed");
                    }
                    break;
                } else {
                    System.out.print("Please enter a valid number: ");
                    id = inputController.inputString();
                }
            }
        } else {
            System.out.print("Enter a name:");
            String name = inputController.inputString();
            if (removeProvider.deleteStudentsByName(name) > 0) {
                System.out.println("Student removed");
            } else {
                System.out.println("Student don`t removed");
            }
        }
        addGoBackButton();
    }

    public void removeTeacherProcessor() {
        System.out.print("Delete by id will be?(Y/N)");
        char cha = inputController.in.next().charAt(0);
        if (cha == 'Y' || cha == 'y') {
            System.out.print("Enter an id:");
            String id = inputController.inputString();
            while (true) {
                if (inputController.isInteger(id)) {
                    if (removeProvider.deleteTeachersById(Integer.parseInt(id)) > 0) {
                        System.out.println("Teacher removed");
                    } else {
                        System.out.println("Teacher don`t removed");
                    }
                    break;
                } else {
                    System.out.print("Please enter a valid choice:");
                    id = inputController.inputString();
                }
            }
        } else {
            System.out.print("Enter a name:");
            String name = inputController.inputString();
            if (removeProvider.deleteTeacherByName(name) > 0) {
                System.out.println("Teacher removed");
            } else {
                System.out.println("Teacher don`t removed");
            }
        }
        addGoBackButton();
    }

    private void addGoBackButton() {
        printer.printBackMenu();
        String choice = inputController.inputString();
        while (true) {
            if (inputController.isKeyword(choice)) {
                if (choice.equals("back")) {
                    removeProcessor();
                    break;
                }
                if (choice.equals("menu")) {
                    new StartMenu().start();
                    break;
                }
            } else {
                System.out.print("Please enter a valid number:");
                choice = inputController.inputString();
            }
        }
    }
}
