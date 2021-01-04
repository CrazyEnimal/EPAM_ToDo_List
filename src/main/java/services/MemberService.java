package services;

import dao.MemberDao;
import models.Member;

import java.util.List;

public class MemberService {

    private MemberDao memberDao = new MemberDao();

    public MemberService() {
    }

    public Member findMember(int id) {
        return memberDao.findById(id);
    }

    public void saveMember(Member member){
        memberDao.save(member);
    }

    public void updateMember(Member member){
        memberDao.update(member);
    }

    public void deleteMember(Member member){
        memberDao.delete(member);
    }

    public List<Member> findAllMembers() {
        return memberDao.findAll();
    }
}
