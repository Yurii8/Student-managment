package com.company.processor;

import com.company.entity.Group;
import com.company.entity.Teacher;
import com.company.input.InputController;
import com.company.menu.StartMenu;
import com.company.printer.Printer;
import com.company.provider.GroupProvider;
import com.company.provider.TeacherProvider;

import java.util.List;

public class ScheduleProcessor {
    Printer printer = new Printer();
    GroupProvider groupProvider = new GroupProvider();
    InputController inputController = new InputController();
    TeacherProvider teacherProvider = new TeacherProvider();

    public void showSchedule() {
        printer.studentOrTeacher();
        printer.printBackMenu();
        List<Group> groupList = groupProvider.getGroupList();
        List<Teacher> teacherList = teacherProvider.getTeachers();
        String choice = inputController.inputString();
        while (true) {
            if (inputController.isKeyword(choice)) {
                if (choice.equals("student")) {
                    printer.printGroupMenu(groupList);
                    printer.printBackMenu();
                    choice = inputController.inputString();
                        if (inputController.isKeyword(choice)) {
                            if (choice.equals("back")) {
                                showSchedule();
                                break;
                            }
                            if (choice.equals("menu")) {
                                new StartMenu().start();
                                break;
                            }
                        }
                        if (inputController.isInteger(choice)) {
                            if (inputController.isValidGroupId(choice, groupList)) {
                                showScheduleGroup(Integer.parseInt(choice));
                                break;
                            } else {
                                System.out.println("Please enter a valid group id: ");
                                choice = inputController.inputString();
                            }
                        } else {
                            System.out.print("Please enter a valid choice: ");
                            choice = inputController.inputString();
                        }
                }
                if (choice.equals("teacher")) {
                    printer.printTeacher(teacherList);
                    System.out.println("Press teacher id to show teacher schedule");
                    printer.printBackMenu();
                    choice = inputController.inputString();
                        if (inputController.isKeyword(choice)) {
                            if (choice.equals("back")) {
                                showSchedule();
                                break;
                            }
                            if (choice.equals("menu")) {
                                new StartMenu().start();
                                break;
                            }
                        }
                        if (inputController.isInteger(choice)) {
                            if (inputController.isValidTeacherId(choice, teacherList)) {
                                showScheduleTeacher(Integer.parseInt(choice));
                                break;
                            } else {
                                System.out.print("Please enter a valid teacher id: ");
                                choice = inputController.inputString();
                            }
                        } else {
                            System.out.print("Please enter a valid choice: ");
                            choice = inputController.inputString();
                        }

                }
                if (choice.equals("back") || choice.equals("menu")) {
                    new StartMenu().start();
                    break;
                }
            } else {
                System.out.print("Please enter a valid choice:");
                choice = inputController.inputString();
            }
        }
    }

    public void showScheduleTeacher(int teacherId) {
        printer.printScheduleTeacher(teacherId);
        addGoBackButton();
    }

    public void showScheduleGroup(int groupId) {
        printer.printScheduleGroup(groupId);
        addGoBackButton();
    }

    private void addGoBackButton() {
        printer.printBackMenu();
        String choice = inputController.inputString();
        while (true) {
            if (inputController.isKeyword(choice)) {
                if (choice.equals("back")) {
                    showSchedule();
                    break;
                }if (choice.equals("menu")) {
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


