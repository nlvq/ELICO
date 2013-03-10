package coeur_metier.wp;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.criterion.Criterion;

import dao.IWorkPackageDAO;
import dao.WorkPackage;

public class SimulateWorkPackageDAO implements IWorkPackageDAO{
	
	private ArrayList<WorkPackage> workPackages;
	
	public SimulateWorkPackageDAO(){
		workPackages = new ArrayList<WorkPackage>();
	}

	@Override
	public Session getHibernateSession() {
		// dont need
		return null;
	}

	@Override
	public List<WorkPackage> findByCriteria(Criterion... criteria) {
		// dont need
		return null;
	}

	@Override
	public List<WorkPackage> findByExample(WorkPackage instance,
			String[] excludeProperties) {
		// dont need
		return null;
	}

	@Override
	public boolean alreadyExists(Long key) {
		// dont need
		return false;
	}

	@Override
	public WorkPackage getReference(Long id) {
		// dont need
		return null;
	}

	@Override
	public WorkPackage findById(Long id) {
		// dont need
		return null;
	}

	@Override
	public List<WorkPackage> findByQuery(String query) {
		// dont need
		return null;
	}

	@Override
	public WorkPackage findEntityByQuery(String query) {
		// dont need
		return null;
	}

	@Override
	public List<WorkPackage> findByNamedQuery(String query) {
		// dont need
		return null;
	}

	@Override
	public WorkPackage findEntityByNamedQuery(String query) {
		// dont need
		return null;
	}

	@Override
	public List<WorkPackage> findAll() {
		// dont need
		return null;
	}

	@Override
	public Long findCountAll() {
		// dont need
		return null;
	}

	@Override
	public WorkPackage persist(WorkPackage toPersist) {
		// dont need
		return null;
	}

	@Override
	public void remove(WorkPackage toRemove) {
		// dont need
	}

	@Override
	public void flush() {
		// dont need
	}

	@Override
	public void clear() {
		// dont need
	}

	@Override
	public boolean contains(WorkPackage isContained) {
		// dont need
		return false;
	}

	@Override
	public void refresh(WorkPackage toRefresh) {
		// dont need
	}

	@Override
	public WorkPackage merge(WorkPackage toMerge) {
		// dont need
		return null;
	}

	@Override
	public Query createQuery(String query) {
		// dont need
		return null;
	}

	@Override
	public Query createNativeQuery(String query) {
		// dont need
		return null;
	}

	@Override
	public Query createNamedQuery(String query) {
		// dont need
		return null;
	}

	@Override
	public void setEntityManager(EntityManager entityManager) {
		// dont need
	}

	@Override
	public EntityManager getEntityManager() {
		// dont need
		return null;
	}

	@Override
	public Class<WorkPackage> getEntityType() {
		// dont need
		return null;
	}

	@Override
	public void createWorkPackage(WorkPackage workPackage) {
		if(!workPackages.contains(workPackage)){
			workPackages.add(workPackage);
		}
	}

	@Override
	public void updateWorkPackage(WorkPackage workPackage) {
		if(workPackages.contains(workPackage)){
			workPackages.remove(workPackage);
			workPackages.add(workPackage);
		}
	}

	@Override
	public void deleteWorkPackage(WorkPackage workPackage) {
		if(workPackages.contains(workPackage)){
			workPackages.remove(workPackage);
		}
	}

	@Override
	public List<WorkPackage> findWorkPackage(WorkPackage workPackage) {
		ArrayList<WorkPackage> found= new ArrayList<WorkPackage>();
		for(WorkPackage o : workPackages){
			if(o.getTitle().equals(workPackage.getTitle()))
				found.add(o);
		}
		return found;
	}
	
}