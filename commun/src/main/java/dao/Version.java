package dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="VERSION")
public class Version {
	
	@Id
	@GeneratedValue
	@Column(name="VERSION_ID")
	private String id;
	
	@Column(name="VERSION_NUMBER")
	private String number;

}
