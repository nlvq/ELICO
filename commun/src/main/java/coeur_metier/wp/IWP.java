package coeur_metier.wp;

import java.util.List;

import dao.Objet;
import dao.WorkPackage;

public interface IWP {
	
	/**
	 * Permet de creer la persistan de l'objet WorkPackage.
	 * Un workpage est constitué d'un nom et d'un ensemble objet le constituant.
	 * @param name, le nom de package
	 * @param liste, la liste des paragraphe ou autre element
	 */
	public void createWP(String name, List<Objet> list);
	
	/**
	 * Mets a jour le WP.
	 * @param wp, mets a jour le WP
	 */
	public void updateWP(WorkPackage wp);
	
	/**
	 * Supprime le WP.
	 * @param wp, supprime le WP
	 */
	public void deleteWP(WorkPackage wp);
	
	/**
	 * Trouve un WP.
	 * @param wp
	 * @return le wp trouvé, null sinon
	 */
	public List<WorkPackage> findWP(WorkPackage wp);
	
	/**
	 * Retourne tous les workpackage.
	 * @return tous les wp
	 */
	public List<WorkPackage> getAllWorkPackage();
	
}
