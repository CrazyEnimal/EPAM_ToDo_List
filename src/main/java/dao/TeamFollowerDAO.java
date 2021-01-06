package dao;

import models.TeamFollower;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class TeamFollowerDAO {
    public TeamFollower findById(int id){
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(TeamFollower.class, id);
    }

    public void save(TeamFollower teamFollower) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(teamFollower);
        tx1.commit();
        session.close();
    }

    public void update(TeamFollower teamFollower) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(teamFollower);
        tx1.commit();
        session.close();
    }

    public void delete(TeamFollower teamFollower) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(teamFollower);
        tx1.commit();
        session.close();
    }

    public List<TeamFollower> findAll() {
        List<TeamFollower> teamFollowers = (List<TeamFollower>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From TeamFollower").list();
        return teamFollowers;
    }
}
