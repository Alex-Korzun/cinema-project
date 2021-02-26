package com.dev.theatre.dao.impl;

import com.dev.theatre.dao.PerformanceDao;
import com.dev.theatre.exception.DataProcessingException;
import com.dev.theatre.model.Performance;
import java.util.List;
import java.util.Optional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PerformanceDaoImpl implements PerformanceDao {
    private final SessionFactory sessionFactory;

    @Autowired
    public PerformanceDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Performance add(Performance performance) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.persist(performance);
            transaction.commit();
            return performance;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't insert Performance entity " + performance, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<Performance> getAll() {
        try (Session session = sessionFactory.openSession()) {
            Query<Performance> getAllPerformancesQuery = session
                    .createQuery("FROM Performance", Performance.class);
            return getAllPerformancesQuery.getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Can't get all Performances", e);
        }
    }

    @Override
    public Optional<Performance> get(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return Optional.ofNullable(session.get(Performance.class, id));
        } catch (Exception e) {
            throw new DataProcessingException("Can't get Performance by id " + id, e);
        }
    }
}
