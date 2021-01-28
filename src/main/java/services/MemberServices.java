package services;

import dao.MemberDAO;
import models.Member;

import java.util.List;

public class MemberServices {

    private MemberDAO memberDao = new MemberDAO();

    public MemberServices() {
    }

    public Member find(int id) {
        return memberDao.findById(id);
    }

    public void save(Member member){
        memberDao.save(member);
    }

    public void update(Member member){
        memberDao.update(member);
    }

    public void delete(Member member){
        memberDao.delete(member);
    }

    public List<Member> findAll() {
        return memberDao.findAll();
    }
}
