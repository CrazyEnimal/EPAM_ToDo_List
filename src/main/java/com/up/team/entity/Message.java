package com.up.team.entity;

import javax.persistence.*;
import java.time.Instant;
import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Entity
@Table(name = "messages")
public class Message {

    public static Logger logger = LogManager.getLogger();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int messageID;

    // private int messageCreatorID;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "creator_id")
    // Shouldnt we put member's ID here instead of the whole Member instance?
    private Member messageCreatorMember;

    @Column(name = "date")
    private Instant date = Instant.now();

    @Column(name = "type")
    private String messageType;

    @Column(name = "text")
    private String messageText;

    public Message(Member messageCreatorMember, String messageText) {

        this.messageCreatorMember = messageCreatorMember;
        this.messageText = messageText;

        logger.info("Message created with:\n" +
                "id: " + this.messageID +
                "Creator: " + this.messageCreatorMember.toString() +
                "Date: " + this.date +
                "Text: " + messageText);

//        this.messageType = messageType;
    }
    public Message() {
    }

    public int getMessageID() {
        return this.messageID;
    }

//    public int getMessageCreatorID() {
//        return this.messageCreatorID;
//    }
//
//    public void setMessageCreatorID(int messageCreatorID) {
//        this.messageCreatorID = messageCreatorID;
//    }

    public Member getMessageCreatorMember() {
        return this.messageCreatorMember;
    }
    public void setMessageCreatorMember(Member messageCreatorMember) {
        this.messageCreatorMember = messageCreatorMember;
    }

    public Instant getDate() {
        return this.date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public String getMessageText() {
        return this.messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public String getMessageType() {
        return this.messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return messageID == message.messageID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(messageID);
    }

    @Override
    public String toString() {
        return "Author: " + this.messageCreatorMember.getUsername() + " " +
               "Date: " + this.date.toString() + " " +
               "Type: " + this.messageType + "\n" +
               "Message: " + this.messageText;
    }
}
