package domain;

import java.io.Serializable;
import java.util.Set;


public class Project implements Serializable {

    private int id;
    private Member creator;
    private String title;
    private Member supervisor;
    private Set<Member> members;
    private Set<Task> tasks;

    public Project() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Member getCreator() {
        return creator;
    }

    public void setCreator(Member creator) {
        this.creator = creator;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Member getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Member supervisor) {
        this.supervisor = supervisor;
    }

    public Set<Member> getMembers() {
        return members;
    }

    public void setMembers(Set<Member> members) {
        this.members = members;
    }

    public Set<Task> getTasks() {
        return tasks;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }
}
