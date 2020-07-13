package controller;

import java.util.List;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dao.EmpDao;
import dto.Emp;
import mybatis.MyBatisConnectionFactory;
import sun.net.www.http.Hurryable;

public class EmpEx {

	//DB 접속 및 SqlSession생성 팩토리 객체
	private static SqlSessionFactory sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
	
	public static void main(String[] args) {
	
		//마이바티스 수행 객체
		//Auto 커밋 true		
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		
		//마이바티스의 매퍼와 자바프로그램의 DAO 인터 페이스 매핑(연결)
		EmpDao empDao = sqlSession.getMapper(EmpDao.class);
		
		Scanner sc = new Scanner(System.in);
		
//----------------------------------------------------------------		
//		sqlSession.getMapper(arg0)
//		
//		sqlSession.selectOne();
//		sqlSession.selectList();
//		sqlSession.selectMap();
//		
//		sqlSession.insert();
//		sqlSession.update();
//		sqlSession.delete();
//		
//		sqlSession.commit();
//		sqlSession.rollback();
//		
//		sqlSession.close();
		
//--------------------------------------------------------------		
		// 전체 조회
		List<Emp> list = empDao.selectAll();
		
		for(Emp emp : list) {
			System.out.print(emp);
		}
		System.out.println("---출력 완료 --");
		
		
		
		
//		Emp테이블 입력
		
		System.out.print("EMP 입력하세요 ");
		Emp insertEmp = new Emp();
		
		System.out.print("empno : ");
		insertEmp.setEmpno(sc.nextInt());
		
		System.out.print("Ename : ");
		sc.nextLine(); //입력 버퍼 지우기
		insertEmp.setEname(sc.nextLine());
		
		System.out.print("Job : ");
		insertEmp.setJob(sc.nextLine());
		
		System.out.print("Mgr : ");
		insertEmp.setMgr(sc.nextInt());
		
		System.out.print("hiredate  yyyy-MM-dd : ");
		sc.nextLine(); //버퍼 지우기
		String input = sc.nextLine();

		// String -> java.util.Date : SimpleDateFormat 이용
		SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd");
		Date hiredate = null;
		
		try {
			hiredate = form.parse(input);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		insertEmp.setHiredate(hiredate);
		
//		inseremp.setHiredate(new Date());
		
		System.out.print("Sal : ");
		insertEmp.setSal(sc.nextInt());
		
		System.out.print("Comm : ");
		insertEmp.setComm(sc.nextInt());
		
		System.out.print("DeptNo : ");
		insertEmp.setDeptno(sc.nextInt());
		
		empDao.insert(insertEmp);

		System.out.println("---입력 완료 --");
		
		
		// 부서번호 조회
		System.out.print("empno 조회 : ");
		int empno = sc.nextInt();
		Emp no = empDao.selectByEmpNo(empno);
		System.out.print(no);
		
		System.out.println("---출력 완료 --");
		
		//empno테이블 삭제
		
//		System.out.print("EMP테이블의 empno 삭제");
//		Emp deleteEmp = new Emp();
//		
//		System.out.print("empno 삭제 : ");
//		deleteEmp.setEmpno(sc.nextInt());
//		
//		empDao.deletByEmpno(deleteEmp);
//		
		System.out.println("---삭제 완료 --");
		
	}
	
}


