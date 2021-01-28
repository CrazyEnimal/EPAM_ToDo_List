package models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "projects_followers")
public class ProjectFollower {

    @Id
    @ManyToOne
    @JoinColumn(name = "project_id", unique = true)
    private Project project;

    @Id
    @ManyToOne
    @JoinColumn(name = "member_id", unique = true)
    private Member member;

    public ProjectFollower() {
    }

    public ProjectFollower(Project project, Member member) {
        this.project = project;
        this.member = member;
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
        return Objects.equals(project, that.project) && Objects.equals(member, that.member);
    }

    @Override
    public int hashCode() {
        return Objects.hash(project, member);
    }

    @Override
    public String toString() {
        return "ProjectFollower{" +
                ", project=" + project.toString() +
                ", member=" + member.toString() +
                '}';
    }
}
