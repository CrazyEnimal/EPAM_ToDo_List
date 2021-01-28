import dao.StatusDAO;
import models.Member;
import models.Role;
import models.Status;
import models.Task;
import org.hibernate.Session;
import services.MemberServices;
import services.RoleServices;
import services.TaskServices;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Find and print User
//        MemberServices memberService = new MemberServices();
//        Member member = memberService.findMember(3);
//        System.out.println(member.toString());



        // Create new user
//        MemberServices memberService = new MemberServices();
//        RoleServices roleService = new RoleServices();
//        Role role = roleService.findRole(2);
//        Member member = new Member("newUser", "new", "user", "some@email.com", "1234", role);
//        memberService.saveMember(member);


        // List Roles
//        RoleServices roleService = new RoleServices();
//        List<Role> roles = roleService.findAllRoles();
//        for (Role role: roles
//             ) {
//            System.out.println(role.toString());
//        }

        // Chapter One
//        MemberServices memberServices = new MemberServices();
//        Member creator = memberServices.find(2);
//        Task task = new Task(creator, "New super Task");
//        TaskServices taskServices = new TaskServices();
//        Task task = taskServices.find(1);
//        task.setCreator(creator);
//        taskServices.update(task);
//        System.out.println(task);

        // New statuses
//        Status status = new Status("Started");
//        StatusDAO statusDAO = new StatusDAO();
//        Status status = statusDAO.findById(3);
//        status.setTitle("In Progress");
//        statusDAO.update(status);
//        System.out.println(status);

        // Member Roles
        /*
        Member creator = new MemberServices().find(2);
        Role role = new RoleServices().find(1);
        creator.setRole(role);
        System.out.println(creator);
        new MemberServices().update(creator);
        Member creatorUpdated = new MemberServices().find(2);
        System.out.println(creatorUpdated);
        */

//        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
//
//        Member creator = session.get(Member.class, 2);
//
//        Task task = new Task(creator, " New New super Task");
//
//        session.beginTransaction();
//        session.save(task);
//        session.getTransaction().commit();
//
//
//        session.beginTransaction();
//        task.addFollower(creator);
//
//        session.save(task);
//        session.getTransaction().commit();
//        System.out.println(task);
//        session.close();
//
//        System.out.println(task);



        // Try without DAO
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();

        Member creator = session.get(Member.class, 2);
        Task task = session.get(Task.class, 3);
        task.addFollower(creator);


        session.beginTransaction();
        session.update(task);
        session.getTransaction().commit();
        System.out.println(task);
        session.close();

    }
}
