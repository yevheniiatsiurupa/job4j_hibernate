package ru.job4j.hiber;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.job4j.hiber.models.User;

import java.util.List;

public class HibernateRun {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure()
                .buildSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        User user = new User();
        user.setName("user1");
        session.save(user);
        session.getTransaction().commit();

        session.beginTransaction();
        User userCreated = session.load(User.class, 1);
        System.out.println(userCreated.getName());
        session.getTransaction().commit();

        session.beginTransaction();
        User upd = new User();
        upd.setName("user1 New");
        upd.setId(1);
        session.update(upd);
        session.getTransaction().commit();

        session.beginTransaction();
        User userUpdated = session.load(User.class, 1);
        System.out.println(userUpdated.getName());
        session.getTransaction().commit();

        session.beginTransaction();
        session.delete(upd);
        session.getTransaction().commit();

        session.beginTransaction();
        List<User> users = session.createQuery("from User").list();
        System.out.println(users);
        session.getTransaction().commit();

        session.close();
        factory.close();
    }
}
