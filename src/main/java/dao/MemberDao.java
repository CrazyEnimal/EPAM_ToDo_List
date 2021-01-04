package dao;

import models.Member;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class MemberDao {

    public Member findById(int id){
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Member.class, id);
    }

    public void save(Member member) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(member);
        tx1.commit();
        session.close();
    }

    public void update(Member member) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(member);
        tx1.commit();
        session.close();
    }

    public void delete(Member member) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(member);
        tx1.commit();
        session.close();
    }

    public List<Member> findAll() {
        List<Member> members = (List<Member>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Member").list();
        return members;
    }
}
