package com.up.team.dao;

import com.up.team.HibernateSessionFactoryUtil;
import com.up.team.entity.Member;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.validation.constraints.NotNull;

public class MemberDao implements DAO<Member, Integer> {

    public MemberDao() {

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
