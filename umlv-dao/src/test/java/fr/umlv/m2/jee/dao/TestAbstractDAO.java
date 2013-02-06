package fr.umlv.m2.jee.dao;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: gloyaute
 * Date: 6 nov. 2010
 * Time: 22:36:08
 * To change this template use File | Settings | File Templates.
 */
@Transactional
public abstract class TestAbstractDAO< K extends Serializable, T > {

    protected abstract long countAll();

    protected abstract IDAO< K, T > getIDAO();

    @Test
    public void testFindAll() {
        IDAO< K, T > dao = getIDAO();

        List< T > result = dao.findAll();

        Assert.assertEquals(countAll(), result.size());
    }

    @Test
    public void testCountAll() {
        IDAO< K, T > dao = getIDAO();
        long result = dao.findCountAll();

        Assert.assertEquals(countAll(), result);
    }
}
