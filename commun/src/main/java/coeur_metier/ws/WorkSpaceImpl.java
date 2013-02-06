package coeur_metier.ws;

import java.util.List;

import coeur_metier.wp.IWP;
import coeur_metier.wp.WorkPackageImpl;
import dao.Droit.LDroit;
import dao.IDroitDAO;
import dao.IOrganisationDAO;
import dao.IWorkSpaceDAO;
import dao.Maturite.Etat;
import dao.Objet;
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
			List<WorkPackage> list) {
		IOrganisationDAO daoOrg = new DefaultOrganisationDAO();
		Organisation toFind = new Organisation();
		toFind.setTitle(orga);
		Organisation org = daoOrg.findOrganisation(toFind).get(0);
		ws = new WorkSpace();
		ws.setParent(parentWs);
		ws.setWorkpackages(list);
		ws.setOrganisation(org);
		dao.updateWorkSpace(ws);

	}

	@Override
	public void acquireWP(WorkPackage wp) {
		ws.getWorkpackages().add(wp);
		dao.updateWorkSpace(ws);
	}

	@Override
	public void promoteWP(WorkPackage wp) {
		IDroitDAO idao=new DefaultDroitDAO();
		IWP work =new WorkPackageImpl();
		wp.setDroit(LDroit.Block);
		for(Objet o : wp.getObjets()){
			o.getMaturite().setTitle(Etat.ASKVALID);
		}
		work.updateWP(wp);
	}

	@Override
	public void publishWP(WorkPackage wp) {
		IDroitDAO idao=new DefaultDroitDAO();
		IWP work =new WorkPackageImpl();
		wp.setDroit(LDroit.Read);
		for(Objet o : wp.getObjets()){
			o.getMaturite().setTitle(Etat.VALIDED);
		}
		work.updateWP(wp);
	}

	@Override
	public void synchronizeWP(WorkPackage wp) {
		IWP work =new WorkPackageImpl();
		work.updateWP(wp);
	}
}
