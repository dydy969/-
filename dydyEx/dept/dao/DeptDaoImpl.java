package dept.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dept.dto.Dept;
import mybatis.MyBatisConnectionFactory;

public class DeptDaoImpl implements DeptDao {

	private HashMap map;
	
	private String namespace = "dept.dao.DeptDao.";
	
	private SqlSessionFactory factory = MyBatisConnectionFactory.getSqlSessionFactory();
	
	
	@Override
	public List<Dept> selectAll() {

		SqlSession sqlSession = factory.openSession(true);
		
		List<Dept> list = sqlSession.selectList(namespace+"selectAll");
		
		return list;
	}


	@Override
	public Dept deptDetail(Dept dept) {
		
		SqlSession sqlSession = factory.openSession(true);
		
		Dept detail = sqlSession.selectOne(namespace + "deptDetail", dept);
		
		
		return detail;
	}


	@Override
	public void deptInsert(Dept dept) {

		SqlSession sqlSession = factory.openSession(true);
		
		sqlSession.insert(namespace + "deptInsert", dept);
		
	}

}
