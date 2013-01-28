package dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="ORGANISATION")
public class Organisation {
	
	@Id
	@GeneratedValue
	@Column(name="ORGANISATION_ID")
	private String id;
	
	@Column(name="ORGANISATION_TITLE")
	private String title;
	
	@Column(name="ORGANISATION_TYPE")
	private String type;
	
	@OneToOne
	private Organisation parent;

}
