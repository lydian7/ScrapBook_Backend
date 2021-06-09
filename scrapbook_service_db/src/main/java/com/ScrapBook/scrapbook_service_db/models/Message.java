package com.ScrapBook.scrapbook_service_db.models;

import javax.persistence.*;

@Entity
@Table(name = "messages")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "senders")
    private String sender;

    @Column(name = "timeStamp")
    private String timeStamp;

    @Column(name = "message")
    private String message;

    public Message(String sender, String timeStamp, String message) {
        this.sender = sender;
        this.timeStamp = timeStamp;
        this.message = message;
    }

    public Message() {
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
