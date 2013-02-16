package coeur_metier.wp;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import dao.Droit.LDroit;
import dao.IWorkPackageDAO;
import dao.Objet;
import dao.WorkPackage;

public class WorkPackageImplTest {

	private IWorkPackageDAO dao = new SimulateWorkPackageDAO();
	private IWP work = new WorkPackageImpl(dao);
	private List<Objet> listObjet;
	
	@Before
	public void setUpBeforeClass() throws Exception {
		listObjet = new ArrayList<>();
		listObjet.add(new Objet());
		listObjet.add(new Objet());
	}

	@Test
	public final void testCreateWP() {
		work.createWP("Test", listObjet);
		List<WorkPackage> list=dao.findAll();
		WorkPackage wp=list.get(0);
		assertEquals((long)wp.getId(),0l);
		assertEquals(wp.getTitle(),"Test");
		assertEquals(wp.getObjets().size(),2);
	}

	@Test
	public final void testUpdateWP() {
		work.createWP("Test", listObjet);
		List<WorkPackage> list=dao.findAll();
		WorkPackage wp=list.get(0);
		wp.setTitle("PIPO");
		wp.setDroit(LDroit.Read);
		work.updateWP(wp);
		list=dao.findAll();
		wp=list.get(0);
		assertEquals((long)wp.getId(),0l);
		assertEquals(wp.getTitle(),"PIPO");
		assertEquals(wp.getObjets().size(),2);
		assertEquals(wp.getDroit(),LDroit.Read);
	}

	@Test
	public final void testFindWP() {
		work.createWP("Test1", listObjet);
		WorkPackage wp=new WorkPackage();
		wp.setTitle("Test1");
		work.findWP(wp);
	}

	@Test(expected=IllegalAccessException.class)
	public final void testLockWP() {
		work.lockWP("0");
		WorkPackage wp=new WorkPackage();
		wp.setId(0l);
		work.updateWP(wp);
	}

	@Test
	public final void testUnlockWP() {
		//work.unlockWP(id);
	}

	@Test
	public final void testRequestValidation() {
		//work.requestValidation(id);
	}

	@Test
	public final void testAccept() {
		//work.accept(id);
	}

	@Test
	public final void testRefuse() {
		//work.refuse(id, reason);
	}

}
