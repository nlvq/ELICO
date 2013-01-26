package wp;

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

import org.Personne;
import org.joda.time.DateTime;
import ws.WorkSpace;

@Entity
@Table 
public class WorkPackage {

	@Id @GeneratedValue
	@Column(name="id_package")
	private int id;

	@Column(name="Author", unique=true)
	private Personne autheur;
	@Column
	private DateTime date;
	@OneToMany(mappedBy = "workpackage", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	private List<WorkPackage> composition;
	@OneToMany(mappedBy = "workpackage", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	private List<Contenaire> conteneur;
	
	private String version;
	@OneToOne(optional=true)
	private WorkSpace ws;

}
