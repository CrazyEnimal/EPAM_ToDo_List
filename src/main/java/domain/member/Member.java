package domain.member;

import domain.team.Team;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

import static javax.persistence.GenerationType.IDENTITY;


@Entity
@Table(name = "member")
public class Member implements Serializable {
    private static final Logger LOG = LoggerFactory.getLogger(Member.class);

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "MEMBER_ID", unique = true, nullable = false)
    private int id;

    @Column(name = "USER_NAME", unique = true, nullable = false, length = 20)
    private String username;

    @Column(name = "FIRST_NAME", unique = true, nullable = false, length = 20)
    private String firstName;

    @Column(name = "LAST_NAME", unique = true, nullable = false, length = 20)
    private String lastName;

    @Column(name = "EMAIL", unique = true, nullable = false, length = 70)
    private String email;

    @Column(name = "PASSWORD", unique = true, nullable = false, length = 20)
    private String password;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "TEAM_ID", nullable = false)
    private Team team;

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Member() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return id == member.id && username.equals(member.username) && firstName.equals(member.firstName) && lastName.equals(member.lastName) && email.equals(member.email) && password.equals(member.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, firstName, lastName, email, password);
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public enum Role {
        SUPERUSER, USER, GUEST;

    }

    @Enumerated(EnumType.STRING)
    private Role role;


    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
