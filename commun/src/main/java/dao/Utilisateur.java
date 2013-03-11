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
@Table(name="UTILISATEUR")
public class Utilisateur {

	@Id
	@GeneratedValue
	@Column(name="UTILISATEUR_ID")
	private Long id;
	
	@Column(name="UTILISATEUR_LOGIN")
	private String login;
	
	@Column(name="UTILISATEUR_PASSWORD")
	private String password;
	
	@Column(name="UTILISATEUR_LASTNAME")
	private String lastName;
	
	@Column(name="UTILISATEUR_FIRSTNAME")
	private String firstName;
	
	@Column(name="UTILISATEUR_PHONENUMBER")
	private String phoneNumber;
	
	@OneToMany(mappedBy = "utilisateur", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	private List<WorkSpace> workspaces = new ArrayList<>();
	
	@ManyToMany(cascade=CascadeType.PERSIST, fetch=FetchType.LAZY)
	@JoinTable(name="utilisateurpossedesavoirfaire",
		joinColumns = @JoinColumn(name = "UTILISATEUR_ID"),
		inverseJoinColumns = @JoinColumn(name = "SAVOIRFAIRE_ID"))
	private List<SavoirFaire> savoirfaires = new ArrayList<>();

	@OneToMany(mappedBy = "utilisateur", fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
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
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @return the workspaces
	 */
	public List<WorkSpace> getWorkspaces() {
		return workspaces;
	}

	/**
	 * @param workspaces the workspaces to set
	 */
	public void setWorkspaces(List<WorkSpace> workspaces) {
		this.workspaces = workspaces;
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
		
}
