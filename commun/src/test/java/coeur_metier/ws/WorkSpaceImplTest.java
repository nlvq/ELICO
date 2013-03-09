package coeur_metier.ws;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import coeur_metier.wp.SimulateWorkPackageDAO;
import dao.Droit.LDroit;
import dao.IOrganisationDAO;
import dao.IWorkSpaceDAO;
import dao.Organisation;
import dao.WorkPackage;
import dao.WorkSpace;

public class WorkSpaceImplTest {
	private Organisation org;
	private WorkPackage wp;
	private WorkSpace wsparent;
	private WorkSpaceImpl wsi;
	private IOrganisationDAO daoOrg = new SimulateOrganisation();
	private IWorkSpaceDAO daoWS = new SimulateWorkSpaceDAO();

	@Before
	public void setUpBeforeClass() throws Exception {
		org = new Organisation();
		org.setTitle("ORGA_TEST");
		org.setType("test");

		wp = new WorkPackage();
		wp.setDroit(LDroit.Write);
		wp.setId(1l);
		wp.setTitle("WP Test 1");

		wsparent = new WorkSpace();
		wsparent.setOrganisation(org);
		wsparent.setTitle("WS parent TEST");

		daoOrg.refresh(org);

		wsi = new WorkSpaceImpl(daoWS, new SimulateWorkPackageDAO(), daoOrg);
	}

	@Test
	public final void testCreateWS() {
		List<WorkPackage> work = new ArrayList<>();
		work.add(wp);
		wsi.createWS("WS_TEST", wsparent, "ORGA_TEST", work);

		WorkSpace wss = daoWS.getReference(0l);
		assertTrue(wss.getOrganisation().getTitle().equals(org.getTitle()));
	}

//	@Test
//	public final void testAcquireWP() {
//		assertTrue("rien a faire ici, mais dans WPImpl", false);
//	}
//
//	@Test
//	public final void testPromoteWP() {
//		assertTrue("rien a faire ici, mais dans WPImpl", false);
//	}
//
//	@Test
//	public final void testPublishWP() {
//		assertTrue("rien a faire ici, mais dans WPImpl", false);
//	}
//
//	@Test
//	public final void testSynchronizeWP() {
//		assertTrue("rien a faire ici, mais dans WPImpl", false);
//
//	}

}
