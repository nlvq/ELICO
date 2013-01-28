package coeur_metier.wp;

import java.util.List;

import dao.Objet;
import dao.WorkPackage;

public interface IWP {
	public void createWP(String name, List<Objet> liste);
	public void updateWP(WorkPackage wp);
	public WorkPackage findWP(WorkPackage wp);
	public void lockWP(String id);
	public void unlockWP(String id);
	public void requestValidation(String id);
	public void accept(String id);
	public void refuse(String id, String reason);
}
