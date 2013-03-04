package dao;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

/**
 * Classe pour la liaison ternaire entre utilisateur, organisation et role.
 * 
 * @source 
 *         http://www.developpez.net/forums/d751258/java/general-java/persistance/jpa/relation-ternaire-annotations/
 */
@Entity
@Table(name="UTILISATEURORGANISATIONROLE")
public class UtilisateurOrganisationRole {

	@Embeddable
	public static class Id implements Serializable {
		
		/**
		 * Generated serial id.
		 */
		private static final long serialVersionUID = 1867506770932059287L;

		@Column(name = "UTILISATEUR_ID")
		private Long utilisateurid;
		
		@Column(name = "ORGANISATION_ID")
		private Long organisationid;
		
		@Column(name = "ROLE_ID")
		private Long roleid;

		/**
		 * @return the utilisateurid
		 */
		public Long getUtilisateurid() {
			return utilisateurid;
		}

		/**
		 * @param utilisateurid the utilisateurid to set
		 */
		public void setUtilisateurid(Long utilisateurid) {
			this.utilisateurid = utilisateurid;
		}

		/**
		 * @return the organisationid
		 */
		public Long getOrganisationid() {
			return organisationid;
		}

		/**
		 * @param organisationid the organisationid to set
		 */
		public void setOrganisationid(Long organisationid) {
			this.organisationid = organisationid;
		}

		/**
		 * @return the roleid
		 */
		public Long getRoleid() {
			return roleid;
		}

		/**
		 * @param roleid the roleid to set
		 */
		public void setRoleid(Long roleid) {
			this.roleid = roleid;
		}
		
	}

	@EmbeddedId
	private Id id = new Id();
	
	@ManyToOne
	@JoinColumn(name = "UTILISATEUR_ID", insertable = false, updatable = false)
	@MapsId("utilisateurid")
	private Utilisateur utilisateur;
	
	@ManyToOne
	@JoinColumn(name = "ORGANISATION_ID", insertable = false, updatable = false)
	@MapsId("organisationid")
	private Organisation organisation;
	
	@ManyToOne
	@JoinColumn(name = "ROLE_ID", insertable = false, updatable = false)
	@MapsId("roleid")
	private Role role;

	/**
	 * @return the id
	 */
	public Id getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Id id) {
		this.id = id;
	}

	/**
	 * @return the utilisateur
	 */
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	/**
	 * @param utilisateur the utilisateur to set
	 */
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	/**
	 * @return the organisation
	 */
	public Organisation getOrganisation() {
		return organisation;
	}

	/**
	 * @param organisation the organisation to set
	 */
	public void setOrganisation(Organisation organisation) {
		this.organisation = organisation;
	}

	/**
	 * @return the role
	 */
	public Role getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(Role role) {
		this.role = role;
	}
	
}
