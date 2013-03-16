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

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name="OBJET")
public class Objet {
	
	@Id
	@GeneratedValue
	@Column(name="OBJET_ID")
	private Long id;
	
	@Column(name="OBJET_TYPE")
	private String type;
	
	@Column(name="OBJET_DESCRIPTION")
	private String description;
	
	@Column(name="OBJET_CONTENT")
	private String content;
	
	@ManyToOne(cascade=CascadeType.PERSIST, fetch=FetchType.LAZY)
	private Objet parent;
	
	@OneToMany(mappedBy = "parent", cascade = CascadeType.PERSIST)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Objet> childs = new ArrayList<>();
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinColumn(name="MATURITE_ID")
	private Maturite maturite;
	
	@ManyToMany(cascade=CascadeType.PERSIST)
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinTable(name="workpackagecontientobjet",
		joinColumns = @JoinColumn(name = "OBJET_ID"),
		inverseJoinColumns = @JoinColumn(name = "WORKPACKAGE_ID"))
	private List<WorkPackage> workpackages = new ArrayList<>();

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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the parent
	 */
	public Objet getParent() {
		return parent;
	}

	/**
	 * @param parent the parent to set
	 */
	public void setParent(Objet parent) {
		this.parent = parent;
	}

	/**
	 * @return the childs
	 */
	public List<Objet> getChilds() {
		return childs;
	}

	/**
	 * @param childs the childs to set
	 */
	public void setChilds(List<Objet> childs) {
		this.childs = childs;
	}

	/**
	 * @return the maturite
	 */
	public Maturite getMaturite() {
		return maturite;
	}

	/**
	 * @param maturite the maturite to set
	 */
	public void setMaturite(Maturite maturite) {
		this.maturite = maturite;
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
