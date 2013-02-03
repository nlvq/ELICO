package dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="DROIT")
public class Droit {
	public enum LDroit{Read,Write,ReadWrite,block};
	
	@Id
	@GeneratedValue
	@Column(name="DROIT_ID")
	private String id;
	
	@Column(name="DROIT_TITLE")
	private LDroit title;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public LDroit getTitle() {
		return title;
	}

	public void setTitle(LDroit title) {
		this.title = title;
	}
	

}
