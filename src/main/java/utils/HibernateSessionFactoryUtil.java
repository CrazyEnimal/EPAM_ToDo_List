package utils;

import models.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateSessionFactoryUtil {
    private static SessionFactory sessionFactory;

    private HibernateSessionFactoryUtil() {}

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
                configuration.addAnnotatedClass(Member.class);
                configuration.addAnnotatedClass(Role.class);
                configuration.addAnnotatedClass(Project.class);
                configuration.addAnnotatedClass(ProjectFolower.class);
                configuration.addAnnotatedClass(ProjectTask.class);
                configuration.addAnnotatedClass(Task.class);
                configuration.addAnnotatedClass(TaskFolower.class);
                configuration.addAnnotatedClass(TaskMessage.class);
                configuration.addAnnotatedClass(Team.class);
                configuration.addAnnotatedClass(Status.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());

//                sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
            } catch (Exception e) {
                System.out.println("Исключение! " + e);
            }
        }
        return sessionFactory;
    }
}
