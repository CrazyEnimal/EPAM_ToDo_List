package domain.member;

import domain.DAO;
import domain.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jetbrains.annotations.NotNull;

public class MemberDAO implements DAO<Member, Integer> {

    public MemberDAO() {

    }

    @Override
    public void create(@NotNull final Member member) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(member);
        tx.commit();
        session.close();
    }

    @Override
    public Member read(@NotNull final Integer id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Member.class, id);
    }

    @Override
    public void update(@NotNull final Member member) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.update(member);
        tx.commit();
        session.close();
    }

    @Override
    public void delete(@NotNull final Member member) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.delete(member);
        tx.commit();
        session.close();
    }
}
