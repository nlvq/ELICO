package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="ROLE")
public class Role {
	
	@Id
	@GeneratedValue
	@Column(name="ROLE_ID")
	private Long id;
	
	@Column(name="ROLE_TITLE")
	private String title;
	
	@ManyToMany(cascade=CascadeType.PERSIST, fetch=FetchType.LAZY)
	@JoinTable(name="roledonnedroit",
		joinColumns = @JoinColumn(name = "ROLE_ID"),
		inverseJoinColumns = @JoinColumn(name = "DROIT_ID"))
	private List<Droit> droits = new ArrayList<>();
	
	@ManyToMany(cascade=CascadeType.PERSIST, fetch=FetchType.LAZY)
	@JoinTable(name="savoirfaireimpliquerole",
		joinColumns = @JoinColumn(name = "ROLE_ID"),
		inverseJoinColumns = @JoinColumn(name = "SAVOIRFAIRE_ID"))
	private List<SavoirFaire> savoirfaires = new ArrayList<>();
	
	@OneToMany(mappedBy = "role", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	private List<UtilisateurOrganisationRole> appartient = new ArrayList<>();

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
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the droits
	 */
	public List<Droit> getDroits() {
		return droits;
	}

	/**
	 * @param droits the droits to set
	 */
	public void setDroits(List<Droit> droits) {
		this.droits = droits;
	}

	/**
	 * @return the savoirfaires
	 */
	public List<SavoirFaire> getSavoirfaires() {
		return savoirfaires;
	}

	/**
	 * @param savoirfaires the savoirfaires to set
	 */
	public void setSavoirfaires(List<SavoirFaire> savoirfaires) {
		this.savoirfaires = savoirfaires;
	}

	/**
	 * @return the appartient
	 */
	public List<UtilisateurOrganisationRole> getAppartient() {
		return appartient;
	}

	/**
	 * @param appartient the appartient to set
	 */
	public void setAppartient(List<UtilisateurOrganisationRole> appartient) {
		this.appartient = appartient;
	}

	@Override
	public String toString() {
	  return title;
	}
}
