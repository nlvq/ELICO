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
import javax.persistence.Table;

@Entity
@Table(name="SAVOIRFAIRE")
public class SavoirFaire {

	@Id
	@GeneratedValue
	@Column(name="SAVOIRFAIRE_ID")
	private Long id;
	
	@Column(name="SAVOIRFAIRE_TITLE")
	private String title;
	
	@ManyToMany(cascade=CascadeType.PERSIST, fetch=FetchType.LAZY)
	@JoinTable(name="savoirfaireimpliquerole",
		joinColumns = @JoinColumn(name = "SAVOIRFAIRE_ID"),
		inverseJoinColumns = @JoinColumn(name = "ROLE_ID"))
	private List<Role> roles = new ArrayList<>();
	
	@ManyToMany(cascade=CascadeType.PERSIST, fetch=FetchType.LAZY)
	@JoinTable(name="utilisateurpossedesavoirfaire",
		joinColumns = @JoinColumn(name = "SAVOIRFAIRE_ID"),
		inverseJoinColumns = @JoinColumn(name = "UTILISATEUR_ID"))
	private List<Utilisateur> utilisateurs = new ArrayList<>();

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
	 * @return the roles
	 */
	public List<Role> getRoles() {
		return roles;
	}

	/**
	 * @param roles the roles to set
	 */
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	/**
	 * @return the utilisateurs
	 */
	public List<Utilisateur> getUtilisateurs() {
		return utilisateurs;
	}

	/**
	 * @param utilisateurs the utilisateurs to set
	 */
	public void setUtilisateurs(List<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}
}
