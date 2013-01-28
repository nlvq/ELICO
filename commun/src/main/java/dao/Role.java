package dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ROLE")
public class Role {
	
	@Id
	@GeneratedValue
	@Column(name="ROLE_ID")
	private String id;
	
	@Column(name="ROLE_TITLE")
	private String title;

}
