package coeur_metier.authentification;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.criterion.Criterion;

import dao.IUtilisateurDAO;
import dao.Utilisateur;

public class SimulateUtilisateurDAO implements IUtilisateurDAO{
	
	private ArrayList<Utilisateur> utilisateurs;
	
	public SimulateUtilisateurDAO(){
		// Create some users:
		utilisateurs = new ArrayList<Utilisateur>();
		Utilisateur u1 = new Utilisateur();
		u1.setLogin("u1");
		u1.setPassword("pwd");
		utilisateurs.add(u1);
		Utilisateur u2 = new Utilisateur();
		u2.setLogin("u2");
		u2.setPassword("pwd");
		utilisateurs.add(u2);
		Utilisateur u3 = new Utilisateur();
		u3.setLogin("u3");
		u3.setPassword("pwd");
		utilisateurs.add(u3);
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
		// dont need
		return null;
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
		// dont need
	}

	@Override
	public void updateUtilisateur(Utilisateur utilisateur) {
		// dont need
	}

	@Override
	public void deleteUtilisateur(Utilisateur utilisateur) {
		// dont need
	}

	@Override
	public List<Utilisateur> findUtilisateur(Utilisateur utilisateur) {
		ArrayList<Utilisateur> found= new ArrayList<Utilisateur>();
		for(Utilisateur u : utilisateurs){
			// Add user if login and password are equals:
			if(u.getLogin().equals(utilisateur.getLogin())
					&& u.getPassword().equals(utilisateur.getPassword()))
				found.add(u);
		}
		return found;
	}
	
}