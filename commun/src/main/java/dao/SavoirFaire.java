package dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SAVOIRFAIRE")
public class SavoirFaire {

	@Id
	@GeneratedValue
	@Column(name="SAVOIRFAIRE_ID")
	private String id;
	
	@Column(name="SAVOIRFAIRE_TITLE")
	private String title;

}
