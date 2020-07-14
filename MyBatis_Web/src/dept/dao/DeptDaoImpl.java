package dept.dao;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dept.dto.Dept;
import mybatis.MyBatisConnectionFactory;

public class DeptDaoImpl implements DeptDao {

	private SqlSessionFactory factory = MyBatisConnectionFactory.getSqlSessionFactory();
			
	private String namespace = "dept.dao.DeptDao.";
	
	private HashMap map;
	
	
	//마이바티스 객체 생성	
	@Override
	public List<Dept> selectAll() {
		
		//마이바티스 수행 객체
		SqlSession sqlSession = factory.openSession();
																	//(Object) , map						
		List<Dept> deptList = sqlSession.selectList(namespace + "selectAll");
		
//		sqlSession.commit();
//		sqlSession.clearCache();
		sqlSession.close();
		
		return deptList;
	}


	@Override
	public Dept selectInfo(Dept dept) {
		
		//마이바티스 수행 객체
		SqlSession sqlSession = factory.openSession();
		
		Dept detail = sqlSession.selectOne(namespace + "selectInfo",dept);
		
		sqlSession.close();
		
		return detail;
	}


	@Override
	public void deptInsert(Dept dept) {

		//마이바티스 수행 객체
		// factory.openSession() 전달인자 안에 true 는 Auto Commit !!!
		SqlSession sqlSession = factory.openSession(true);
		
		int res= sqlSession.insert(namespace + "deptInsert",dept);
		
		//SqlSession.insert 는 테이블의 영향박은 행 수를 반환한다
		// Update, delete도 마찬가지
		if(res > 0) {
			System.out.println("삽입성공");
		} else {
			System.out.println("삽입 실패");
		}
	}

}
