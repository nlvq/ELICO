package coeur_metier.ws;

import java.util.List;

import dao.WorkPackage;
import dao.WorkSpace;

public interface IWS {
	public void createWS(String name, WorkSpace parentWs, String orga, List<WorkSpace> list);
	public void acquireWP(WorkPackage wp);
	public void promoteWP(WorkPackage wp);
	public void publishWP(WorkPackage wp);
	public void synchronizeWP(WorkPackage wp);
}
