package org.etd.up.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tasks_messages")
public class TaskMessage implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "task_id", unique = true)
    private Task task;

    @Id
    @ManyToOne
    @JoinColumn(name = "message_id", unique = true)
    private Message message;

    public TaskMessage() {
    }

    public TaskMessage(Task task, Message message) {
        this.task = task;
        this.message = message;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskMessage that = (TaskMessage) o;
        return Objects.equals(task, that.task) && Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(task, message);
    }

    @Override
    public String toString() {
        return "TaskMessage{" +
                ", task=" + task.toString() +
                ", message=" + message.toString() +
                '}';
    }
}

