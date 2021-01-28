package com.up.team.dao;

import com.up.team.HibernateSessionFactoryUtil;
import com.up.team.entity.Project;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.validation.constraints.NotNull;


public class ProjectDao implements DAO<Project, Integer> {

    public ProjectDao() {

    }

    @Override
    public void create(@NotNull final Project project) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(project);
        tx.commit();
        session.close();
    }

    @Override
    public Project read(@NotNull final Integer id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Project.class, id);
    }

    @Override
    public void update(@NotNull final Project project) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.update(project);
        tx.commit();
        session.close();
    }

    @Override
    public void delete(@NotNull final Project project) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.delete(project);
        tx.commit();
        session.close();
    }
}
