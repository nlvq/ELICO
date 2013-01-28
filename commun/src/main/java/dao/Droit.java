package dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="DROIT")
public class Droit {
	
	@Id
	@GeneratedValue
	@Column(name="DROIT_ID")
	private String id;
	
	@Column(name="DROIT_TITLE")
	private String title;

}
