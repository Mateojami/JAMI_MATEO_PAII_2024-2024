package dao;

import models.Schedule;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class ScheduleDAO {
    private SessionFactory sessionFactory;

    public ScheduleDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void create(Schedule schedule) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(schedule);
            transaction.commit();
        }
    }

    public Schedule read(int id_sub) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Schedule.class, id_sub);
        }
    }

    public void update(Schedule schedule) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(schedule);
            transaction.commit();
        }
    }

    public void delete(Schedule schedule) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(schedule);
            transaction.commit();
        }
    }
}
