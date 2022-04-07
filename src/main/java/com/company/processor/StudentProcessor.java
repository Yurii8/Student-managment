package com.company.processor;


import com.company.input.InputController;
import com.company.menu.StartMenu;
import com.company.printer.Printer;

public class StudentProcessor {

    Printer printer = new Printer();
    InputController inputController = new InputController();
    public void showStudent() {
        printer.printAllStudents();
        printer.printBackMenu();
        String choice = inputController.inputString();
        while (true) {
            if (inputController.isKeyword(choice)) {
                if (choice.equals("back") || choice.equals("menu")) {
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
