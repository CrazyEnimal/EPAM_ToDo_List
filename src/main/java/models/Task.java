package models;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @ManyToOne
    @JoinColumn(name="creator_id")
    private Member creator;

    @ManyToOne
    @JoinColumn(name="executor_id")
    private Member executor;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "is_complete")
    private boolean isComplete;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name="tasks_followers",
            joinColumns = @JoinColumn(name="task_id"),
            inverseJoinColumns = @JoinColumn(name="member_id"))
    private List<Member> taskFollowers;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name="tasks_messages",
            joinColumns = @JoinColumn(name="task_id"),
            inverseJoinColumns = @JoinColumn(name="message_id"))
    private List<Message> taskMessages;

    public Task() {
    }

    public Task(Member creator, String title) {
        this.creator = creator;
        this.title = title;
    }

    public Member getCreator() {
        return creator;
    }

    public Status getStatus() {
        return status;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public List<Member> getTaskFollowers() {
        return taskFollowers;
    }

    public List<Message> getTaskMessages() {
        return taskMessages;
    }

    public void setCreator(Member creator) {
        this.creator = creator;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setComplete(boolean complete) {
        isComplete = complete;
    }

    public boolean addFollower(Member member){
        return this.taskFollowers.add(member);
    }

    public boolean addMessage(Message message){
        return this.taskMessages.add(message);
    }

    public boolean removeFollower(Member member){
        return this.taskFollowers.remove(member);
    }

    public boolean removeMessage(Message message){
        return this.taskMessages.remove(message);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", creator=" + creator +
                ", status=" + status +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", isComplete=" + isComplete +
                ", taskFollowers=" + taskFollowers +
                ", taskMessages=" + taskMessages +
                '}';
    }
}
