package com.dev.theatre.dao.impl;

import com.dev.theatre.dao.TheatreStageDao;
import com.dev.theatre.exception.DataProcessingException;
import com.dev.theatre.model.TheatreStage;
import java.util.List;
import java.util.Optional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TheatreStageDaoImpl implements TheatreStageDao {
    private final SessionFactory sessionFactory;

    @Autowired
    public TheatreStageDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public TheatreStage add(TheatreStage theatreStage) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.persist(theatreStage);
            transaction.commit();
            return theatreStage;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't insert Theatre Stage entity "
                    + theatreStage, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<TheatreStage> getAll() {
        try (Session session = sessionFactory.openSession()) {
            Query<TheatreStage> getAllTheatreStagesQuery = session
                    .createQuery("FROM TheareStage", TheatreStage.class);
            return getAllTheatreStagesQuery.getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Can't get Theatre Stages", e);
        }
    }

    @Override
    public Optional<TheatreStage> get(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return Optional.ofNullable(session.get(TheatreStage.class, id));
        } catch (Exception e) {
            throw new DataProcessingException("Can't get Theatre Stage by id " + id, e);
        }
    }
}
