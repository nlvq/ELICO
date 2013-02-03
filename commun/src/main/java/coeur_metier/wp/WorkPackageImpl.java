package coeur_metier.wp;

import java.util.List;
import java.util.Objects;

import dao.Droit;
import dao.IDroitDAO;
import dao.IWorkPackageDAO;
import dao.Maturite;
import dao.Objet;
import dao.Utilisateur;
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
		wp.setEtat(Maturite.Etat.WORK);
		wp.setUser(new Utilisateur());
		wp.setConteneur(liste);
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
		if (wp.getId() != null) {
			return DAO.findWorkPackage(wp.getId()).get(0);
		} else if (wp.getTitle() != null) {
			DAO.findByNamedQuery("select * from WORKPACKAGE where WORKPACKAGE.WORKPACKAGE_TITLE:=");
		}
		return new WorkPackage();
	}

	@Override
	public void lockWP(String id) {
		IDroitDAO iddao = new DefaultDroitDAO();
		Droit droit = iddao.findDroit(Droit.LDroit.Write);
		wp.setDroit(droit);
		updateWP(wp);
	}

	@Override
	public void unlockWP(String id) {
		IDroitDAO iddao = new DefaultDroitDAO();
		Droit droit = iddao.findDroit(Droit.LDroit.ReadWrite);
		wp.setDroit(droit);
		updateWP(wp);

	}

	@Override
	public void requestValidation(String id) {
		IDroitDAO iddao = new DefaultDroitDAO();
		Droit droit = iddao.findDroit(Droit.LDroit.Write);
		wp.setDroit(droit);
		wp.setEtat(Maturite.Etat.RELEASE_CANDIDATE);
		updateWP(wp);

	}

	@Override
	public void accept(String id) {
		wp.setEtat(Maturite.Etat.RELEASE);
		updateWP(wp);
	}

	@Override
	public void refuse(String id, String reason) {
		wp.addMsgRefus(reason);
		wp.setEtat(Maturite.Etat.WORK);
		updateWP(wp);

	}

}
