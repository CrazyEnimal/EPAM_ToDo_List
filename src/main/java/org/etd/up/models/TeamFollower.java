package org.etd.up.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "teams_followers")
public class TeamFollower implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    @Id
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    public TeamFollower() {
    }

    public TeamFollower(Team team, Member member) {
        this.team = team;
        this.member = member;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
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
        TeamFollower that = (TeamFollower) o;
        return Objects.equals(team, that.team) && Objects.equals(member, that.member);
    }

    @Override
    public int hashCode() {
        return Objects.hash(team, member);
    }

    @Override
    public String toString() {
        return "TeamFollower{" +
                ", team=" + team.toString() +
                ", member=" + member.toString() +
                '}';
    }
}

