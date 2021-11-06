package ua.goit.projectmanager.repository;

import lombok.SneakyThrows;
import org.hibernate.Session;
import org.hibernate.query.criteria.JpaCriteriaQuery;
import ua.goit.projectmanager.model.BaseEntity;
import ua.goit.projectmanager.util.HibernateSessionFactory;

import java.io.Closeable;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

public class BaseRepositoryImpl<T extends BaseEntity<ID>, ID> implements Closeable, BaseRepository<T, ID> {

    private final Class<T> modelClass;



    public BaseRepositoryImpl(Class<T> modelClass) {
        this.modelClass = modelClass;
    }


    @Override
    public T save(T t) {
        Session session = openSession();
        ID id = (ID) session.save(t);
        Optional<T> res = getById(id, session);
        closeSession(session);
        return res.get();
    }


    @Override
    public List<T> getAll() {
        Session session = openSession();
        JpaCriteriaQuery<T> query = session.getCriteriaBuilder().createQuery(modelClass);
        List<T> resultList = session.createQuery(query.select(query.from(modelClass))).getResultList();
        closeSession(session);
        return resultList;
    }


    @Override
    public Optional<T> findById(ID id) {
        Session session = openSession();
        Optional<T> e = getById(id, session);
        closeSession(session);
        return e;
    }


    @Override
    public void deleteById(ID id) {
        Session session = openSession();
        getById(id,session).ifPresent(session::remove);
        closeSession(session);
    }

    private Session openSession() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        return session;
    }

    private void closeSession(Session session) {
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void close() {
        HibernateSessionFactory.close();
    }
    private Optional<T> getById(ID id, Session session) {
        return Optional.ofNullable(session.get(modelClass, id));
    }
}
