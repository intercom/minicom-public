package com.intercom.spring.models;


import java.sql.Timestamp;


public class User {


    private long id;
    private String email;
    private Timestamp createdAt, updatedAt;


    public User() {}


    public long getId() {
        return this.id;
    }


    public void setId(long id) {
        this.id = id;
    }


    public String getEmail() {
        return this.email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public Timestamp getCreatedAt() {
        return this.createdAt;
    }


    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }


    public Timestamp getUpdatedAt() {
        return this.updatedAt;
    }


    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }


    public User id(long id) {
        this.id = id;
        return this;
    }


    public User email(String email) {
        this.email = email;
        return this;
    }


    public User createdAt(Timestamp createdAt) {
        this.createdAt = createdAt;
        return this;
    }


    public User updatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }


    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", email='" + getEmail() + "'" +
                ", createdAt='" + getCreatedAt() + "'" +
                ", updatedAt='" + getUpdatedAt() + "'" +
                "}";
    }
}