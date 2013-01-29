package dao;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="WORKSPACE")
public class WorkSpace {
	
	@Id
	@GeneratedValue
	@Column(name="WORKSPACE_ID")
	private String id;
	
	@Column(name="WORKSPACE_TITLE")
	private String title;

	@OneToOne
	private WorkSpace parent;
	
	@ManyToOne(cascade=CascadeType.PERSIST, fetch=FetchType.LAZY)
	@JoinColumn(name="UTILISATEUR_LOGIN")
	private Utilisateur utilisateur;

}
