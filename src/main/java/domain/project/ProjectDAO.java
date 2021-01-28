package domain.project;

import domain.DAO;
import domain.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jetbrains.annotations.NotNull;

public class ProjectDAO implements DAO<Project, Integer> {

    public ProjectDAO() {

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
