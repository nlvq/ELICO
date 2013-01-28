package dao;

import java.util.List;



public interface IWorkSpaceDAO {
	public void createWorkSpace(WorkSpace ws) ;
	public void updateWorkSpace(WorkSpace ws) ;
	public void deleteWorkSpace(WorkSpace ws) ;
	public List<WorkSpace> findWorkSpace(String id) ;
}
