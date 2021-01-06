package dao;

import models.TaskFollower;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class TaskFollowerDAO {
    public TaskFollower findById(int id){
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(TaskFollower.class, id);
    }

    public void save(TaskFollower taskFollower) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(taskFollower);
        tx1.commit();
        session.close();
    }

    public void update(TaskFollower taskFollower) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(taskFollower);
        tx1.commit();
        session.close();
    }

    public void delete(TaskFollower taskFollower) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(taskFollower);
        tx1.commit();
        session.close();
    }

    public List<TaskFollower> findAll() {
        List<TaskFollower> taskFollowers = (List<TaskFollower>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From TaskFollower").list();
        return taskFollowers;
    }
}
