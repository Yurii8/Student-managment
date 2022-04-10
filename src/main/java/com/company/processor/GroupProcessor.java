package com.company.processor;

import com.company.entity.Group;
import com.company.entity.Student;
import com.company.input.InputController;
import com.company.menu.StartMenu;
import com.company.printer.Printer;
import com.company.provider.AddProvider;
import com.company.provider.GroupProvider;
import com.company.provider.RemoveProvider;
import com.company.provider.StudentProvider;

import java.util.List;

public class GroupProcessor {
    Printer printer = new Printer();
    GroupProvider groupProvider = new GroupProvider();
    InputController inputController = new InputController();
    AddProvider addProvider = new AddProvider();
    RemoveProvider removeProvider = new RemoveProvider();
    String choice;
    public void showGroupsMenu() {

        List<Group> groupList = groupProvider.getGroupList();
        printer.printGroupMenu(groupList);
        printer.printUpdateMenu();
        printer.printBackMenu();
        choice = inputController.inputString();
        //1. choice is number
        //2. choice is one of real group ids
        // ValidateGroupId()
        while (true) {
            if (inputController.isKeyword(choice)) {
                if(choice.equals("back")||choice.equals("menu")){
                    new StartMenu().start();
                    break;
                }
                if(choice.equals("add") ){
                    addGroup();
                }if (choice.equals("delete")){
                    deleteGroup();
                }
                else {
                    modifyGroups();

                }
                break;
            }
            if (inputController.isInteger(choice)) {
                if (inputController.isValidGroupId(choice, groupList)) {
                    showGroupDetails(Integer.parseInt(choice));
                    break;
                } else {
                    System.out.print("Please enter a valid group id: ");
                    choice = inputController.inputString();
                }
            } else {
                System.out.print("Please enter a valid choice: ");
                choice = inputController.inputString();
            }
        }
    }

    public void showGroupDetails(int groupId) {
        printer.printStudentByGroupId(groupId);
        printer.printBackMenu();
        choice = inputController.inputString();
        while (true) {
            if (inputController.isKeyword(choice)) {
                if (choice.equals("back")) {
                    showGroupsMenu();
                }else{
                    new StartMenu().start();
                }
                break;
            } else {
                System.out.print("Please enter a valid choice: ");
                choice = inputController.inputString();
            }
        }
    }
    public void addGroup(){
        System.out.print("Enter name group");
        String groupName = inputController.inputString();
        if(addProvider.addGroup(groupName) > 0){
            System.out.println("Group add");
        }else {
            System.out.println("Group don`t add");
        }
        addGoBackButton();
    }
    public void deleteGroup(){
        System.out.print("Delete by id will be?(Y/N)");
        char charAt = inputController.inputChar();
        if (charAt == 'Y' || charAt == 'y') {
            System.out.print("Enter an id:");
            String id = inputController.inputString();
            int groupId = Integer.parseInt(id);
            if(isPresentById(groupId)){
                System.out.println("There are students present in the group, are you sure you want to delete this group?(Y/N)");
                char yesOrNo = inputController.inputChar();
                if(yesOrNo == 'Y' || yesOrNo == 'y'){
                    if (removeProvider.deleteGroupById(groupId) > 0){
                        System.out.println("Group removed");
                    } else {
                        System.out.println("Group don`t removed");
                    }
                }else{
                    return;
                }
            }
        } else {
            System.out.print("Enter a name:");
            String name = inputController.inputString();
            if(isPresentByName(name)) {
                System.out.println("There are students present in the group, are you sure you want to delete this group?(Y/N)");
                char yesOrNo = inputController.inputChar();
                if (yesOrNo == 'Y' || yesOrNo == 'y') {
                    if (removeProvider.deleteGroupByName(name) > 0) {
                        System.out.println("Group removed");
                    } else {
                        System.out.println("Group don`t removed");
                    }
                } else {
                    return;
                }
            }

        }
        addGoBackButton();
    }
    public boolean isPresentById(int groupId){
        List<Student> students = new StudentProvider().getStudentsByGroupId(groupId);
        return students.size() > 0;
    }
    public boolean isPresentByName(String groupName){
        List<Student> students = new StudentProvider().getStudentsByName(groupName);
        return students.size() > 0;
    }

    public void modifyGroups(){
        System.out.println("Enter the id of the group you want to modify:");
        String groupIdString = inputController.inputString();
        int groupId = Integer.parseInt(groupIdString);
        System.out.println("Enter a new group name");
        String newGroupName = inputController.inputString();
        if(groupProvider.modifyGroup(groupId, newGroupName )> 0){
            System.out.println("The group is modified");
        }else {
            System.out.println("The group is not modified");
        }
    }
    private void addGoBackButton() {
        printer.printBackMenu();
        choice = inputController.inputString();
        while (true) {
            if (inputController.isKeyword(choice)) {
                if (choice.equals("back")) {
                    showGroupsMenu();
                    break;
                }
                if(choice.equals("menu")){
                    new StartMenu().start();
                    break;
                }else {
                    System.out.print("Please enter a valid choice:");
                    choice = inputController.inputString();
                }
            } else {
                System.out.print("Please enter a valid choice: ");
                choice = inputController.inputString();
            }
        }
    }

}
