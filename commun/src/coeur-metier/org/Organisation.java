package org;

import java.util.List;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

public class Organisation {
	@OneToMany
	private List<Organisation> orgFils;
	@OneToOne
	private List<Organisation> orgPere;
	@OneToOne
	private Role role;
	
}
