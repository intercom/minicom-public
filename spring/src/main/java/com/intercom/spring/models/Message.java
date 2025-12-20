package com.intercom.spring.models;


import java.sql.Timestamp;


public class Message {
    private long id, user_id;
    private Boolean message_read;
    private String content;
    private Timestamp createdAt, updatedAt;




    public Message() {}


    public long getId() {
        return this.id;
    }


    public void setId(long id) {
        this.id = id;
    }


    public long getUser_id() {
        return this.user_id;
    }


    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }


    public Boolean isMessageRead() {
        return this.message_read;
    }


    public Boolean getMessageRead() {
        return this.message_read;
    }


    public void setMessageRead(Boolean read) {
        this.message_read = read;
    }


    public String getContent() {
        return this.content;
    }


    public void setContent(String content) {
        this.content = content;
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


    public Message id(long id) {
        this.id = id;
        return this;
    }


    public Message user_id(long user_id) {
        this.user_id = user_id;
        return this;
    }


    public Message message_read(Boolean read) {
        this.message_read = read;
        return this;
    }


    public Message content(String content) {
        this.content = content;
        return this;
    }


    public Message createdAt(Timestamp createdAt) {
        this.createdAt = createdAt;
        return this;
    }


    public Message updatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }


    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", user_id='" + getUser_id() + "'" +
                ", message_read='" + isMessageRead() + "'" +
                ", content='" + getContent() + "'" +
                ", createdAt='" + getCreatedAt() + "'" +
                ", updatedAt='" + getUpdatedAt() + "'" +
                "}";
    }
}