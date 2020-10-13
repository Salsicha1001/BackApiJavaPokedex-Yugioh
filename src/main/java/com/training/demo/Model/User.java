package com.training.demo.Model;

import java.util.Map;

public class User  {
    private String uid;
    private String firstName;
    private String lastName;
    private long cpf;
    private String birthday;
    private String email;
    private String password;
    private String type;

    public User() {
    }


    public User(String uid,String firstName, String lastName, long cpf, String birthday, String email, String password, String type) {
        this.uid = uid;
        this.firstName = firstName;
        this.lastName = lastName;
        this.cpf = cpf;
        this.birthday = birthday;
        this.email = email;
        this.password = password;
        this.type = type;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
