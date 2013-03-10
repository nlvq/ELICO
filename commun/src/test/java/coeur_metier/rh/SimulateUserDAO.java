package coeur_metier.rh;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.criterion.Criterion;

import dao.IUtilisateurDAO;
import dao.Utilisateur;

public class SimulateUserDAO implements IUtilisateurDAO{
	
	private ArrayList<Utilisateur> utilisateurs;
	
	public SimulateUserDAO(){
		utilisateurs = new ArrayList<Utilisateur>();
	}

	@Override
	public Session getHibernateSession() {
		// dont need
		return null;
	}

	@Override
	public List<Utilisateur> findByCriteria(Criterion... criteria) {
		// dont need
		return null;
	}

	@Override
	public List<Utilisateur> findByExample(Utilisateur instance,
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
	public Utilisateur getReference(Long id) {
		// dont need
		return null;
	}

	@Override
	public Utilisateur findById(Long id) {
		// dont need
		return null;
	}

	@Override
	public List<Utilisateur> findByQuery(String query) {
		// dont need
		return null;
	}

	@Override
	public Utilisateur findEntityByQuery(String query) {
		// dont need
		return null;
	}

	@Override
	public List<Utilisateur> findByNamedQuery(String query) {
		// dont need
		return null;
	}

	@Override
	public Utilisateur findEntityByNamedQuery(String query) {
		// dont need
		return null;
	}

	@Override
	public List<Utilisateur> findAll() {
		return utilisateurs;
	}

	@Override
	public Long findCountAll() {
		// dont need
		return null;
	}

	@Override
	public Utilisateur persist(Utilisateur toPersist) {
		// dont need
		return null;
	}

	@Override
	public void remove(Utilisateur toRemove) {
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
	public boolean contains(Utilisateur isContained) {
		// dont need
		return false;
	}

	@Override
	public void refresh(Utilisateur toRefresh) {
		// dont need
	}

	@Override
	public Utilisateur merge(Utilisateur toMerge) {
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
	public Class<Utilisateur> getEntityType() {
		// dont need
		return null;
	}

	@Override
	public void createUtilisateur(Utilisateur utilisateur) {
		if(!utilisateurs.contains(utilisateur)){
			utilisateurs.add(utilisateur);
		}
	}

	@Override
	public void updateUtilisateur(Utilisateur utilisateur) {
		if(utilisateurs.contains(utilisateur)){
			utilisateurs.remove(utilisateur);
			utilisateurs.add(utilisateur);
		}
	}

	@Override
	public void deleteUtilisateur(Utilisateur utilisateur) {
		if(utilisateurs.contains(utilisateur)){
			utilisateurs.remove(utilisateur);
		}
	}
	
	@Override
	public List<Utilisateur> findUtilisateur(Utilisateur utilisateur) {
		ArrayList<Utilisateur> found= new ArrayList<Utilisateur>();
		for(Utilisateur u : utilisateurs){
			// Add user if login is equals:
			if(u.getLogin().equals(utilisateur.getLogin()))
				found.add(u);
		}
		return found;
	}
	
}