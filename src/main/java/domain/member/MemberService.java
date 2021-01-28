package domain.member;

import domain.DAO;

public class MemberService {
    private final DAO<Member, Integer> memberDAO = new MemberDAO();

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
