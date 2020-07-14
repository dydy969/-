package dept.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import dept.dto.Dept;

public interface DeptDao {

	//전체 조회
	public List<Dept> selectAll();

	public Dept selectInfo(Dept dept);

	
	public void deptInsert(Dept dept);



}
