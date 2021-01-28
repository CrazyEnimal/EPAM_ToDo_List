package domain.team;

import domain.member.Member;
import domain.project.Project;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "member")
public class Team implements Serializable {
    private static final Logger logger = LogManager.getLogger();


    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "TEAM_ID", unique = true, nullable = false)
    private int id;

    @Column(name = "TITLE", unique = true, nullable = false, length = 20)
    private String title;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "team")
    private Set<Member> members = new HashSet<>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "team")
    private Set<Project> projects = new HashSet<>();

    public Team() {
    }

    public void addMember(Member member) {
        members.add(member);
        member.setTeam(this);
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

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", members=" + members +
                ", projects=" + projects +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return id == team.id && title.equals(team.title) && members.equals(team.members) && projects.equals(team.projects);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, members, projects);
    }
}
