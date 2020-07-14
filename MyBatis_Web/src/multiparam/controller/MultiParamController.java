package multiparam.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import multiparam.dao.MultiParamDao;
import mybatis.MyBatisConnectionFactory;


@WebServlet("/multi/param")
public class MultiParamController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//마이바티스 연결 객체 
	private static SqlSessionFactory factory = MyBatisConnectionFactory.getSqlSessionFactory();

	//마이바티스 수행 객체
	private SqlSession sqlSession;
	
	private MultiParamDao multParamDao;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		sqlSession = factory.openSession(true);
		
		multParamDao = sqlSession.getMapper(MultiParamDao.class);
		
		//----------------------------------------------------------
		
		System.out.println("multi/param [GET]");
		
		//DTO를 이용한 파라미터 전달
//		Emp emp = new Emp();
//		emp.setEmpno(5004);
//		emp.setEname("C");
//		emp.setJob("ACC");
//		
//		multParamDao.insert(emp);
	
		//----------------------------------------------------------
		
		//여러 개의 파라미터 전달
//		multParamDao.insert2(5011, "HDD", null);

		//----------------------------------------------------------
		
		//HashMap을 파라미터 전달하는 방법
		HashMap<String, Object> map = new HashMap<>();
		
		map.put("empno", 5012);
		map.put("ename", "SDD");
		map.put("job", "SDDDDD");
		
		multParamDao.insert3(map);
		
		
		
	}

}
