package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import dao.Maturite.Etat;

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
	

	@Column(name="WORKPACKAGE_AUTHEUR", unique=true)
	private Utilisateur user;

	private List<Objet> conteneur;

	private Droit droit;

	private Etat etat;

	private List<String> msgRefus=new ArrayList<>();
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Utilisateur getUser() {
		return user;
	}

	public void setUser(Utilisateur user) {
		this.user = user;
	}

	public List<Objet> getConteneur() {
		return conteneur;
	}

	public void setConteneur(List<Objet> conteneur) {
		this.conteneur = conteneur;
	}

	public void setDroit(Droit droit) {
		this.droit=droit;
		
	}
	public Droit getDroit() {
		return droit;
		
	}

	public void setEtat(Etat etat) {
		this.etat=etat;
	}

	public Etat getEtat() {
		return etat;
	}

	public void addMsgRefus(String reason) {
		this.msgRefus.add(reason);
		
	}
	
/*	@Column
	private DateTime date;
	@OneToMany(mappedBy = "workpackage", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	private List<WorkPackage> composition;
	@OneToMany(mappedBy = "workpackage", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	private List<Contenaire> conteneur;
	
	private String version;
	@OneToOne(optional=true)
	private WorkSpace ws;*/

}
