package org;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import ws.WorkSpace;

public class Personne {

	@Id @GeneratedValue
	@Column(name="id_personne")
	private int id;
	@Column
	private String name;
	@Column
	private Organisation org;
	@Column
	private String savoirFair;
	@OneToMany(mappedBy = "personne", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	private List<WorkSpace> ws;

}
