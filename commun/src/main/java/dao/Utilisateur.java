package dao;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="UTILISATEUR")
public class Utilisateur {

	@Id
	@Column(name="UTILISATEUR_LOGIN")
	private String login;
	
	@Column(name="UTILISATEUR_PASSWORD")
	private String password;
	
	@Column(name="UTILISATEUR_LASTNAME")
	private String lastName;
	
	@Column(name="UTILISATEUR_FIRSTNAME")
	private String firstName;
	
	@Column(name="UTILISATEUR_PHONENUMBER")
	private String phoneNumber;
	
	@OneToMany(mappedBy = "utilisateur", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	private List<WorkSpace> assigne;
		
}
