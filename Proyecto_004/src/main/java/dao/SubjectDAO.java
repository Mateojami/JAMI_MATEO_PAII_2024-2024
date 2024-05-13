package dao;

import models.Subject;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class SubjectDAO {
    private SessionFactory sessionFactory;

    public SubjectDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void create(Subject subject) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(subject);
            transaction.commit();
        }
    }

    public Subject read(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Subject.class, id);
        }
    }

    public void update(Subject subject) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(subject);
            transaction.commit();
        }
    }

    public void delete(Subject subject) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(subject);
            transaction.commit();
        }
    }
}
