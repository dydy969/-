package dept.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dept.dao.DeptDao;
import dept.dao.DeptDaoImpl;
import dept.dto.Dept;

/**
 * Servlet implementation class DeptDetailController
 */
@WebServlet("/dept/detail")
public class DeptDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DeptDao deptDao = new DeptDaoImpl();
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		//deptno 추출
		
		Dept dept = new Dept();
		
		dept.setDeptno(Integer.parseInt(req.getParameter("deptno")));
		
		
		Dept detail = deptDao.deptDetail(dept);
		
		req.setAttribute("detail", detail);
		req.getRequestDispatcher("/WEB-INF/views/dept/detail.jsp")
			.forward(req, resp);
	}
	
}
