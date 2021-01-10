package models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "projects_followers")
public class ProjectFollower {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    private Project project;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    public ProjectFollower() {
    }

    public ProjectFollower(Project project, Member member) {
        this.project = project;
        this.member = member;
    }

    public int getId() {
        return id;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
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
        ProjectFollower that = (ProjectFollower) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "ProjectFollower{" +
                "id=" + id +
                ", project=" + project.toString() +
                ", member=" + member.toString() +
                '}';
    }
}
