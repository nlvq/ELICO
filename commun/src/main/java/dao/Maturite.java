package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="MATURITE")
public class Maturite {
	
	public enum Etat{NUL, INPROGRESS, ASKVALID, VALIDED, REFUSED};

	@Id
	@GeneratedValue
	@Column(name="MATURITE_ID")
	private Long id;

	@Column(name="MATURITE_TITLE")
	private Etat title;

	@Column(name="MATURITE_COMMENTARY")
	private String commentary;
	
	@OneToMany(mappedBy = "maturite", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	private List<Objet> objets = new ArrayList<>();

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the title
	 */
	public Etat getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(Etat title) {
		this.title = title;
	}

	/**
	 * @return the commentary
	 */
	public String getCommentary() {
		return commentary;
	}

	/**
	 * @param commentary the commentary to set
	 */
	public void setCommentary(String commentary) {
		this.commentary = commentary;
	}

	/**
	 * @return the objets
	 */
	public List<Objet> getObjets() {
		return objets;
	}

	/**
	 * @param objets the objets to set
	 */
	public void setObjets(List<Objet> objets) {
		this.objets = objets;
	}
	
}
