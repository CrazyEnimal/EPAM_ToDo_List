package org.etd.up.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "teams_projects")
public class TeamProject implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    @Id
    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    public TeamProject() {
    }

    public TeamProject(Team team, Project project) {
        this.team = team;
        this.project = project;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeamProject that = (TeamProject) o;
        return Objects.equals(team, that.team) && Objects.equals(project, that.project);
    }

    @Override
    public int hashCode() {
        return Objects.hash(team, project);
    }

    @Override
    public String toString() {
        return "TeamProject{" +
                ", team=" + team.toString() +
                ", project=" + project.toString() +
                '}';
    }
}
