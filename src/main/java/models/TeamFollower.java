package models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "teams_followers")
public class TeamFollower {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team team;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    public TeamFollower() {
    }

    public TeamFollower(Team team, Member member) {
        this.team = team;
        this.member = member;
    }

    public int getId() {
        return id;
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
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "TeamFollower{" +
                "id=" + id +
                ", team=" + team.toString() +
                ", member=" + member.toString() +
                '}';
    }
}
