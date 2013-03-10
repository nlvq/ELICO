package coeur_metier.wp;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import dao.Objet;
import dao.WorkPackage;
import dao.Maturite.Etat;

public class WorkPackageImplTest {
	
	private WorkPackageImpl workPackageImpl;

	@Before
	public void init() {
		workPackageImpl = new WorkPackageImpl();
		SimulateWorkPackageDAO workPackageDAO = new SimulateWorkPackageDAO();
		workPackageImpl.setWorkPackageDAO(workPackageDAO);
	}

	@Test
	public final void testCreateWP() {
		ArrayList<Objet> listObjet = new ArrayList<Objet>();
		Objet o1 = new Objet();
		o1.setContent("a a a");
		listObjet.add(o1);
		Objet o2 = new Objet();
		o2.setContent("b b b");
		listObjet.add(o2);
		workPackageImpl.createWP("wp1", listObjet);
		WorkPackage toFind = new WorkPackage();
		toFind.setTitle("wp1");
		List<WorkPackage> found = workPackageImpl.findWP(toFind);
		Assert.assertEquals(found.size(), 1);
		Assert.assertEquals(found.get(0).getTitle(), "wp1");
		Assert.assertEquals(found.get(0).getObjets().get(0).getContent(), "a a a");
		Assert.assertEquals(found.get(0).getObjets().get(0).getMaturite().getTitle(), Etat.NUL);
		Assert.assertEquals(found.get(0).getObjets().get(1).getContent(), "b b b");
		Assert.assertEquals(found.get(0).getObjets().get(1).getMaturite().getTitle(), Etat.NUL);
	}

	@Test
	public final void testUpdateWP() {
		workPackageImpl.createWP("wp2", null);
		WorkPackage toFind = new WorkPackage();
		toFind.setTitle("wp2");
		List<WorkPackage> found = workPackageImpl.findWP(toFind);
		Assert.assertEquals(found.size(), 1);
		Assert.assertEquals(found.get(0).getTitle(), "wp2");
		Assert.assertNull(found.get(0).getStartDate());
		DateTime dt = new DateTime();
		found.get(0).setStartDate(dt);
		workPackageImpl.updateWP(found.get(0));
		found = workPackageImpl.findWP(toFind);
		Assert.assertEquals(found.size(), 1);
		Assert.assertEquals(found.get(0).getTitle(), "wp2");
		Assert.assertEquals(found.get(0).getStartDate(), dt);
	}

	@Test
	public final void testDeleteWP() {
		workPackageImpl.createWP("wp3", null);
		WorkPackage toFind = new WorkPackage();
		toFind.setTitle("wp3");
		List<WorkPackage> found = workPackageImpl.findWP(toFind);
		Assert.assertEquals(found.size(), 1);
		workPackageImpl.deleteWP(found.get(0));
		found = workPackageImpl.findWP(toFind);
		Assert.assertEquals(found.size(), 0);
	}
	
	@Test
	public final void testFindWP() {
		workPackageImpl.createWP("wp4", null);
		WorkPackage toFind = new WorkPackage();
		toFind.setTitle("wp4");
		List<WorkPackage> found = workPackageImpl.findWP(toFind);
		Assert.assertEquals(found.size(), 1);
		Assert.assertEquals(found.get(0).getTitle(), "wp4");
	}

}
