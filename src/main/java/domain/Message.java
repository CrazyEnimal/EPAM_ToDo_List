package domain;

import java.time.Instant;

public class Message {

    //Определить способ присвоения уникального ID для каждого инстанса Message
    private static int currentMessageID;

    private final int messageID;
    private final int creatorID;
    private final Instant date;
    private final MessageTypeInterface messageType;

    public Message(int creatorID, Instant date, MessageTypeInterface messageType) {

        this.messageID = currentMessageID;
        currentMessageID += 1;
        this.creatorID = creatorID;
        this.date = date;
        this.messageType = messageType;
    }

    public int getMessageID() {
        return this.messageID;
    }

    public int getCreatorID() {
        return this.creatorID;
    }

    public Instant getDate() {
        return this.date;
    }

}
