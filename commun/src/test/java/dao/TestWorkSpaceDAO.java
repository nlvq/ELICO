package dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import fr.umlv.m2.jee.dao.IDAO;
import fr.umlv.m2.jee.dao.TestAbstractDAO;

@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/elico-persistence-test-context.xml" })
public class TestWorkSpaceDAO extends TestAbstractDAO <Long, WorkSpace> {

	@Autowired
	private IWorkSpaceDAO workSpaceDAO;

	@Override
	protected IDAO<Long, WorkSpace> getIDAO(){
		return workSpaceDAO;
	}

	@Override
	protected long countAll() {
		return 2;
	}
	
	@Test
	public void testFindById(){
		WorkSpace workSpace = workSpaceDAO.findById(1L);
		Assert.assertEquals(workSpace.getTitle(), "ws1");
		Assert.assertEquals(workSpace.getUtilisateur().getLogin(), "toto1");
		Assert.assertEquals(workSpace.getOrganisation().getTitle(), "org1");
	}
	
	@Test
	public void testFindByWorkSpace(){
		WorkSpace toFind = new WorkSpace();
		toFind.setId(1L);
		toFind.setTitle("ws1");
		List<WorkSpace> workSpace = workSpaceDAO.findWorkSpace(toFind);
		Assert.assertEquals(workSpace.size(), 1);
		Assert.assertEquals(workSpace.get(0).getTitle(), "ws1");
	}
	
	@Test
	public void testUpdate(){
		WorkSpace toRefresh = workSpaceDAO.findById(1L);
		toRefresh.setTitle("ws100");
		workSpaceDAO.updateWorkSpace(toRefresh);
		
		WorkSpace workSpace = workSpaceDAO.findById(1L);
		Assert.assertEquals(workSpace.getTitle(), "ws100");
	}
	
	@Test
	public void testCreate(){
		WorkSpace toCreate = new WorkSpace();
		toCreate.setTitle("wp3");
		workSpaceDAO.createWorkSpace(toCreate);
		
		WorkSpace workSpace = workSpaceDAO.findById(3L);
		Assert.assertEquals(workSpace.getTitle(), "wp3");
	}
	
	@Test
	public void testDelete(){
		WorkSpace toDelete = workSpaceDAO.findById(1L);
		workSpaceDAO.deleteWorkSpace(toDelete);
		
		WorkSpace workSpace = workSpaceDAO.findById(1L);
		Assert.assertNull(workSpace);
	}
			
}
