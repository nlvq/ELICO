package dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

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
	
	/*@Column(name="Author", unique=true)
	private Personne autheur;
	@Column
	private DateTime date;
	@OneToMany(mappedBy = "workpackage", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	private List<WorkPackage> composition;
	@OneToMany(mappedBy = "workpackage", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	private List<Contenaire> conteneur;
	
	private String version;
	@OneToOne(optional=true)
	private WorkSpace ws;*/

}
