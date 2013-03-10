package coeur_metier.wp;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.IWorkPackageDAO;
import dao.Maturite;
import dao.Maturite.Etat;
import dao.Objet;
import dao.WorkPackage;

@Transactional
@Service("workPackageImpl")
public class WorkPackageImpl implements IWP {

	@Autowired
	private IWorkPackageDAO workPackageDAO;

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

	@Override
	public void createWP(String name, List<Objet> list) {
		WorkPackage wp = new WorkPackage();
		wp.setTitle(name);
		if(list != null && !list.isEmpty()){
			for(Objet o : list){
				Maturite maturite = o.getMaturite();
				if(maturite == null){
					maturite = new Maturite();
				}
				maturite.setTitle(Etat.NUL);
				o.setMaturite(maturite);
			}
		}
		wp.setObjets(list);
		workPackageDAO.createWorkPackage(wp);
	}

	@Override
	public void updateWP(WorkPackage wp) {
		workPackageDAO.updateWorkPackage(wp);
	}
	
	@Override
	public void deleteWP(WorkPackage wp){
		workPackageDAO.deleteWorkPackage(wp);
	}

	@Override
	public List<WorkPackage> findWP(WorkPackage wp) {
		Objects.requireNonNull(wp);
		return workPackageDAO.findWorkPackage(wp);
	}

}
