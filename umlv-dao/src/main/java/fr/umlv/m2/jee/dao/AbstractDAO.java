package fr.umlv.m2.jee.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: gloyaute
 * Date: 4 nov. 2010
 * Time: 20:49:58
 * To change this template use File | Settings | File Templates.
 */
public abstract class AbstractDAO< K extends Serializable, T > implements IDAO< K, T > {

    @PersistenceContext
    private EntityManager em;
    private Class< T > entityType;

    protected AbstractDAO() {
        entityType = (Class< T >)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }

    @Override
    public boolean alreadyExists(K key) {
        try {
            getEntityManager().getReference(getEntityType(), key);
        } catch(EntityNotFoundException e) {
            return false;
        }
        return true;
    }

    @Override
    public T getReference(K id) {
        return getEntityManager().getReference(getEntityType(), id);
    }

    @Override
    public T findById(K id) {
        return getEntityManager().find(getEntityType(), id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List< T > findByQuery(String query) {
        Query result = getEntityManager().createQuery(query);

        return (List< T >)result.getResultList();
    }

    @Override
    @SuppressWarnings("unchecked")
    public T findEntityByQuery(String query) {
        Query result = getEntityManager().createQuery(query);

        return (T)result.getSingleResult();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List< T > findByNamedQuery(String query) {
        Query result = getEntityManager().createNamedQuery(query);

        return (List< T >)result.getResultList();
    }

    @Override
    @SuppressWarnings("unchecked")
    public T findEntityByNamedQuery(String query) {
        Query result = getEntityManager().createNamedQuery(query);

        return (T)result.getSingleResult();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List< T > findAll() {
        StringBuilder query = new StringBuilder("from ").append(getEntityType().getSimpleName());
        Query result = getEntityManager().createQuery(query.toString());

        return (List< T >)result.getResultList();
    }

    @Override
    public Long findCountAll() {
        StringBuilder query = new StringBuilder("select count(*) from ").append(getEntityType().getSimpleName());
        Query result = getEntityManager().createQuery(query.toString());

        return (Long)result.getSingleResult();
    }

    @Override
    public T persist(T toPersist) {
        getEntityManager().persist(toPersist);

        return toPersist;
    }

    @Override
    public void remove(T toRemove) {
        getEntityManager().remove(toRemove);
    }

    @Override
    public void flush() {
        getEntityManager().flush();
    }

    @Override
    public void clear() {
        getEntityManager().clear();
    }

    @Override
    public boolean contains(T isContained) {
        return getEntityManager().contains(isContained);
    }

    @Override
    public void refresh(T toRefresh) {
        getEntityManager().refresh(toRefresh);
    }

    @Override
    public T merge(T toMerge) {
        return getEntityManager().merge(toMerge);
    }

    @Override
    public Query createQuery(String query) {
        return getEntityManager().createQuery(query);
    }

    @Override
    public Query createNativeQuery(String query) {
        return getEntityManager().createNativeQuery(query);
    }

    @Override
    public Query createNamedQuery(String query) {
        return getEntityManager().createNamedQuery(query);
    }

    @Override
    public void setEntityManager(EntityManager entityManager) {
        this.em = entityManager;
    }

    @Override
    public EntityManager getEntityManager() {
        if (em == null) {
            throw new IllegalStateException("EntityManager has not been set!");
        }
        return em;
    }

    @Override
    public Class< T > getEntityType() {
        return entityType;
    }
}
