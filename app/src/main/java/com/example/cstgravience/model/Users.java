package com.example.cstgravience.model;

public class Users {
    String email, ID;

    public Users(String email, String ID){
        this.email = email;
        this.ID = ID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
}
