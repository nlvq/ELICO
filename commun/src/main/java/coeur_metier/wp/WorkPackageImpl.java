package coeur_metier.wp;

import java.util.List;
import java.util.Objects;

import javax.persistence.Query;

import dao.Droit;
import dao.IDroitDAO;
import dao.IWorkPackageDAO;
import dao.Maturite.Etat;
import dao.Objet;
import dao.WorkPackage;
import dao.impl.DefaultDroitDAO;
import dao.impl.DefaultWorkPackageDAO;

public class WorkPackageImpl implements IWP {

	private IWorkPackageDAO DAO = new DefaultWorkPackageDAO();
	private WorkPackage wp;

	@Override
	public void createWP(String name, List<Objet> liste) {
		wp = new WorkPackage();
		wp.setTitle(name);
		//TODO wp.setOrganisation(organisation)
		for(Objet o : liste){
			o.getMaturite().setTitle(Etat.NUL);
		}
		wp.setObjets(liste);
		DAO.createWorkPackage(wp);
	}

	@Override
	public void updateWP(WorkPackage wp) {
		DAO.updateWorkPackage(wp);
	}

	/**
	 * c faux ca!
	 */
	@Override
	public WorkPackage findWP(WorkPackage wp) {
		Objects.requireNonNull(wp);
//		if (wp.getId() != null) {
//			return DAO.findWorkPackage(wp.getId()).get(0);
//		} else if (wp.getTitle() != null) {
//			final Query query = DAO.createQuery("select * from WORKPACKAGE where WORKPACKAGE.WORKPACKAGE_TITLE:=wp");
//			query.setParameter("wp", wp.getId());
//
//		}
//		return new WorkPackage();
		
		//TODO je pense qu'il faut faire :
		//return DAO.findWorkPackage(wp);
		//mais ça retourne une liste, donc soit on fait un .get(0) ou on modifie la signature de la methode
		return null;
	}

	@Override
	public void lockWP(String id) {
		wp.setDroit(Droit.LDroit.Write);
		updateWP(wp);
	}

	@Override
	public void unlockWP(String id) {
		wp.setDroit(Droit.LDroit.ReadWrite);
		updateWP(wp);

	}

	@Override
	public void requestValidation(String id) {
		IDroitDAO iddao = new DefaultDroitDAO();
		//TODO check les droits de l'utilisateur lié au wp ?
		for(Objet o : wp.getObjets()){
			o.getMaturite().setTitle(Etat.ASKVALID);
		}
		updateWP(wp);

	}

	@Override
	public void accept(String id) {
		for(Objet o : wp.getObjets()){
			o.getMaturite().setTitle(Etat.VALIDED);
		}
		updateWP(wp);
	}

	@Override
	public void refuse(String id, String reason) {
		for(Objet o : wp.getObjets()){
			o.getMaturite().setTitle(Etat.REFUSED);
			o.getMaturite().setCommentary(reason);
		}
		updateWP(wp);

	}

}
