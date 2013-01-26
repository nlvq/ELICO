package dao;

import java.util.List;

import ws.WorkSpace;

public interface IWPDAO {
	public void createWP(WorkSpace wp) ;
	public void updateWP(WorkSpace wp) ;
	public void deleteWP(WorkSpace wp) ;
	public List<WorkSpace> findWorkPackage(int id) ;
}
