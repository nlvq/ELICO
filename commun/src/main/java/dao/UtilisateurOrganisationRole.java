package dao;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
		private Long idu;
		
		@Column(name = "ORGANISATION_ID")
		private Long ido;
		
		@Column(name = "ROLE_ID")
		private Long idr;

		/**
		 * @return the idu
		 */
		public Long getIdu() {
			return idu;
		}

		/**
		 * @param idu the idu to set
		 */
		public void setIdu(Long idu) {
			this.idu = idu;
		}

		/**
		 * @return the ido
		 */
		public Long getIdo() {
			return ido;
		}

		/**
		 * @param ido the ido to set
		 */
		public void setIdo(Long ido) {
			this.ido = ido;
		}

		/**
		 * @return the idr
		 */
		public Long getIdr() {
			return idr;
		}

		/**
		 * @param idr the idr to set
		 */
		public void setIdr(Long idr) {
			this.idr = idr;
		}
		
	}

	@EmbeddedId
	private Id id = new Id();
	
	@ManyToOne
	@JoinColumn(name = "UTILISATEUR_ID", insertable = false, updatable = false)
	private Utilisateur utilisateur;
	
	@ManyToOne
	@JoinColumn(name = "ORGANISATION_ID", insertable = false, updatable = false)
	private Organisation organisation;
	
	@ManyToOne
	@JoinColumn(name = "ROLE_ID", insertable = false, updatable = false)
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
