package fr.umlv.m2.jee.dao.hibernate;

import fr.umlv.m2.jee.dao.IDAO;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;

import java.io.Serializable;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: gloyaute
 * Date: 27 nov. 2010
 * Time: 10:37:32
 * To change this template use File | Settings | File Templates.
 */
public interface IHibernateDAO< K extends Serializable, T > extends IDAO< K, T > {

    Session getHibernateSession();

    List< T > findByCriteria(Criterion... criteria);

    List< T > findByExample(T instance, String[] excludeProperties);
}
