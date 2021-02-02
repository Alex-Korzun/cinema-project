package com.dev.cinema.dao.impl;

import com.dev.cinema.dao.MovieSessionDao;
import com.dev.cinema.exception.DataProcessingException;
import com.dev.cinema.lib.Dao;
import com.dev.cinema.model.MovieSession;
import com.dev.cinema.util.HibernateUtil;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

@Dao
public class MovieSessionDaoImpl implements MovieSessionDao {
    @Override
    public MovieSession add(MovieSession movieSession) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.persist(movieSession);
            transaction.commit();
            return movieSession;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't insert Movie Session entity "
                    + movieSession, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<MovieSession> findAvailableSessions(Long movieId, LocalDate date) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<MovieSession> getAllSessionsQuery =
                    session.createQuery("SELECT ms FROM MovieSession ms "
                                    + "LEFT JOIN FETCH ms.cinemaHall LEFT JOIN FETCH ms.movie "
                                    + "WHERE ms.movie.id = :id_movie "
                                    + "AND DATE_FORMAT(ms.showTime, '%Y-%m-%d') = :date ",
                            MovieSession.class);
            getAllSessionsQuery.setParameter("id_movie", movieId);
            getAllSessionsQuery.setParameter("date",
                    DateTimeFormatter.ISO_LOCAL_DATE.format(date));
            return getAllSessionsQuery.getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Can't find available Sessions for "
                    + movieId + " " + date.toString(), e);
        }
    }
}
