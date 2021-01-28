package models;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "teams")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "creator_id")
    private Member creator;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "supervisor_id")
    private Member supervisor;

    @Column(name = "title")
    private String title;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name="teams_followers",
            joinColumns = @JoinColumn(name="team_id"),
            inverseJoinColumns = @JoinColumn(name="member_id"))
    private List<Member> teamFollowers;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name="teams_projects",
            joinColumns = @JoinColumn(name="team_id"),
            inverseJoinColumns = @JoinColumn(name="project_id"))
    private List<Project> teamProjects;

    public Team() {
    }

    public int getId() {
        return id;
    }

    public Member getCreator() {
        return creator;
    }

    public void setCreator(Member creator) {
        this.creator = creator;
    }

    public Member getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Member supervisor) {
        this.supervisor = supervisor;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return id == team.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", creator=" + creator +
                ", supervisor=" + supervisor +
                ", title='" + title + '\'' +
                ", teamFollowers=" + teamFollowers +
                ", teamProjects=" + teamProjects +
                '}';
    }
}
