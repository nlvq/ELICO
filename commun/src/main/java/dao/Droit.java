package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="DROIT")
public class Droit {
	
	public enum LDroit{Read,Write,ReadWrite,Block};
	
	@Id
	@GeneratedValue
	@Column(name="DROIT_ID")
	private Long id;
	
	@Column(name="DROIT_TITLE")
	private LDroit title;
	
	@ManyToMany(cascade=CascadeType.PERSIST, fetch=FetchType.LAZY)
	@JoinTable(name="roledonnedroit",
		joinColumns = @JoinColumn(name = "DROIT_ID"),
		inverseJoinColumns = @JoinColumn(name = "ROLE_ID"))
	private List<Role> roles = new ArrayList<>();

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the title
	 */
	public LDroit getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(LDroit title) {
		this.title = title;
	}

	/**
	 * @return the roles
	 */
	public List<Role> getRoles() {
		return roles;
	}

	/**
	 * @param roles the roles to set
	 */
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
}
