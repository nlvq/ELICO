package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="ORGANISATION")
public class Organisation {
	
	@Id
	@GeneratedValue
	@Column(name="ORGANISATION_ID")
	private Long id;
	
	@Column(name="ORGANISATION_TITLE")
	private String title;
	
	@Column(name="ORGANISATION_TYPE")
	private String type;
	
	@ManyToOne(cascade=CascadeType.PERSIST, fetch=FetchType.LAZY)
	private Organisation parent;
	
	@OneToMany(mappedBy = "parent", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	private List<Organisation> childs = new ArrayList<>();
	
	@OneToMany(mappedBy = "organisation", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	private List<WorkSpace> workspaces = new ArrayList<>();
	
	@OneToMany(mappedBy = "organisation", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	private List<WorkPackage> workpackages = new ArrayList<>();
	
	@OneToMany(mappedBy = "organisation", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
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
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the parent
	 */
	public Organisation getParent() {
		return parent;
	}

	/**
	 * @param parent the parent to set
	 */
	public void setParent(Organisation parent) {
		this.parent = parent;
	}

	/**
	 * @return the childs
	 */
	public List<Organisation> getChilds() {
		return childs;
	}

	/**
	 * @param childs the childs to set
	 */
	public void setChilds(List<Organisation> childs) {
		this.childs = childs;
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
	 * @return the workpackages
	 */
	public List<WorkPackage> getWorkpackages() {
		return workpackages;
	}

	/**
	 * @param workpackages the workpackages to set
	 */
	public void setWorkpackages(List<WorkPackage> workpackages) {
		this.workpackages = workpackages;
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
