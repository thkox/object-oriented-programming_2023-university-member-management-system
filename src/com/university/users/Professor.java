package com.university.users;

public class Professor extends User{
    private int yearOfHire;

    private static int idNumber = 0;

    public Professor(String fullName, String email, int yearOfHire) {
        super("Professor", "P%d".formatted(22000 + idNumber), fullName, email);
        this.yearOfHire = yearOfHire;
        idNumber++;
    }

    public int getYearOfHire() {
        return yearOfHire;
    }

    public void setYearOfHire(int yearOfHire) {
        this.yearOfHire = yearOfHire;
    }

    public static int getIdNumber() {
        return idNumber;
    }

    public static void setIdNumber(int idNumber) {
        Professor.idNumber = idNumber;
    }

    @Override
    public String toString() {
        return "Role ='" + this.getRole() + "', " +
                super.toString() + '\'' +
                ", Year of Hire =" + yearOfHire + '\'';
    }
}


