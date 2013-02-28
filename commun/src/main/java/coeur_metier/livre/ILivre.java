package coeur_metier.livre;

import java.util.List;

import dao.Objet;

public interface ILivre {
	public void createObject(Objet object);
	public void createVolume(Objet object, Objet livrePere);
	public void createChapter(Objet object, Objet volPere);
	public void createParagraph(Objet object, Objet chapPere);
	public void updateObject(Objet object);
	public void deleteObject(Objet object);
	public List<Objet> findObject(Objet object);
}