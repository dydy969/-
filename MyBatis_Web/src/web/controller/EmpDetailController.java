package web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.dto.Emp;
import web.service.face.EmpService;
import web.service.impl.EmpServiceImpl;

/**
 * Servlet implementation class EmpDetailController
 */
@WebServlet("/emp/detail")
public class EmpDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	private EmpService empService = new EmpServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("emp/detail [GET] ");
		
		// 전달 파라미터 얻기 - name="empno" - EmpService
		Emp param = empService.getEmpnoParam(req);
		System.out.println("EmpDetailController" + param);
		
		//사원 정보 empno 상세 조회	
//		Emp empno = new Emp();
		Emp empno = empService.empDetail(param);
//		
		req.setAttribute("empno", empno);
		
		req.getRequestDispatcher("/WEB-INF/views/emp/detail.jsp")
			.forward(req, resp);
	}
}
