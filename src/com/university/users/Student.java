package com.university.users;

public class Student extends User{
    private int yearOfEnrollment;
    private static int idNumber = 0;
    public int getYearOfEnrollment() {
        return yearOfEnrollment;
    }

    public void setYearOfEnrollment(int yearOfEnrollment) {
        this.yearOfEnrollment = yearOfEnrollment;
    }

    public static int getIdNumber() {
        return idNumber;
    }

    public static void setIdNumber(int idNumber) {
        Student.idNumber = idNumber;
    }
    public Student(String fullName, String email, int yearOfEnrollment) {
        super("Student", "S%d".formatted(22000 + idNumber), fullName, email);
        this.yearOfEnrollment = yearOfEnrollment;
        idNumber++;
    }

    @Override
    public String toString() {
        return "Role ='" + getRole() + "', " +
                super.toString() + '\'' +
                ", Year of enrollment ='" + yearOfEnrollment + '\'';
    }
}
