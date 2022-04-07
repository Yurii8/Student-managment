package com.company.menu;

import com.company.processor.StudentProcessor;
import com.company.processor.TeacherProcessor;
import com.company.input.InputController;
import com.company.printer.Printer;
import com.company.processor.*;

public class StartMenu {
    StudentProcessor studentProcessor = new StudentProcessor();
    GroupProcessor groupProcessor = new GroupProcessor();
    TeacherProcessor teacherProcessor = new TeacherProcessor();
    ScheduleProcessor scheduleProcessor = new ScheduleProcessor();
    AddProcessor addProcessor = new AddProcessor();
    RemoveProcessor removeProcessor = new RemoveProcessor();
    SearchProcessor searchProcessor = new SearchProcessor();
    Printer printer = new Printer();
    InputController inputController = new InputController();

    public void start() {
        printer.printMainMenu();
        String choice = inputController.inputString();
        while (true) {
            if (inputController.isInteger(choice)) {
                switch (Integer.parseInt(choice)) {
                    case 1 -> studentProcessor.showStudent();
                    case 2 -> groupProcessor.showGroupsMenu();
                    case 3 -> teacherProcessor.showTeacher();
                    case 4 -> scheduleProcessor.showSchedule();
                    case 5 -> addProcessor.addProcessor();
                    case 6 -> removeProcessor.removeProcessor();
                    case 7 -> searchProcessor.search();
                    case 0 -> System.exit(0);
                }
            } else {
                System.out.print("Please enter a valid choice: ");
                choice = inputController.inputString();
            }
        }
    }
}

