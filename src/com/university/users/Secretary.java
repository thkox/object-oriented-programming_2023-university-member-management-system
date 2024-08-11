package com.university.users;

public class Secretary extends User{
    private String department;
    private static int idNumber = 0;

    public Secretary(String fullName, String email, String department) {
        super("Secretary", "E%d".formatted(22000 + idNumber), fullName, email);
        this.department = department;
        idNumber++;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public static int getIdNumber() {
        return idNumber;
    }

    public static void setIdNumber(int idNumber) {
        Secretary.idNumber = idNumber;
    }

    @Override
    public String toString() {
        return "Role ='" + getRole() + "', " +
                super.toString() + '\'' +
                ", Department ='" + department + '\'';
    }
}
