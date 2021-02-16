package org.etd.up.repo;

import org.etd.up.models.Member;
import org.etd.up.models.Team;
import org.etd.up.models.TeamFollower;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface TeamRepository extends JpaRepository<Team, Integer> {
    Collection<TeamFollower> findAllByTeamFollowers(Member member);
    Team findById(int id);
    List<Team> findTeamsByTeamFollowers(Member member);
}
