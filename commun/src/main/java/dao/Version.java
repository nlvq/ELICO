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
@Table(name="VERSION")
public class Version {
	
	@Id
	@GeneratedValue
	@Column(name="VERSION_ID")
	private Long id;
	
	@Column(name="VERSION_NUMBER")
	private String number;
	
	@OneToMany(mappedBy = "version", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
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
	 * @return the number
	 */
	public String getNumber() {
		return number;
	}

	/**
	 * @param number the number to set
	 */
	public void setNumber(String number) {
		this.number = number;
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
