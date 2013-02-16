package coeur_metier.wp;

import java.util.List;

import dao.Objet;
import dao.WorkPackage;

public interface IWP {
	
	/**
	 * Permet de creer la persistan de l'objet WorkPackage.
	 * Un workpage est constitué d'un nom et d'un ensemble objet le constituant
	 * @param name, le nom de package
	 * @param liste, la liste des paragraphe ou autre element
	 */
	public void createWP(String name, List<Objet> liste);
	/**
	 * Mets a jours le WP
	 * @param wp, mets a jour le WP
	 */
	public void updateWP(WorkPackage wp);
	/**
	 * Trouve un WP
	 * @param wp, 
	 * @return le wp trouvé, null sinon
	 */
	public List<WorkPackage> findWP(WorkPackage wp);
	/**
	 * Prend le lock sur le WP, il ne peut plus etre modifié.
	 * @param id
	 */
	public void lockWP(String id);
	/**
	 * Demande au WP d'etre debloqué pour ecriture.
	 * @param id, ID du WP
	 */
	public void unlockWP(String id);
	/**
	 * Le WP demande a etre valider par une personne habilité a le faire.
	 * 
	 * @param id, id du WP
	 */
	public void requestValidation(String id);
	/**
	 * Methode invoqué par le validateur ou toute personne habilité a le faire.
	 * Il accepte le WS, et le mets a jours dans la BDD.
	 * @param id, id du WP
	 */
	public void accept(String id);
	/**
	 * Cette methode sert aux validateurs pour refuser le WP.
	 * Si le WP est refusé le valideur doit indiquer la raison pour laquel il a ete refuse.
	 * @param id, l'id du WP
	 * @param reason, le motif du refus
	 */
	public void refuse(String id, String reason);
}
