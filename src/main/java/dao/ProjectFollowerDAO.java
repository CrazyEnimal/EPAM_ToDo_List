package dao;

import models.ProjectFollower;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class ProjectFollowerDAO {

    public ProjectFollower findById(int id){
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(ProjectFollower.class, id);
    }

    public void save(ProjectFollower projectFollower) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(projectFollower);
        tx1.commit();
        session.close();
    }

    public void update(ProjectFollower projectFollower) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(projectFollower);
        tx1.commit();
        session.close();
    }

    public void delete(ProjectFollower projectFollower) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(projectFollower);
        tx1.commit();
        session.close();
    }

    public List<ProjectFollower> findAll() {
        List<ProjectFollower> projectFollowers = (List<ProjectFollower>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From ProjectFollower").list();
        return projectFollowers;
    }
}
