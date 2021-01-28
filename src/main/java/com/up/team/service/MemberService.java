package com.up.team.service;

import com.up.team.dao.DAO;
import com.up.team.dao.MemberDao;
import com.up.team.entity.Member;


public class MemberService {
    private final DAO<Member, Integer> memberDAO = new MemberDao();

    public MemberService() {

    }

    public void create(Member member) {
        memberDAO.create(member);
    }

    public void update(Member member) {
        memberDAO.update(member);
    }

    public void delete(Member member) {
        memberDAO.delete(member);
    }

    public final Member read(int id) {
        return memberDAO.read(id);
    }
}
