package fr.umlv.m2.jee.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: gloyaute
 * Date: 3 nov. 2010
 * Time: 22:22:34
 * To change this template use File | Settings | File Templates.
 */
public interface IDAO< K extends Serializable, T > {

    /**
     * 
     *
     * @param key
     * @return
     */
    public boolean alreadyExists(K key);

    /**
     *
     * 
     * @param id
     * @return
     */
    public T getReference(K id);

    /**
     *
     *
     * @param id
     * @return
     */
    public T findById(K id);

    /**
     *
     * 
     * @param query
     * @return
     */
    public List< T > findByQuery(String query);

    /**
     *
     * 
     * @param query
     * @return
     */
    public T findEntityByQuery(String query);

    /**
     *
     * 
     * @param query
     * @return
     */
    public List< T > findByNamedQuery(String query);

    /**
     *
     * 
     * @param query
     * @return
     */
    public T findEntityByNamedQuery(String query);

    /**
     *
     * 
     * @return
     */
    public List< T > findAll();

    /**
     *
     * 
     * @return
     */
    public Long findCountAll();

    /**
     *
     * 
     * @param toPersist
     * @return
     */
    public T persist(T toPersist);

    /**
     *
     * 
     * @param toRemove
     */
    public void remove(T toRemove);

    /**
     * Synchronize all the changes that are made to the persistent entities back to the underlying database.
     */
    public void flush();

    /**
     *
     */
    public void clear();

    /**
     *
     *
     * @param isContained
     * @return
     */
    public boolean contains(T isContained);

    /**
     * Update the entity object with values taken from the database.
     * Any new values that are set to the entity objects will be lost as a result of this method call.
     *
     * @param toRefresh The entity object updates with values taken from the DB
     */
    public void refresh(T toRefresh);

    /**
     *
     *
     * @param toMerge
     * @return
     */
    public T merge(T toMerge);

    /**
     *
     *
     * @param query
     * @return
     */
    public Query createQuery(String query);

    /**
     *
     *
     * @param query
     * @return
     */
    public Query createNativeQuery(String query);

    /**
     *
     *
     * @param query
     * @return
     */
    public Query createNamedQuery(String query);

    /**
     *
     *
     * @param entityManager
     */
    public void setEntityManager(EntityManager entityManager);

    /**
     *
     *
     * @return
     */
    public EntityManager getEntityManager();

    /**
     *
     * 
     * @return
     */
    public Class< T > getEntityType();
}
