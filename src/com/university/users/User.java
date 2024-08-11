package com.university.users;

import java.io.Serializable;

public class User implements UserInterface, Serializable {
    private String id;
    private String fullName;
    private final String role; // to be removed
    private String email;

    public User(String role, String id, String fullName, String email) {
        this.role = role;
        this.id = id;
        this.fullName = fullName;
        this.email = email;
    }
    @Override
    public String getId() {
        return id;
    }
    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getFullName() {
        return fullName;
    }

    @Override
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String getRole() {
        return role;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return  "Full Name ='" + fullName + '\'' +
                ", ID ='" + id + '\'' +
                ", Email ='" + email + '\'';
    }
}
