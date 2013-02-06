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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import dao.Droit.LDroit;

@Entity
@Table(name="WORKPACKAGE")
public class WorkPackage {
	
	@Id
	@GeneratedValue
	@Column(name="WORKPACKAGE_ID")
	private String id;
	
	@Column(name="WORKPACKAGE_TITLE")
	private String title;
	
	@Column(name="WORKPACKAGE_STARTDATE")
	@Type(type="org.joda.time.contrib.hibernate.PersistentDateTime")
	private DateTime startDate;
	
	@Column(name="WORKPACKAGE_ENDDATE")
	@Type(type="org.joda.time.contrib.hibernate.PersistentDateTime")
	private DateTime endDate;
	
	@Column(name="WORKPACKAGE_DROIT")
	private LDroit droit;
	
	@ManyToOne(cascade=CascadeType.PERSIST, fetch=FetchType.LAZY)
	@JoinColumn(name="WORKSPACE_ID")
	private WorkSpace workSpace;

	@ManyToMany(cascade=CascadeType.PERSIST, fetch=FetchType.LAZY)
	@JoinTable(name="workpackagecontientobjet",
		joinColumns = @JoinColumn(name = "WORKPACKAGE_ID"),
		inverseJoinColumns = @JoinColumn(name = "OBJET_ID"))
	private List<Objet> objets = new ArrayList<>();
	
	@ManyToOne(cascade=CascadeType.PERSIST, fetch=FetchType.LAZY)
	@JoinColumn(name="ORGANISATION_ID")
	private Organisation organisation;
	
	@ManyToOne(cascade=CascadeType.PERSIST, fetch=FetchType.LAZY)
	@JoinColumn(name="VERSION_ID")
	private Version version;
	
	@ManyToOne(cascade=CascadeType.PERSIST, fetch=FetchType.LAZY)
	private WorkPackage workPackage;
	
	@OneToMany(mappedBy = "workPackage", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	private List<WorkPackage> workpackages = new ArrayList<>();

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
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
	 * @return the startDate
	 */
	public DateTime getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(DateTime startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public DateTime getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(DateTime endDate) {
		this.endDate = endDate;
	}

	/**
	 * @return the droit
	 */
	public LDroit getDroit() {
		return droit;
	}

	/**
	 * @param droit the droit to set
	 */
	public void setDroit(LDroit droit) {
		this.droit = droit;
	}

	/**
	 * @return the workSpace
	 */
	public WorkSpace getWorkSpace() {
		return workSpace;
	}

	/**
	 * @param workSpace the workSpace to set
	 */
	public void setWorkSpace(WorkSpace workSpace) {
		this.workSpace = workSpace;
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

	/**
	 * @return the organisation
	 */
	public Organisation getOrganisation() {
		return organisation;
	}

	/**
	 * @param organisation the organisation to set
	 */
	public void setOrganisation(Organisation organisation) {
		this.organisation = organisation;
	}

	/**
	 * @return the version
	 */
	public Version getVersion() {
		return version;
	}

	/**
	 * @param version the version to set
	 */
	public void setVersion(Version version) {
		this.version = version;
	}

	/**
	 * @return the workPackage
	 */
	public WorkPackage getWorkPackage() {
		return workPackage;
	}

	/**
	 * @param workPackage the workPackage to set
	 */
	public void setWorkPackage(WorkPackage workPackage) {
		this.workPackage = workPackage;
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

}
