package coeur_metier.livre;

import java.util.List;

import dao.Objet;


public interface ILivre {
	public void CreateObject(Objet object);
	public void CreateChapter(Objet VolPere );
	public void CreateVolume( Objet VolLivre );
	public void CreateParagraph( Objet ChapPere );
	public void UpdateObject(Objet object) ;
	public void DeleteObject(Objet object) ;
	public List<Objet > FindObject(Objet object) ;
}