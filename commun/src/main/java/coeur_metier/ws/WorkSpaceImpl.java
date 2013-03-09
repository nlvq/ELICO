package coeur_metier.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

@Transactional
@Service("workSpaceImpl")
public class WorkSpaceImpl implements IWS {
	
	@Autowired
	private IWorkSpaceDAO dao;

	@Autowired
	private IOrganisationDAO daoOrg;
	
	private WorkSpace ws;
	private IWP work = new WorkPackageImpl();

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
