package domain;

import domain.event.Event;
import domain.member.Member;
import domain.member.Role;
import domain.message.Message;
import domain.project.Project;
import domain.status.Status;
import domain.task.Task;
import domain.team.Team;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HibernateSessionFactoryUtil {

    public static Logger logger = LogManager.getLogger();

    private static SessionFactory sessionFactory;

    private HibernateSessionFactoryUtil() {
        logger.info("HibernateSessionFactoryUtil constructor invoked");
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(Member.class);
                configuration.addAnnotatedClass(Role.class);
                configuration.addAnnotatedClass(Project.class);
                configuration.addAnnotatedClass(Event.class);
                configuration.addAnnotatedClass(Message.class);
                configuration.addAnnotatedClass(Status.class);
                configuration.addAnnotatedClass(Task.class);
                configuration.addAnnotatedClass(Team.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());

            } catch (Exception e) {
                logger.info(e.getMessage());
                logger.info(e.getStackTrace());
                logger.info(e.getCause());
                System.out.println(e.getMessage());
                e.getStackTrace();
            }
        }
        return sessionFactory;
    }
}
