package dao;

import java.util.List;


public interface IWSDAO {
	public void createWS(WorkSpaceDAO ws) ;
	public void updateWS(WorkSpaceDAO ws) ;
	public void deleteWS(WorkSpaceDAO ws) ;
	public List<WorkSpaceDAO> findWorkSpace(int id) ;
}
