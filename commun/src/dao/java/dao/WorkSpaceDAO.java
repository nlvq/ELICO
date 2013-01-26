package dao;

import java.util.List;

import ws.WorkSpace;

public interface WorkSpaceDAO {
	public void createWS(String name,WorkSpaceDAO parentWs,String orga, List<WorkSpace> list) ;
	public void acquireWP(WorkSpace wp) ;
	public void promoteWP(WorkSpace wp) ;
	public void publishWP(WorkSpace wp) ;
	public void synchronizeWP(WorkSpace wp) ;
}
