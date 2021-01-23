package domain.task;

import domain.member.Member;
import domain.message.Message;
import domain.project.Project;
import domain.status.Status;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author Georgiy Minasian
 */
@Entity
@Table(name = "tasks")
public class Task {
    public static Logger logger = LogManager.getLogger();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title", unique = true, nullable = false, length = 280)
    private String title;

    @Column(name = "is_complete", nullable = false)
    private boolean isComplete = false;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "creatorId", nullable = false)
    private Member creator;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "statusId", nullable = false)
    private Status status;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "executorId", nullable = false)
    private Member executor; //no executor in database

    @Column(name = "description", nullable = false)
    private String description = "";

    @Enumerated(EnumType.STRING)
    @Column(name = "priority", nullable = false)
    private Priority priority = Priority.NORMAL; //no priority in database

    @Column(name = "project", unique = true, nullable = false, length = 20)
    private Project project;

    @OneToOne(fetch = FetchType.LAZY)
    @Column(name = "followers", unique = true, nullable = false, length = 20)
    private Member[] followers;

    @OneToOne(fetch = FetchType.LAZY)
    @Column(name = "messages", unique = true, nullable = false, length = 20)
    private Message[] messages;

    public Task() {
        logger.info("task created by default constructor");
    }

    public Task(String title, String description, Priority priority, Project project) {
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.project = project;
        logger.info("task created by parametrized constructor with: \n"
                + "title: " + title + "\n"
                + "description: " + description + "\n"
                + "priority: " + priority + "\n"
                + "status: " + status.getTitle()
                );
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void setComplete(boolean complete) {
        isComplete = complete;
    }

    public Member getCreator() {
        return creator;
    }

    public void setCreator(Member creator) {
        this.creator = creator;
    }

    public Member getExecutor() {
        return executor;
    }

    public void setExecutor(Member executor) {
        this.executor = executor;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Member[] getFollowers() {
        return followers;
    }

    public void setFollowers(Member[] followers) {
        this.followers = followers;
    }

    public Message[] getMessages() {
        return messages;
    }

    public void setMessages(Message[] messages) {
        this.messages = messages;
    }

    //todo: followers, event and messages setters and getters

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id &&
                isComplete == task.isComplete &&
                title.equals(task.title) &&
                creator.equals(task.creator) &&
                executor.equals(task.executor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, id, isComplete, creator, executor);
    }

    @Override
    public String toString() {
        return "title: " + title + ", " + "\n" +
                "id: " + id + ", " + "\n" +
                "isComplete: " + isComplete + ", " + "\n" +
                "creator: " + creator + ", " + "\n" +
                "executor: " + executor + ", " + "\n" +
                "status id: " + status.getId() + "\n";
    }
}
