package domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


public class Team implements Serializable {
    private int id;

    private String title;
    private Set<Member> members = new HashSet<>();
    private Set<Project> projects = new HashSet<>();

    public Team() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public Set<Member> getMembers() {
        return members;
    }

    public void setMembers(Set<Member> members) {
        this.members = members;
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }
}
