package fr.umlv.m2.jee.dao.hibernate;

import fr.umlv.m2.jee.dao.TestAbstractDAO;
import org.junit.Test;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: gloyaute
 * Date: 30 janv. 2011
 * Time: 10:33:59
 * To change this template use File | Settings | File Templates.
 */
public abstract class TestAbstractHibernateDAO < K extends Serializable, T > extends TestAbstractDAO< K, T > {

    @Test
     public void testFindByCriteria() {
    }

    @Test
    public void testFindByExample() {      
    }
}
