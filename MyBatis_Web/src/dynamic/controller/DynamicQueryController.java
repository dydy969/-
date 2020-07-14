package dynamic.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dynamic.dao.DynamicQueryDao;
import mybatis.MyBatisConnectionFactory;
import web.dto.Emp;


@WebServlet("/dynamic/query")
public class DynamicQueryController extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
   private static SqlSessionFactory sqlSessionFactory
   = MyBatisConnectionFactory.getSqlSessionFactory();
   
   SqlSession sqlSession ;
   DynamicQueryDao dynamicQueryDao;
   
   
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      sqlSession = sqlSessionFactory.openSession(true);//AutoCommit
      
      dynamicQueryDao = sqlSession.getMapper(DynamicQueryDao.class);
      
      //List<HashMap<String, Object>> list = dynamicQueryDao.select();
      
//      for(Object object : list) {
//         System.out.println(object);
//      }
      
      //request.setAttribute("list", list);
      //request.getRequestDispatcher("/WEB-INF/views/result2.jsp").forward(request, response);
      
      //----------------------------------------------------------------------
      
      //List res2 = dynamicQueryDao.select2("FORD");//ename이 FORD인 행이 조회가 된다 
      //List res2 = dynamicQueryDao.select2(null);//전체조회가 된다
      //List res2 = dynamicQueryDao.select2("");//전체조회가 된다
//      List res2 = dynamicQueryDao.select2("S");//ename에 S가 들어간 행만 조회된다
//      
//      Emp emp =new Emp();
//      
//      emp.setEmpno(7369);
//      emp.setEname("KING");
//      
//      List res3 = dynamicQueryDao.select3(emp);//ename에 S가 들어간 행만 조회된다 
//      
//      System.out.println(res3);
      
      //---------------------------------------------------------------
      
      
      //2개의 파라미터를 이용해 조회하기 HashMap이용 
//      HashMap<String, Object> map = new HashMap<>();
//      map.put("category","ename");
//      map.put("keyword", "SMITH");
//      
//      List<Emp> res4 = dynamicQueryDao.select4(map);
//      
//      
//      System.out.println(res4);
//      
//      
//      System.out.println("-----------------------------------------------");
//      
//      map.put("category","job");
//      map.put("keyword", "SALESMAN");
//      
//      List<Emp> res5 = dynamicQueryDao.select4(map);
//      
//      
//      System.out.println(res5);
//      
    
      //-----------------------------------------------------------------------------
      
      request.getRequestDispatcher("/WEB-INF/views/dynamic/queryCheckbox.jsp")
      	.forward(request, response);
      
   }
   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	   
	   //전달 파라미터가 하나의 값일 떄만 getParameter를 써야함
//	   String data = req.getParameter("deptno");
//	   System.out.println(data);	//전달된 데이터 중 한 개만 꺼내옴
	   
	   //--------------------------------------------------------------
	   
	   String[] dataArr = req.getParameterValues("deptno");
	   System.out.println(Arrays.toString(dataArr));
	   
	   HashMap<String, Object> map = new HashMap<>();
	   map.put("deptnoArr", dataArr);
	   
	   List<Emp> list = dynamicQueryDao.selectCheckbox(map);
	   
	   for (Emp emp : list) {
		System.out.println(emp);
	}
	   
	   req.setAttribute("list", list);
	   req.getRequestDispatcher("/WEB-INF/views/dynamic/myCheckbox.jsp")
	   	.forward(req, resp);
   
   }

}