package ru.job4j.hiber.persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import ru.job4j.hiber.models.Item;

import java.util.List;
import java.util.function.Function;

/**
 * Класс для работы с базой данных.
 * @author Evgeniya Tsiurupa
 * @version 1.0
 * @since 28/08/2019
 */
public class DbStore {
    private static final DbStore INSTANCE = new DbStore();
    private static SessionFactory factory;
    private DbStore() {
        factory = new Configuration().configure().buildSessionFactory();
    }

    public static DbStore getInstance() {
        return INSTANCE;
    }

    private <T> T tx(final Function<Session, T> command) {
        final Session session = factory.openSession();
        Transaction tr = null;
        try {
            tr = session.beginTransaction();
            T rsl = command.apply(session);
            tr.commit();
            return rsl;
        } catch (Exception e) {
            if (tr != null) {
                tr.rollback();
                e.printStackTrace();
            }
        } finally {
            session.close();
        }
        return null;
    }


    /**
     * Метод для добавления / редактирования задания.
     * @param item задание.
     */
    public void addOrUpdateItem(Item item) {
        Session session = factory.openSession();
        Transaction tr = null;
        try {
            tr = session.beginTransaction();
            session.saveOrUpdate(item);
            tr.commit();
        } catch (Exception e) {
            if (tr != null) {
                tr.rollback();
                e.printStackTrace();
            }
        } finally {
            session.close();
        }
    }

    /**
     * Метод возвращает список всех заданий в БД.
     */
    public List findAll() {
        return this.tx(session -> session.createQuery("from Item").list());
    }

    /**
     * Метод возвращает список невыполненных заданий из БД.
     */
    public List findFiltered() {
        return this.tx(session -> session.createQuery("from Item where done = false").list());
    }
}
