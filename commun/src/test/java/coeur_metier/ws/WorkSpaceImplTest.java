package coeur_metier.ws;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import coeur_metier.wp.SimulateWorkPackageDAO;
import coeur_metier.wp.WorkPackageImpl;

import dao.Maturite.Etat;
import dao.Objet;
import dao.Organisation;
import dao.WorkPackage;
import dao.WorkSpace;

public class WorkSpaceImplTest {
	
	private WorkSpaceImpl workSpaceImpl;
	
	private WorkPackageImpl workPackageImpl;

	@Before
	public void init() {
		workSpaceImpl = new WorkSpaceImpl();
		SimulateWorkSpaceDAO workSpaceDAO = new SimulateWorkSpaceDAO();
		workSpaceImpl.setWorkSpaceDAO(workSpaceDAO);
		SimulateWorkPackageDAO workPackageDAO = new SimulateWorkPackageDAO();
		workSpaceImpl.setWorkPackageDAO(workPackageDAO);
		SimulateOrganisationDAO organisationDAO = new SimulateOrganisationDAO();
		workSpaceImpl.setOrganisationDAO(organisationDAO);

		workPackageImpl = new WorkPackageImpl();
		workPackageImpl.setWorkPackageDAO(workPackageDAO);
	}

	@Test
	public final void testCreateWS() {
		Organisation organisation = new Organisation();
		organisation.setTitle("orga1");
		organisation.setType("dept");
		workSpaceImpl.getOrganisationDAO().createOrganisation(organisation);
		workPackageImpl.createWP("wp1", null);
		WorkPackage wpToFind = new WorkPackage();
		wpToFind.setTitle("wp1");
		List<WorkPackage> wpFound = workPackageImpl.findWP(wpToFind);
		workSpaceImpl.createWS("ws1", null, "orga1", wpFound);
		WorkSpace wsToFind = new WorkSpace();
		wsToFind.setTitle("ws1");
		List<WorkSpace> wsFound = workSpaceImpl.findWS(wsToFind);
		Assert.assertEquals(wsFound.size(), 1);
		Assert.assertEquals(wsFound.get(0).getTitle(), "ws1");
		Assert.assertEquals(wsFound.get(0).getOrganisation().getTitle(), "orga1");
		Assert.assertEquals(wsFound.get(0).getOrganisation().getType(), "dept");
		Assert.assertEquals(wsFound.get(0).getWorkpackages().get(0).getTitle(), "wp1");
	}

	@Test
	public final void testUpdateWS() {
		workSpaceImpl.createWS("ws2", null, "orga2", null);
		WorkSpace toFind = new WorkSpace();
		toFind.setTitle("ws2");
		List<WorkSpace> wsFound = workSpaceImpl.findWS(toFind);
		Assert.assertEquals(wsFound.size(), 1);
		Assert.assertEquals(wsFound.get(0).getTitle(), "ws2");
		Assert.assertEquals(wsFound.get(0).getOrganisation().getTitle(), "orga2");
		Assert.assertEquals(wsFound.get(0).getOrganisation().getType(), "default");
		Assert.assertNull(wsFound.get(0).getParent());
		workSpaceImpl.createWS("ws2parent", null, "orga2", null);
		WorkSpace parentToFind = new WorkSpace();
		parentToFind.setTitle("ws2parent");
		wsFound.get(0).setParent(workSpaceImpl.findWS(parentToFind).get(0));
		workSpaceImpl.updateWS(wsFound.get(0));
		wsFound = workSpaceImpl.findWS(toFind);
		Assert.assertEquals(wsFound.size(), 1);
		Assert.assertEquals(wsFound.get(0).getTitle(), "ws2");
		Assert.assertEquals(wsFound.get(0).getOrganisation().getTitle(), "orga2");
		Assert.assertEquals(wsFound.get(0).getParent().getTitle(), "ws2parent");
	}

	@Test
	public final void testDeleteWS() {
		workSpaceImpl.createWS("ws3", null, "orga3", null);
		WorkSpace toFind = new WorkSpace();
		toFind.setTitle("ws3");
		List<WorkSpace> wsFound = workSpaceImpl.findWS(toFind);
		Assert.assertEquals(wsFound.size(), 1);
		workSpaceImpl.deleteWS(wsFound.get(0));
		wsFound = workSpaceImpl.findWS(toFind);
		Assert.assertEquals(wsFound.size(), 0);
	}

	@Test
	public final void testFindWS() {
		workSpaceImpl.createWS("ws4", null, "orga4", null);
		WorkSpace toFind = new WorkSpace();
		toFind.setTitle("ws4");
		List<WorkSpace> wsFound = workSpaceImpl.findWS(toFind);
		Assert.assertEquals(wsFound.size(), 1);
		Assert.assertEquals(wsFound.get(0).getTitle(), "ws4");
		Assert.assertEquals(wsFound.get(0).getOrganisation().getTitle(), "orga4");
	}

	@Test
	public final void testAcquireAndUnlockWP() {
		workSpaceImpl.createWS("ws5", null, "orga5", null);
		workPackageImpl.createWP("wp5", null);
		WorkPackage wpToFind = new WorkPackage();
		wpToFind.setTitle("wp5");
		List<WorkPackage> wpFound = workPackageImpl.findWP(wpToFind);
		Assert.assertNull(wpFound.get(0).getWorkSpace());
		WorkSpace toFind = new WorkSpace();
		toFind.setTitle("ws5");
		List<WorkSpace> wsFound = workSpaceImpl.findWS(toFind);
		
		// Acquire
		workSpaceImpl.acquireWP(wpFound.get(0), wsFound.get(0));
		wpFound = workPackageImpl.findWP(wpToFind);
		Assert.assertEquals(wpFound.get(0).getWorkSpace().getTitle(), "ws5");
		
		// Unlock
		workSpaceImpl.unlockWP(wpFound.get(0));
		wpFound = workPackageImpl.findWP(wpToFind);
		wsFound = workSpaceImpl.findWS(toFind);
		Assert.assertNull(wpFound.get(0).getWorkSpace());
		Assert.assertEquals(wsFound.size(), 1);
	}

	@Test
	public final void testPromoteWP() {
		ArrayList<Objet> listObjet = new ArrayList<Objet>();
		Objet o1 = new Objet();
		o1.setContent("a a a");
		listObjet.add(o1);
		Objet o2 = new Objet();
		o2.setContent("b b b");
		listObjet.add(o2);
		workPackageImpl.createWP("wp6", listObjet);
		WorkPackage wpToFind = new WorkPackage();
		wpToFind.setTitle("wp6");
		List<WorkPackage> wpFound = workPackageImpl.findWP(wpToFind);
		Assert.assertEquals(wpFound.get(0).getObjets().get(0).getMaturite().getTitle(), Etat.NUL);
		Assert.assertEquals(wpFound.get(0).getObjets().get(1).getMaturite().getTitle(), Etat.NUL);
		workSpaceImpl.promoteWP(wpFound.get(0));
		wpFound = workPackageImpl.findWP(wpToFind);
		Assert.assertEquals(wpFound.get(0).getObjets().get(0).getMaturite().getTitle(), Etat.ASKVALID);
		Assert.assertEquals(wpFound.get(0).getObjets().get(1).getMaturite().getTitle(), Etat.ASKVALID);
	}

	@Test
	public final void testPublishWP() {
		ArrayList<Objet> listObjet = new ArrayList<Objet>();
		Objet o1 = new Objet();
		o1.setContent("ffff");
		listObjet.add(o1);
		workPackageImpl.createWP("wp7", listObjet);
		WorkPackage wpToFind = new WorkPackage();
		wpToFind.setTitle("wp7");
		List<WorkPackage> wpFound = workPackageImpl.findWP(wpToFind);
		Assert.assertEquals(wpFound.get(0).getObjets().get(0).getMaturite().getTitle(), Etat.NUL);
		workSpaceImpl.publishWP(wpFound.get(0));
		wpFound = workPackageImpl.findWP(wpToFind);
		Assert.assertEquals(wpFound.get(0).getObjets().get(0).getMaturite().getTitle(), Etat.VALIDED);
	}
	
	@Test
	public final void testRefuseWP() {
		ArrayList<Objet> listObjet = new ArrayList<Objet>();
		Objet o1 = new Objet();
		o1.setContent("mm");
		listObjet.add(o1);
		workPackageImpl.createWP("wp8", listObjet);
		WorkPackage wpToFind = new WorkPackage();
		wpToFind.setTitle("wp8");
		List<WorkPackage> wpFound = workPackageImpl.findWP(wpToFind);
		Assert.assertEquals(wpFound.get(0).getObjets().get(0).getMaturite().getTitle(), Etat.NUL);
		workSpaceImpl.refuseWP(wpFound.get(0), "trop moche");
		wpFound = workPackageImpl.findWP(wpToFind);
		Assert.assertEquals(wpFound.get(0).getObjets().get(0).getMaturite().getTitle(), Etat.REFUSED);
		Assert.assertEquals(wpFound.get(0).getObjets().get(0).getMaturite().getCommentary(), "trop moche");
	}

	@Test
	public final void testSynchronizeWP() {
		// same as update, dont test
	}

}
