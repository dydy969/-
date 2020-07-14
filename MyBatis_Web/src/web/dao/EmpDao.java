package web.dao;

import java.util.List;

import web.dto.Emp;
import web.dto.test_member;


public interface EmpDao {
	
	//전체 조회
	public List<Emp> selectAll();

	//상세 조회
	public Emp empnoDetail(Emp param);

	public void insertMember(test_member member);

	// test_member 입력
	public void insert(test_member param);

	
	
	
}
