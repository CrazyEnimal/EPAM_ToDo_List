package org.etd.up.repo;

import org.etd.up.models.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Integer> {
    Member findMemberByUserName(String userName);
    Member findById(int id);
}
