package com.up.team.service;

import com.up.team.entity.Member;

public interface MemberService {

    void create(Member member);

    void update(Member member);

    void delete(Member member);

    Member read(int id);
}
