package dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="OBJET")
public class Objet {
	
	@Id
	@GeneratedValue
	@Column(name="OBJET_ID")
	private String id;
	
	@Column(name="OBJET_TYPE")
	private String type;
	
	@Column(name="OBJET_DESCRIPTION")
	private String description;

}
