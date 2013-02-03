package dao;

public class Maturite {
	public enum Etat{WORK,RELEASE_CANDIDATE, RELEASE};
	
	private Etat avancement;
	
	
	public Etat getAvancement() {
		return avancement;
	}
	public void setAvancement(Etat avancement) {
		this.avancement = avancement;
	}
}
