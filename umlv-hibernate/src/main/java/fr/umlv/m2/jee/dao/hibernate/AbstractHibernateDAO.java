package fr.umlv.m2.jee.dao.hibernate;

import fr.umlv.m2.jee.dao.AbstractDAO;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Example;

import java.io.Serializable;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: gloyaute
 * Date: 27 nov. 2010
 * Time: 10:37:51
 * To change this template use File | Settings | File Templates.
 */
public abstract class AbstractHibernateDAO< K extends Serializable, T > extends AbstractDAO< K, T > implements IHibernateDAO< K, T > {

    @Override
    public Session getHibernateSession() {
        return (Session)getEntityManager().getDelegate();
    }

    @Override
    public List<T> findByCriteria(Criterion... criterion) {
        Session session = getHibernateSession();
        Criteria criteria = session.createCriteria(getEntityType());

        for (int i = 0; i < criterion.length; ++i) {
            criteria.add(criterion[i]);
        }
        return criteria.list();

    }

    @Override
    public List< T > findByExample(T instance, String[] excludeProperties) {
        Criteria criteria = getHibernateSession().createCriteria(getEntityType());
        Example example = Example.create(instance);

        for (int i = 0; i < excludeProperties.length; ++i) {
            example.excludeProperty(excludeProperties[i]);
        }
        criteria.add(example);

        return criteria.list();
    }
}
