package dao;

import models.Team;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class TeamDAO {
    public Team findById(int id){
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Team.class, id);
    }

    public void save(Team team) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(team);
        tx1.commit();
        session.close();
    }

    public void update(Team team) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(team);
        tx1.commit();
        session.close();
    }

    public void delete(Team team) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(team);
        tx1.commit();
        session.close();
    }

    public List<Team> findAll() {
        List<Team> teams = (List<Team>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Team").list();
        return teams;
    }
}
