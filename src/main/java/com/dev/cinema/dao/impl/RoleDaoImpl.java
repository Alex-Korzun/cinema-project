package com.dev.cinema.dao.impl;

import com.dev.cinema.dao.RoleDao;
import com.dev.cinema.exception.DataProcessingException;
import com.dev.cinema.model.Role;
import com.dev.cinema.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDaoImpl implements RoleDao {
    private final SessionFactory sessionFactory;

    @Autowired
    public RoleDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(Role role) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.persist(role);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't insert Role entity "
                    + role, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Role getRoleByName(String roleName) {
        try (Session session = sessionFactory.openSession()) {
            Query<Role> getRoleByNameQuery = session.createQuery("FROM Role r "
                    + "WHERE r.roleName = :roleName", Role.class);
            getRoleByNameQuery.setParameter("roleName", roleName);
            return getRoleByNameQuery.getSingleResult();
        } catch (Exception e) {
            throw new DataProcessingException("Can't get Role by name " + roleName, e);
        }
    }
}
