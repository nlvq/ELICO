package dao;

import java.util.List;

public interface WorkPackageDAO {
	public void createWP(String name, List<Object> liste) ;
	public void updateWP(WorkPackageDAO wp) ;
	public WorkPackageDAO findWP(WorkPackageDAO wp) ;
	public void lockWP(int id) ;
	public void unlockWP(int id) ;
	public void requestValidation(int id) ;
	public void accept(int id) ;
	public void refuse(int id,String reason) ;
}
