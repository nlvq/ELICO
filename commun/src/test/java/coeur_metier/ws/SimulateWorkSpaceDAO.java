package coeur_metier.ws;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.criterion.Criterion;

import dao.IWorkSpaceDAO;
import dao.WorkSpace;

public class SimulateWorkSpaceDAO implements IWorkSpaceDAO{
	
	private ArrayList<WorkSpace> workSpaces;
	
	public SimulateWorkSpaceDAO(){
		workSpaces = new ArrayList<WorkSpace>();
	}

	@Override
	public Session getHibernateSession() {
		// dont need
		return null;
	}

	@Override
	public List<WorkSpace> findByCriteria(Criterion... criteria) {
		// dont need
		return null;
	}

	@Override
	public List<WorkSpace> findByExample(WorkSpace instance,
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
	public WorkSpace getReference(Long id) {
		// dont need
		return null;
	}

	@Override
	public WorkSpace findById(Long id) {
		// dont need
		return null;
	}

	@Override
	public List<WorkSpace> findByQuery(String query) {
		// dont need
		return null;
	}

	@Override
	public WorkSpace findEntityByQuery(String query) {
		// dont need
		return null;
	}

	@Override
	public List<WorkSpace> findByNamedQuery(String query) {
		// dont need
		return null;
	}

	@Override
	public WorkSpace findEntityByNamedQuery(String query) {
		// dont need
		return null;
	}

	@Override
	public List<WorkSpace> findAll() {
		// dont need
		return null;
	}

	@Override
	public Long findCountAll() {
		// dont need
		return null;
	}

	@Override
	public WorkSpace persist(WorkSpace toPersist) {
		// dont need
		return null;
	}

	@Override
	public void remove(WorkSpace toRemove) {
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
	public boolean contains(WorkSpace isContained) {
		// dont need
		return false;
	}

	@Override
	public void refresh(WorkSpace toRefresh) {
		// dont need
	}

	@Override
	public WorkSpace merge(WorkSpace toMerge) {
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
	public Class<WorkSpace> getEntityType() {
		// dont need
		return null;
	}

	@Override
	public void createWorkSpace(WorkSpace workSpace) {
		if(!workSpaces.contains(workSpace)){
			workSpaces.add(workSpace);
		}
	}

	@Override
	public void updateWorkSpace(WorkSpace workSpace) {
		if(workSpaces.contains(workSpace)){
			workSpaces.remove(workSpace);
			workSpaces.add(workSpace);
		}
	}

	@Override
	public void deleteWorkSpace(WorkSpace workSpace) {
		if(workSpaces.contains(workSpace)){
			workSpaces.remove(workSpace);
		}
	}

	@Override
	public List<WorkSpace> findWorkSpace(WorkSpace workSpace) {
		ArrayList<WorkSpace> found= new ArrayList<WorkSpace>();
		for(WorkSpace o : workSpaces){
			if(o.getTitle().equals(workSpace.getTitle()))
				found.add(o);
		}
		return found;
	}
	
}