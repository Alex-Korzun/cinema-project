package com.dev.theatre.dao.impl;

import com.dev.theatre.dao.TheatreSessionDao;
import com.dev.theatre.exception.DataProcessingException;
import com.dev.theatre.model.TheatreSession;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TheatreSessionDaoImpl implements TheatreSessionDao {
    private final SessionFactory sessionFactory;

    @Autowired
    public TheatreSessionDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public TheatreSession add(TheatreSession theatreSession) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.persist(theatreSession);
            transaction.commit();
            return theatreSession;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't insert Theatre Session entity "
                    + theatreSession, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<TheatreSession> findAvailableSessions(Long performanceId, LocalDate date) {
        try (Session session = sessionFactory.openSession()) {
            Query<TheatreSession> getAllSessionsQuery =
                    session.createQuery("SELECT ts FROM TheatreSession ts "
                                    + "LEFT JOIN FETCH ts.theatreStage "
                                    + "LEFT JOIN FETCH ts.performance "
                                    + "WHERE ts.performance.id = :id_performance "
                                    + "AND DATE_FORMAT (ts.showTime, '%Y-%m-%d') = :date ",
                            TheatreSession.class);
            getAllSessionsQuery.setParameter("id_performance", performanceId);
            getAllSessionsQuery.setParameter("date",
                    DateTimeFormatter.ISO_LOCAL_DATE.format(date));
            return getAllSessionsQuery.getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Can't find available Sessions for "
                    + performanceId + " " + date.toString(), e);
        }
    }

    @Override
    public Optional<TheatreSession> get(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return Optional.ofNullable(session.get(TheatreSession.class, id));
        } catch (Exception e) {
            throw new DataProcessingException("Can't get Performance Session by id " + id, e);
        }
    }

    @Override
    public TheatreSession update(TheatreSession theatreSession) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.update(theatreSession);
            transaction.commit();
            return theatreSession;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't update Theatre Session entity "
                    + theatreSession, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void delete(Long id) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            TheatreSession theatreSession = session.load(TheatreSession.class, id);
            session.delete(theatreSession);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't delete Theatre Session entity by id"
                    + id, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
