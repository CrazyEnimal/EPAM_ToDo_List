package dao;

import models.Project;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class ProjectDAO {

    public Project findById(int id){
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Project.class, id);
    }

    public void save(Project project) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(project);
        tx1.commit();
        session.close();
    }

    public void update(Project project) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(project);
        tx1.commit();
        session.close();
    }

    public void delete(Project project) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(project);
        tx1.commit();
        session.close();
    }

    public List<Project> findAll() {
        List<Project> projects = (List<Project>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Project").list();
        return projects;
    }
}
