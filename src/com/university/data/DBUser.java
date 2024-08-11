package com.university.data;

import com.university.users.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DBUser {

    static List<Student> students = new ArrayList<>();
    static List<Secretary> secretaries = new ArrayList<>();
    static List<Administrator> administrators = new ArrayList<>();
    static List<Professor> professors = new ArrayList<>();

    static List<User> users;

    static{
        users = readUsers();

        for (User u: users) {
            if (u instanceof Student student) {
                students.add(student);
                // Generate the idNumber
                String objectId = student.getId().substring(student.getId().length() - 3);
                int idNumber = Integer.parseInt(objectId);
                if(idNumber >= Student.getIdNumber()){ // If the idNumber is greater than the current idNumber, then update the idNumber
                    Student.setIdNumber(idNumber+1);
                }
            } else if (u instanceof Secretary secretary) {
                secretaries.add(secretary);
                // Generate the idNumber
                String objectId = secretary.getId().substring(secretary.getId().length() - 3);
                int idNumber = Integer.parseInt(objectId);
                if(idNumber >= Secretary.getIdNumber()){ // If the idNumber is greater than the current idNumber, then update the idNumber
                    Secretary.setIdNumber(idNumber+1);
                }
            } else if (u instanceof Administrator administrator) {
                administrators.add(administrator);
                // Generate the idNumber
                String objectId = administrator.getId().substring(administrator.getId().length() - 3);
                int idNumber = Integer.parseInt(objectId);
                if(idNumber >= Administrator.getIdNumber()){ // If the idNumber is greater than the current idNumber, then update the idNumber
                    Administrator.setIdNumber(idNumber+1);
                }
            } else if (u instanceof Professor professor) {
                professors.add(professor);
                // Generate the idNumber
                String objectId = professor.getId().substring(professor.getId().length() - 3);
                int idNumber = Integer.parseInt(objectId);
                if(idNumber >= Professor.getIdNumber()){ // If the idNumber is greater than the current idNumber, then update the idNumber
                    Professor.setIdNumber(idNumber+1);
                }
            } else {
                System.out.println("Invalid object type!");
            }
        }
    }

    public static void viewUsers() {
        System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+--+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-");
        System.out.println("*------------------*");
        System.out.println("|Students' profile:|");
        System.out.println("*------------------*");

        for (Student student : students) {
            System.out.println(student.toString());
        }
        System.out.println("*---------------------*");
        System.out.println("|Secretaries' profile:|");
        System.out.println("*---------------------*");
        for (Secretary secretary : secretaries) {
            System.out.println(secretary.toString());
        }
        System.out.println("*------------------------*");
        System.out.println("|Administrators' profile:|");
        System.out.println("*------------------------*");
        for (Administrator administrator : administrators) {
            System.out.println(administrator.toString());
        }
        System.out.println("*--------------------*");
        System.out.println("|Professors' profile:|");
        System.out.println("*--------------------*");
        for (Professor professor : professors) {
            System.out.println(professor.toString());
        }
        System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+--+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-");
    }

    private static List<User> readUsers(){
        List<User> users = new ArrayList<>();
        try (FileInputStream fileInputStream = new FileInputStream("users.ser");
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            while (fileInputStream.available() > 0) {
                Object object = objectInputStream.readObject();
                users = (List<User>) object;
            }
            System.out.printf("%nUsers' profile loaded successfully!%n");
        } catch (FileNotFoundException e) {
            System.out.printf("There are no saved user profiles.%n%n");
        } catch (ClassNotFoundException | IOException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    public static void createUser(String role) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please fill the following fields:");
        System.out.println("------------------------------");
        System.out.print("Full Name: ");
        String fullName = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();

        switch (role) {
            case "Student" -> {
                System.out.print("Year of enrollment: ");
                int yearOfEnrollment = sc.nextInt();
                sc.nextLine();
                Student student = new Student(fullName, email, yearOfEnrollment);
                System.out.printf("%nStudent created successfully!%n");
                System.out.printf("Student's ID: %s%n%n", student.getId());
                saveUser(student);
            }
            case "Secretary" -> {
                System.out.print("Department: ");
                String department = sc.nextLine();
                Secretary secretary = new Secretary(fullName, email, department);
                System.out.printf("%nSecretary created successfully!%n");
                System.out.printf("Secretary's ID: %s%n%n", secretary.getId());
                saveUser(secretary);
            }
            case "Administrator" -> {
                Administrator administrator = new Administrator(fullName, email);
                System.out.printf("%nAdministrator created successfully!%n");
                System.out.printf("Administrator's ID: %s%n%n", administrator.getId());
                saveUser(administrator);
            }
            case "Professor" -> {
                System.out.print("Year of hire: ");
                int yearOfHire = sc.nextInt();
                sc.nextLine();
                Professor professor = new Professor(fullName, email, yearOfHire);
                System.out.printf("%nProfessor created successfully!%n");
                System.out.printf("Professor's ID: %s%n%n", professor.getId());
                saveUser(professor);
            }
            default -> System.out.println("Invalid role specified!");
        }
    }

    private static void saveUser(User user) {
            if (user instanceof Student student) {
                students.add(student);
            } else if (user instanceof Secretary secretary) {
                secretaries.add(secretary);
            } else if (user instanceof Administrator administrator) {
                administrators.add(administrator);
            } else if (user instanceof Professor professor) {
                professors.add(professor);
            } else {
                System.out.println("Invalid object type!");
            }

        users = new ArrayList<>(); //clear the list

        users.addAll(students);
        users.addAll(secretaries);
        users.addAll(administrators);
        users.addAll(professors);

        try (FileOutputStream fileOutputStream = new FileOutputStream("users.ser", false); //false to overwrite the file
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(users);
            System.out.printf("%s saved successfully!%n%n", user.getId());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void searchUserByName(String fullName) {
        System.out.println("Searching all profiles... Please wait!");
        boolean found = false;
        for (User user : users) {
            if (user.getFullName().equalsIgnoreCase(fullName)) {
                System.out.println("User found!");
                System.out.println(user);
                System.out.println();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("User not found!");
            System.out.println();
        }
    }
    public static void searchUserByRegNumber(String regNumber) {
        System.out.println("Searching all profiles... Please wait!");
        boolean found = false;
        for (User user : users) {
            if (user.getId().equalsIgnoreCase(regNumber)) {
                System.out.println("User found!");
                System.out.println(user);
                System.out.println();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("User not found!");
            System.out.println();
        }
    }

    public static void editUserByRegNumber(String regNumber) {
        System.out.println("Searching all profiles... Please wait!");
        boolean found = false;
        for (User user : users) {
            if (user.getId().equalsIgnoreCase(regNumber)) {
                System.out.println("User found!");
                System.out.println();
                found = true;
                editUser(user);
                break;
            }
        }
        if (!found) {
            System.out.println("User not found!");
            System.out.println();
        }
    }

    private static void editUser(User user) {
        Scanner sc = new Scanner(System.in);
        int field = 0;
        do {
            System.out.println("What do you want to edit?");
            System.out.printf("1. Full Name: %s%n", user.getFullName());
            System.out.printf("2. Email: %s%n", user.getEmail());
            switch (user.getRole()) {
                case "Student" -> System.out.printf("3. Year of enrollment: %d%n", ((Student) user).getYearOfEnrollment());
                case "Secretary" -> System.out.printf("3. Department: %s%n", ((Secretary) user).getDepartment());
                case "Professor" -> System.out.printf("3. Year of hire: %s%n", ((Professor) user).getYearOfHire());
            }
            System.out.printf("%n-*-To leave the edit screen, type 0 -*-");
            System.out.printf("%nPlease select the field you want to edit: ");
            field = sc.nextInt();
            sc.nextLine();
            switch (field) {
                case 0 -> System.out.printf("%n%n--*--Edit screen closed!--*--%n%n");
                case 1 -> {
                    System.out.print("New Full Name: ");
                    String newFullName = sc.nextLine();
                    user.setFullName(newFullName);
                    System.out.printf("%nFull Name updated successfully!%n%n");
                }
                case 2 -> {
                    System.out.print("New Email: ");
                    String newEmail = sc.nextLine();
                    user.setEmail(newEmail);
                    System.out.printf("%nEmail updated successfully!%n%n");
                }
                case 3 -> {
                    switch (user.getRole()) {
                        case "Student" -> {
                            System.out.print("New Year of enrollment: ");
                            int newYearOfEnrollment = sc.nextInt();
                            sc.nextLine();
                            ((Student) user).setYearOfEnrollment(newYearOfEnrollment);
                            System.out.printf("%nYear of enrollment updated successfully!%n%n");
                        }
                        case "Secretary" -> {
                            System.out.print("New Department: ");
                            String newDepartment = sc.nextLine();
                            ((Secretary) user).setDepartment(newDepartment);
                            System.out.printf("%nDepartment updated successfully!%n%n");
                        }
                        case "Professor" -> {
                            System.out.print("New Year of Hire: ");
                            int yearOfHire = sc.nextInt();
                            sc.nextLine();
                            ((Professor) user).setYearOfHire(yearOfHire);
                            System.out.printf("%nDepartment updated successfully!%n%n");
                        }
                    }
                }
                default -> System.out.println("Invalid field selected!");
            }
            saveUser(user);
        }
        while (field != 0);
    }

    public static void deleteUserByRegNumber(String regNumber) {
        System.out.println("Searching all profiles... Please wait!");
        boolean found = false;
        for (User user : users) {
            if (user.getId().equalsIgnoreCase(regNumber)) {
                System.out.println("User found!");
                System.out.println(user);
                System.out.println();
                found = true;
                Scanner sc = new Scanner(System.in);
                System.out.println("Are you sure you want to delete this user? (Y/N)");
                String answer = sc.nextLine();
                if (answer.equalsIgnoreCase("Y")) {
                    deleteUser(user);
                    System.out.println();
                } else {
                    System.out.println("User not deleted!");
                    System.out.println();
                }
                break;
            }
        }
        if (!found) {
            System.out.println("User not found!");
            System.out.println();
        }
    }

    private static void deleteUser(User user) {
        if (user instanceof Student student) {
            students.remove(student);
        } else if (user instanceof Secretary secretary) {
            secretaries.remove(secretary);
        } else if (user instanceof Administrator administrator) {
            administrators.remove(administrator);
        } else if (user instanceof Professor professor) {
            professors.remove(professor);
        } else {
            System.out.println("Invalid object type!");
        }
        users = new ArrayList<>(); //clear the list

        users.addAll(students);
        users.addAll(secretaries);
        users.addAll(administrators);
        users.addAll(professors);

        try (FileOutputStream fileOutputStream = new FileOutputStream("users.ser", false); //false to overwrite the file
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(users);
            System.out.printf("%s deleted successfully!%n", user.getId());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
