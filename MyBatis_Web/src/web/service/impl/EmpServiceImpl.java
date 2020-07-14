package web.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.MyBatisConnectionFactory;
import web.dao.EmpDao;
import web.dto.Emp;
import web.dto.test_member;
import web.service.face.EmpService;


public class EmpServiceImpl implements EmpService {

	//마이바티스 연결 객체 
	private static SqlSessionFactory factory = MyBatisConnectionFactory.getSqlSessionFactory();

	//DAO 객체
	private EmpDao empDao;
	
	@Override
	public List<Emp> getList() {

		//마이바티스 수행 객체
		//AutoCommit
		SqlSession sqlSession = factory.openSession(true);
		
		//매퍼를 이용한 DAO 연결
		empDao = sqlSession.getMapper(EmpDao.class);
		
		//전체 리스트 조회
		List<Emp> list = empDao.selectAll();
		
//		sqlSession.commit();
//		sqlSession.rollback();
		
//		sqlSession.close();
		
		return list;
	}


	@Override
	public Emp getEmpnoParam(HttpServletRequest req) {

		//전달 파라미터 추출
		String param = req.getParameter("empno");
		
		//String -> int형 변환
		int empno = 0;
		if( param != null && !"".equals(param)) {
			empno = Integer.parseInt(param);
		}
		
		// 리턴 데이터 생성
		Emp res = new Emp();
		res.setEmpno(empno);
		
		return res;
	}


	@Override
	public Emp empDetail(Emp param) {
		SqlSession sqlSession = factory.openSession(true);
		empDao = sqlSession.getMapper(EmpDao.class);
		
		Emp result = empDao.empnoDetail(param);
		return result;
	}


	
	
}
