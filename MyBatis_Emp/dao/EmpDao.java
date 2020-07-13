package dao;

import java.util.List;

import dto.Emp;

public interface EmpDao {

	// Emp 테이블의 전체 조회
	public  List<Emp> selectAll();

	// Emp 테이블의 where = EmpNo 행 조회
	public Emp selectByEmpNo(int empno);

	// Emp 컬럼 추가 구간 
	public void insert(Emp insertEmp);

	// Emp 테이블의 where = Empno 행 삭제
	public void deletByEmpno(Emp deleteEmp);
		




}
