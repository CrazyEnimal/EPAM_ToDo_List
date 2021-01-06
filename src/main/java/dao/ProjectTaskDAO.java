package dao;

import models.ProjectTask;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class ProjectTaskDAO {
    public ProjectTask findById(int id){
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(ProjectTask.class, id);
    }

    public void save(ProjectTask projectTask) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(projectTask);
        tx1.commit();
        session.close();
    }

    public void update(ProjectTask projectTask) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(projectTask);
        tx1.commit();
        session.close();
    }

    public void delete(ProjectTask projectTask) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(projectTask);
        tx1.commit();
        session.close();
    }

    public List<ProjectTask> findAll() {
        List<ProjectTask> projectTasks = (List<ProjectTask>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From ProjectTask").list();
        return projectTasks;
    }
}
