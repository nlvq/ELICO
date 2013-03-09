package dao;

import java.util.List;

import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import dao.Droit.LDroit;

import fr.umlv.m2.jee.dao.IDAO;
import fr.umlv.m2.jee.dao.TestAbstractDAO;

@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/elico-persistence-test-context.xml" })
public class TestWorkPackageDAO extends TestAbstractDAO <Long, WorkPackage> {

	@Autowired
	private IWorkPackageDAO workPackageDAO;

	@Override
	protected IDAO<Long, WorkPackage> getIDAO(){
		return workPackageDAO;
	}

	@Override
	protected long countAll() {
		return 3;
	}
	
	@Test
	public void testFindById(){
		WorkPackage workPackage = workPackageDAO.findById(1L);
		Assert.assertEquals(workPackage.getTitle(), "wp1");
		Assert.assertEquals(workPackage.getStartDate(), new DateTime(2013,01,01,00,00,00));
		Assert.assertEquals(workPackage.getEndDate(), new DateTime(2013,01,11,00,00,00));
		Assert.assertEquals(workPackage.getDroit(), LDroit.Write);
		Assert.assertEquals(workPackage.getOrganisation().getTitle(), "org1");
		Assert.assertEquals(workPackage.getVersion().getNumber(), "1.0");
		Assert.assertEquals(workPackage.getWorkSpace().getTitle(), "ws1");
	}
	
	@Test
	public void testFindByWorkPackage(){
		WorkPackage toFind = new WorkPackage();
		toFind.setId(1L);
		toFind.setTitle("wp1");
		List<WorkPackage> workPackage = workPackageDAO.findWorkPackage(toFind);
		Assert.assertEquals(workPackage.size(), 1);
		Assert.assertEquals(workPackage.get(0).getTitle(), "wp1");
	}
	
	@Test
	public void testUpdate(){
		WorkPackage toRefresh = workPackageDAO.findById(1L);
		toRefresh.setTitle("wp1bis");
		workPackageDAO.updateWorkPackage(toRefresh);
		
		WorkPackage workPackage = workPackageDAO.findById(1L);
		Assert.assertEquals(workPackage.getTitle(), "wp1bis");
	}
	
	@Test
	public void testCreate(){
		WorkPackage toCreate = new WorkPackage();
		toCreate.setTitle("wp4");
		toCreate.setStartDate(new DateTime());
		toCreate.setEndDate(new DateTime());
		workPackageDAO.createWorkPackage(toCreate);
		
		WorkPackage workPackage = workPackageDAO.findWorkPackage(toCreate).get(0);
		Assert.assertEquals(workPackage.getTitle(), "wp4");
	}
	
	@Test
	public void testDelete(){
		WorkPackage toDelete = workPackageDAO.findById(1L);
		workPackageDAO.deleteWorkPackage(toDelete);
		
		WorkPackage workPackage = workPackageDAO.findById(1L);
		Assert.assertNull(workPackage);
	}
			
}
