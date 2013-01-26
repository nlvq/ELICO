package ws;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.Organisation;
import org.Personne;


@Entity
@Table
public class WorkSpace {
	@Id @GeneratedValue
	@Column(name="id_ws")
	private int id;
	@OneToMany(mappedBy = "workspace", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	private List<WorkSpace> wsFils;
	@OneToOne
	private Organisation org;
	@ManyToOne(cascade=CascadeType.PERSIST, fetch=FetchType.LAZY)
	@JoinColumn(name="id_personne")
	private Personne personne;
	
}
