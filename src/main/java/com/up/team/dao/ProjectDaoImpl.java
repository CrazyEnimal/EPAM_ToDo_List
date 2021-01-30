package com.up.team.dao;

import com.up.team.HibernateSessionFactoryUtil;
import com.up.team.entity.Project;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;

@Repository
public class ProjectDaoImpl implements DAO<Project, Integer> {

    public ProjectDaoImpl() {

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
