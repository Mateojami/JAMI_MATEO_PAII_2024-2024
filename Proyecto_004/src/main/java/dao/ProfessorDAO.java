package dao;

import models.Professor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class ProfessorDAO {
    private SessionFactory sessionFactory;

    public ProfessorDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void create(Professor professor) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(professor);
            transaction.commit();
        }
    }

    public Professor read(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Professor.class, id);
        }
    }

    public void update(Professor professor) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(professor);
            transaction.commit();
        }
    }

    public void delete(Professor professor) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(professor);
            transaction.commit();
        }
    }
}
