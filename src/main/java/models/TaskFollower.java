package models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tasks_followers")
public class TaskFollower {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TaskId")
    private Task task;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MemberId")
    private Member member;

    public TaskFollower() {
    }

    public TaskFollower(Task task, Member member) {
        this.task = task;
        this.member = member;
    }

    public int getId() {
        return id;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskFollower that = (TaskFollower) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "TaskFollower{" +
                "id=" + id +
                ", task=" + task.toString() +
                ", member=" + member.toString() +
                '}';
    }
}
