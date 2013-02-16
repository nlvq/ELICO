package coeur_metier.wp;

import java.util.List;
import java.util.Objects;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import dao.Droit;
import dao.IWorkPackageDAO;
import dao.Maturite.Etat;
import dao.Objet;
import dao.WorkPackage;
import dao.impl.DefaultWorkPackageDAO;

@Transactional
@ContextConfiguration(locations = { "classpath:spring/elico-persistence-context.xml" })
public class WorkPackageImpl implements IWP {

	private IWorkPackageDAO DAO = new DefaultWorkPackageDAO();
	private WorkPackage wp;
	
	public WorkPackageImpl(IWorkPackageDAO DAO){
		this.DAO=DAO;
	}
	public WorkPackageImpl(){
	}

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
	public List<WorkPackage> findWP(WorkPackage wp) {
		Objects.requireNonNull(wp);
		return DAO.findWorkPackage(wp);
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
		//IDroitDAO iddao = new DefaultDroitDAO();
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
