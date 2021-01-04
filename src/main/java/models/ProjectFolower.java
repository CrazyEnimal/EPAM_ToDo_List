package models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "projects_folowers")
public class ProjectFolower {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ProjectId")
    private Project project;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MemberId")
    private Member member;

    public ProjectFolower() {
    }

    public ProjectFolower(Project project, Member member) {
        this.project = project;
        this.member = member;
    }

    public int getId() {
        return id;
    }

    private Project getProject() {
        return project;
    }

    private void setProject(Project project) {
        this.project = project;
    }

    private Member getMember() {
        return member;
    }

    private void setMember(Member member) {
        this.member = member;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectFolower that = (ProjectFolower) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "ProjectFolower{" +
                "id=" + id +
                ", project=" + project.toString() +
                ", member=" + member.toString() +
                '}';
    }
}
