package com.university.ui;
import com.university.data.DBUser;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("*------Project by P20094-------*");
        System.out.println("  Welcome to the University App");
        int option;
        do {
            option = menu();
            switch (option) {
                case 1 -> viewUsers();
                case 2 -> addUser();
                case 3 -> searchUserByName();
                case 4 -> searchUserByRegNumber();
                case 5 -> editUserByRegNumber();
                case 6 -> deleteUserByRegNumber();
                case 7 -> exitApp();
                default -> System.out.printf("%n-!-!-!-You have selected an invalid option-!-!-!-%n%n");
            }
        }
        while (option != 7);
    }

    public static int menu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("+------------------------------+");
        System.out.println("|Please select an option below:|");
        System.out.println("+------------------------------+");
        System.out.println("1. View all the users that have registered in the app");
        System.out.println("2. Add a new user");
        System.out.println("3. Search by full name");
        System.out.println("4. Search by registration number");
        System.out.println("5. Edit user profile based on the user's registration number");
        System.out.println("6. Delete a user by user's registration number");
        System.out.println("7. Exit the app");
        System.out.println("------------------------------");
        System.out.print("You want the option number: ");
        return sc.nextInt();
    }

    public static void viewUsers() {
        DBUser.viewUsers();
    }

    public static void addUser(){
        int option = 0;
        do {
            Scanner sc = new Scanner(System.in);
            System.out.printf("%nPlease select the type of user you want to add:%n");
            System.out.println("1. Student");
            System.out.println("2. Professor");
            System.out.println("3. Secretary");
            System.out.println("4. Administrator");
            System.out.println("5. Return to main menu");
            System.out.print("You want the option number: ");
            option = sc.nextInt();
            switch (option) {
                case 1 -> DBUser.createUser("Student");
                case 2 -> DBUser.createUser("Professor");
                case 3 -> DBUser.createUser("Secretary");
                case 4 -> DBUser.createUser("Administrator");
                case 5 -> System.out.printf("%nYou have selected option 5. Goodbye!%n%n");
                default -> System.out.printf("%n-!-!-!-You have selected an invalid option-!-!-!-%n%n");
            }
        }
        while (option != 5);
    }

    public static void searchUserByName(){
        Scanner sc = new Scanner(System.in);
        System.out.printf("%nPlease type the full name of the user: ");
        String fullName = sc.nextLine();
        DBUser.searchUserByName(fullName);
    }

    public static void searchUserByRegNumber(){
        Scanner sc = new Scanner(System.in);
        System.out.printf("%nPlease type the registration number of the user: ");
        String regNumber = sc.nextLine();
        DBUser.searchUserByRegNumber(regNumber);
    }

    public static void editUserByRegNumber(){
        Scanner sc = new Scanner(System.in);
        System.out.printf("%nPlease type the registration number of the user you want to edit: ");
        String regNumber = sc.nextLine();
        DBUser.editUserByRegNumber(regNumber);
    }

    public static void deleteUserByRegNumber(){
        Scanner sc = new Scanner(System.in);
        System.out.printf("%nPlease type the registration number of the user you want to delete: ");
        String regNumber = sc.nextLine();
        DBUser.deleteUserByRegNumber(regNumber);
    }

    public static void exitApp(){
        System.out.println("Log out successful. Goodbye!");
        System.exit(0);
    }
}
