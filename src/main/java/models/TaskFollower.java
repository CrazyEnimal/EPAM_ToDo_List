package models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tasks_followers")
public class TaskFollower implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "task_id", unique = true)
    private Task task;

    @Id
    @ManyToOne
    @JoinColumn(name = "member_id", unique = true)
    private Member member;

    public TaskFollower() {
    }

    public TaskFollower(Task task, Member member) {
        this.task = task;
        this.member = member;
    }

//    public int getId() {
//        return id;
//    }

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
        return Objects.equals(task, that.task) && Objects.equals(member, that.member);
    }

    @Override
    public int hashCode() {
        return Objects.hash(task, member);
    }
}
