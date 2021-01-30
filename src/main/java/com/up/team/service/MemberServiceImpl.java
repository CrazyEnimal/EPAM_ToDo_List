package com.up.team.service;

import com.up.team.dao.DAO;
import com.up.team.dao.MemberDaoImpl;
import com.up.team.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private DAO<Member, Integer> memberDAO;

    public MemberServiceImpl() {

    }

    @Override
    public void create(Member member) {
        memberDAO.create(member);
    }

    @Override
    public void update(Member member) {
        memberDAO.update(member);
    }

    @Override
    public void delete(Member member) {
        memberDAO.delete(member);
    }

    @Override
    public final Member read(int id) {
        return memberDAO.read(id);
    }
}
