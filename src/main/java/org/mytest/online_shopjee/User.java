package org.mytest.online_shopjee;

public class User {
    private int userID;
    private String username;
    private String password;
    private String name;
    private String firstName;
    private String email;
    private String picture;

    // Constructor
    public User(int userID, String username, String password, String name, String firstName, String email, String picture) {
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.name = name;
        this.firstName = firstName;
        this.email = email;
        this.picture = picture;
    }

    // Getters and setters
    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPicture() {
        return picture;
    }
    public void setPicture(String picture) {
        this.picture = picture;
    }
}

