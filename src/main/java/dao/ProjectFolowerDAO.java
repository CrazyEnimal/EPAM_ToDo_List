package dao;

import models.ProjectFolower;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class ProjectFolowerDAO {

    public ProjectFolower findById(int id){
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(ProjectFolower.class, id);
    }

    public void save(ProjectFolower projectFolower) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(projectFolower);
        tx1.commit();
        session.close();
    }

    public void update(ProjectFolower projectFolower) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(projectFolower);
        tx1.commit();
        session.close();
    }

    public void delete(ProjectFolower projectFolower) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(projectFolower);
        tx1.commit();
        session.close();
    }

    public List<ProjectFolower> findAll() {
        List<ProjectFolower> projectFolowers = (List<ProjectFolower>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From ProjectFolower").list();
        return projectFolowers;
    }
}
