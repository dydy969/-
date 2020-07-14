package web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.MyBatisConnectionFactory;
import web.dao.EmpDao;
import web.dto.test_member;
import web.service.face.EmpService;
import web.service.impl.EmpServiceImpl;

/**
 * Servlet implementation class SelectKeyController
 */
@WebServlet("/mybatis/selectKey")
public class SelectKeyController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	//마이바티스 연결 객체 
	private static SqlSessionFactory factory = MyBatisConnectionFactory.getSqlSessionFactory();

	private EmpService empService = new EmpServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// id, pw 띄우기
		req.getRequestDispatcher("/WEB-INF/views/member/member.jsp")
			.forward(req, resp);
	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		//doget으로 form띄우고
		//dopost으로 처리
		//insert처리
		
		//요청 파라미터 추출
		test_member param = new test_member();
		
		param.setId(req.getParameter("id"));
		param.setPw(req.getParameter("pw"));

		System.out.println(param);
		
		SqlSession sqlSession = factory.openSession(true);//Auto Commit
		
		EmpDao empDao = sqlSession.getMapper(EmpDao.class);
		
		empDao.insert(param);
		
		req.setAttribute("param", param);
		req.getRequestDispatcher("/WEB-INF/views/member/memberList.jsp")
			.forward(req, resp);
		
	}
}
