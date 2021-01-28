package com.up.team.entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name="projects")
public class Project implements Serializable {
    private static final Logger LOG = LoggerFactory.getLogger(Project.class);

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @OneToOne
    @JoinColumn(name = "creator_id")
    private Member creator;


    @Column(name = "title", unique = true, nullable = false, length = 20)
    private String title;

    @OneToOne
    @JoinColumn(name = "supervisor_id")
    private Member supervisor;

/*
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "team")
    private Set<Member> members = new HashSet<>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "team")
    private Set<Task> tasks = new HashSet<>();

 */
/*
    public void addTask(Task task) {
        tasks.add(task);
        task.setProject(this);

    }

 */

/*
    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

 */
/*
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "TEAM_ID", nullable = false)
    private Team team;

 */

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
/*
    public Member getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Member supervisor) {
        this.supervisor = supervisor;
    }

 */
/*
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

 */

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", creator=" + creator +
                ", title='" + title + '\'' +
                ", supervisor=" + supervisor +
              //  ", members=" + members +
              //  ", tasks=" + tasks +
                '}';
    }
/*
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return id == project.id && creator.equals(project.creator) && title.equals(project.title) && supervisor.equals(project.supervisor) && members.equals(project.members) && tasks.equals(project.tasks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, creator, title, supervisor, members, tasks);
    }

 */
}
