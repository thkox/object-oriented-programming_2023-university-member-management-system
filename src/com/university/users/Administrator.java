package com.university.users;

public class Administrator extends User {
    private static int idNumber = 0;

    public Administrator(String fullName, String email) {
        super("Administrator", "A%d".formatted(22000 + idNumber), fullName, email);
        idNumber++;
    }

    public static int getIdNumber() {
        return idNumber;
    }

    public static void setIdNumber(int idNumber) {
        Administrator.idNumber = idNumber;
    }

    @Override
    public String toString() {
        return "Role ='" + getRole() + "', " +
                super.toString();
    }
}
