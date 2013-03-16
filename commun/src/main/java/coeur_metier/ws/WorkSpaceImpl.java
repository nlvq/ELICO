package coeur_metier.ws;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	private IWorkSpaceDAO workSpaceDAO;

	@Autowired
	private IWorkPackageDAO workPackageDAO;

	@Autowired
	private IOrganisationDAO organisationDAO;

	/**
	 * @return the workSpaceDAO
	 */
	public IWorkSpaceDAO getWorkSpaceDAO() {
		return workSpaceDAO;
	}

	/**
	 * @param workSpaceDAO the workSpaceDAO to set
	 */
	public void setWorkSpaceDAO(IWorkSpaceDAO workSpaceDAO) {
		this.workSpaceDAO = workSpaceDAO;
	}

	/**
	 * @return the workPackageDAO
	 */
	public IWorkPackageDAO getWorkPackageDAO() {
		return workPackageDAO;
	}

	/**
	 * @param workPackageDAO the workPackageDAO to set
	 */
	public void setWorkPackageDAO(IWorkPackageDAO workPackageDAO) {
		this.workPackageDAO = workPackageDAO;
	}

	/**
	 * @return the organisationDAO
	 */
	public IOrganisationDAO getOrganisationDAO() {
		return organisationDAO;
	}

	/**
	 * @param organisationDAO the organisationDAO to set
	 */
	public void setOrganisationDAO(IOrganisationDAO organisationDAO) {
		this.organisationDAO = organisationDAO;
	}

	@Override
	public void createWS(String name, WorkSpace parentWs, String orga, List<WorkPackage> list) {
		WorkSpace ws = new WorkSpace();
		ws.setTitle(name);
		ws.setParent(parentWs);
		ArrayList<WorkPackage> wps = new ArrayList<WorkPackage>();	//bugfix problem detached entity
		if(list != null){
			for(WorkPackage wp : list){
				wps.add(workPackageDAO.findWorkPackage(wp).get(0));
			}
			ws.setWorkpackages(wps);
		}
		Organisation toFind = new Organisation();
		toFind.setTitle(orga);
		List<Organisation> listOrga = organisationDAO.findOrganisation(toFind);
		if(listOrga != null && !listOrga.isEmpty()){
			ws.setOrganisation(listOrga.get(0));
		}
		else{
			Organisation organisation = new Organisation();
			organisation.setTitle(orga);
			organisation.setType("default");
			ws.setOrganisation(organisation);
		}
		workSpaceDAO.createWorkSpace(ws);
		for(WorkPackage wp : wps){	//bugfix wp
			acquireWP(wp, ws);
		}
	}

	@Override
	public void updateWS(WorkSpace ws) {
		workSpaceDAO.updateWorkSpace(ws);
	}

	@Override
	public void deleteWS(WorkSpace ws) {
		workSpaceDAO.deleteWorkSpace(ws);
	}

	@Override
	public List<WorkSpace> findWS(WorkSpace ws) {
		return workSpaceDAO.findWorkSpace(ws);
	}

	@Override
	public void acquireWP(WorkPackage wp, WorkSpace ws) {
		wp.setWorkSpace(ws);
		workPackageDAO.updateWorkPackage(wp);
	}

	@Override
	public void unlockWP(WorkPackage wp) {
		wp.setWorkSpace(null);
		workPackageDAO.updateWorkPackage(wp);
	}

	@Override
	public void promoteWP(WorkPackage wp) {
		//TODO check les droits de l'utilisateur lié au wp ?
		for (Objet o : wp.getObjets()) {
			o.getMaturite().setTitle(Etat.ASKVALID);
		}
		workPackageDAO.updateWorkPackage(wp);
	}

	@Override
	public void publishWP(WorkPackage wp) {
		for (Objet o : wp.getObjets()) {
			o.getMaturite().setTitle(Etat.VALIDED);
		}
		workPackageDAO.updateWorkPackage(wp);
	}

	@Override
	public void refuseWP(WorkPackage wp, String reason) {
		for(Objet o : wp.getObjets()){
			o.getMaturite().setTitle(Etat.REFUSED);
			o.getMaturite().setCommentary(reason);
		}
		workPackageDAO.updateWorkPackage(wp);
	}

	@Override
	public void synchronizeWP(WorkPackage wp) {
		workPackageDAO.updateWorkPackage(wp);
	}

}
