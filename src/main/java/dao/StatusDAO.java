package dao;

import models.Status;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class StatusDAO {

    public Status findById(int id){
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Status.class, id);
    }

    public void save(Status status) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(status);
        tx1.commit();
        session.close();
    }

    public void update(Status status) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(status);
        tx1.commit();
        session.close();
    }

    public void delete(Status status) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(status);
        tx1.commit();
        session.close();
    }

    public List<Status> findAll() {
        List<Status> statuses = (List<Status>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Status").list();
        return statuses;
    }
}
