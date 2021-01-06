package dao;

import models.TeamProject;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class TeamProjectDAO {
    public TeamProject findById(int id){
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(TeamProject.class, id);
    }

    public void save(TeamProject teamProject) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(teamProject);
        tx1.commit();
        session.close();
    }

    public void update(TeamProject teamProject) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(teamProject);
        tx1.commit();
        session.close();
    }

    public void delete(TeamProject teamProject) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(teamProject);
        tx1.commit();
        session.close();
    }

    public List<TeamProject> findAll() {
        List<TeamProject> teamProjects = (List<TeamProject>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From TeamProject").list();
        return teamProjects;
    }
}
