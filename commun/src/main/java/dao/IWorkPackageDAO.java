package dao;

import java.util.List;



public interface IWorkPackageDAO {
	public void createWorkPackage(WorkPackage wp) ;
	public void updateWorkPackage(WorkPackage wp) ;
	public void deleteWorkPackage(WorkPackage wp) ;
	public List<WorkPackage> findWorkPackage(String id) ;
}
