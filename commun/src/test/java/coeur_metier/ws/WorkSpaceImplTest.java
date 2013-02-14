package coeur_metier.ws;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import coeur_metier.wp.IWP;
import coeur_metier.wp.WorkPackageImpl;

import dao.Droit.LDroit;
import dao.IWorkSpaceDAO;
import dao.Organisation;
import dao.WorkPackage;
import dao.WorkSpace;
import dao.impl.DefaultOrganisationDAO;
import dao.impl.DefaultWorkSpaceDAO;

public class WorkSpaceImplTest {
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public final void testCreateWS() {
		Organisation org= new Organisation();
		org.setTitle("compta");
		org.setId(1l);
		org.setType("test");
		
		WorkPackage wp=new WorkPackage();
		wp.setDroit(LDroit.Write);
		wp.setId(1l);
		wp.setTitle("WP Test 1");
		
		List<WorkPackage> listWP = new ArrayList<>();
		listWP.add(wp);
		
		WorkSpace wsparent = new WorkSpace();
		wsparent.setOrganisation(org);
		wsparent.setTitle("WS parent TEST");
		

		IWorkSpaceDAO dao = new SimulateWorkSpaceDAO();
		
		WorkSpace ws= new WorkSpace();
		ws.setOrganisation(org);
		ws.setTitle("WS_TEST");
		ws.setWorkpackages(listWP);
		dao.createWorkSpace(ws);
		
		WorkSpace wss=dao.getReference(0l);
		assertTrue(wss.getWorkpackages().equals(listWP));
		assertTrue(ws.getOrganisation().equals(org));
	}

	@Test
	public final void testAcquireWP() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testPromoteWP() {
		IWorkSpaceDAO dao = new SimulateWorkSpaceDAO();

		Organisation org= new Organisation();
		org.setTitle("compta");
		WorkSpace ws= new WorkSpace();
		ws.setOrganisation(org);
		ws.setTitle("WS_TEST");
		ws.setWorkpackages(null);
		dao.refresh(ws);
	}

	@Test
	public final void testPublishWP() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testSynchronizeWP() {
		
	}

}
