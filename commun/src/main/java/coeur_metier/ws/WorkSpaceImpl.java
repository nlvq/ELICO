package coeur_metier.ws;

import java.util.List;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import coeur_metier.wp.IWP;
import coeur_metier.wp.WorkPackageImpl;
import dao.Droit.LDroit;
import dao.IOrganisationDAO;
import dao.IWorkPackageDAO;
import dao.IWorkSpaceDAO;
import dao.Maturite.Etat;
import dao.Objet;
import dao.Organisation;
import dao.WorkPackage;
import dao.WorkSpace;
import dao.impl.DefaultOrganisationDAO;
import dao.impl.DefaultWorkSpaceDAO;

@Transactional
@ContextConfiguration(locations = { "classpath:spring/elico-persistence-context.xml" })
public class WorkSpaceImpl implements IWS {
	private WorkSpace ws;
	private IWorkSpaceDAO dao = new DefaultWorkSpaceDAO();
	private IWP work = new WorkPackageImpl();
	private IOrganisationDAO daoOrg = new DefaultOrganisationDAO();

	public WorkSpaceImpl(IWorkSpaceDAO daoSpace, IWorkPackageDAO daoWork,IOrganisationDAO orgDAO) {
		this.dao = daoSpace;
		work=new WorkPackageImpl(daoWork);
		daoOrg=orgDAO;
	}

	public WorkSpaceImpl() {
	}

	@Override
	public void createWS(String name, WorkSpace parentWs, String orga,
			List<WorkPackage> list) {
		Organisation toFind = new Organisation();
		toFind.setTitle(orga);
		Organisation org = daoOrg.findOrganisation(toFind).get(0);
		ws = new WorkSpace();
		ws.setTitle(name);
		ws.setParent(parentWs);
		ws.setWorkpackages(list);
		ws.setOrganisation(org);
		dao.createWorkSpace(ws);

	}

	@Override
	public void acquireWP(WorkPackage wp) {
		ws.getWorkpackages().add(wp);
		dao.updateWorkSpace(ws);
	}

	@Override
	public void promoteWP(WorkPackage wp) {
		wp.setDroit(LDroit.Block);
		for (Objet o : wp.getObjets()) {
			o.getMaturite().setTitle(Etat.ASKVALID);
		}
		work.updateWP(wp);
	}

	@Override
	public void publishWP(WorkPackage wp) {
		wp.setDroit(LDroit.Read);
		for (Objet o : wp.getObjets()) {
			o.getMaturite().setTitle(Etat.VALIDED);
		}
		work.updateWP(wp);
	}

	@Override
	public void synchronizeWP(WorkPackage wp) {
		work.updateWP(wp);
	}

	@Override
	public List<WorkSpace> getWS(WorkSpace space) {
		return dao.findWorkSpace(space);
		
	}

}
