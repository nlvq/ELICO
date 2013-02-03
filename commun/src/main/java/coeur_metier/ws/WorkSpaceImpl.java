package coeur_metier.ws;

import java.util.List;

import coeur_metier.wp.IWP;
import coeur_metier.wp.WorkPackageImpl;

import dao.Droit;
import dao.Droit.LDroit;
import dao.IDroitDAO;
import dao.IOrganisationDAO;
import dao.IWorkSpaceDAO;
import dao.Maturite.Etat;
import dao.Organisation;
import dao.WorkPackage;
import dao.WorkSpace;
import dao.impl.DefaultDroitDAO;
import dao.impl.DefaultOrganisationDAO;
import dao.impl.DefaultWorkSpaceDAO;

public class WorkSpaceImpl implements IWS {
	private WorkSpace ws;
	private IWorkSpaceDAO dao = new DefaultWorkSpaceDAO();

	@Override
	public void createWS(String name, WorkSpace parentWs, String orga,
			List<WorkSpace> list) {
		IOrganisationDAO daoOrg = new DefaultOrganisationDAO();
		Organisation org = daoOrg.getOrganisation(orga);
		ws = new WorkSpace();
		ws.setParentWS(parentWs);
		ws.setFilsWS(list);
		ws.setOrg(org);
		dao.updateWorkSpace(ws);

	}

	@Override
	public void acquireWP(WorkPackage wp) {
		ws.addWP(wp);
		dao.updateWorkSpace(ws);
	}

	@Override
	public void promoteWP(WorkPackage wp) {
		IDroitDAO idao=new DefaultDroitDAO();
		IWP work =new WorkPackageImpl();
		Droit d=idao.findDroit(LDroit.block);
		wp.setEtat(Etat.RELEASE_CANDIDATE);
		wp.setDroit(d);
		work.updateWP(wp);
	}

	@Override
	public void publishWP(WorkPackage wp) {
		IDroitDAO idao=new DefaultDroitDAO();
		IWP work =new WorkPackageImpl();
		Droit d=idao.findDroit(LDroit.Read);
		wp.setEtat(Etat.RELEASE);
		wp.setDroit(d);
		work.updateWP(wp);
	}

	@Override
	public void synchronizeWP(WorkPackage wp) {
		IWP work =new WorkPackageImpl();
		work.updateWP(wp);
	}
}
