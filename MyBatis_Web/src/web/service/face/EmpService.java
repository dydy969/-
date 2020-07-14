package web.service.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import web.dto.Emp;
import web.dto.test_member;

public interface EmpService {

	//전체 조회
	public List<Emp> getList();

	//상세 조회
	public Emp empDetail(Emp param);

	//empno 전달 파라미터 얻기
	public Emp getEmpnoParam(HttpServletRequest req);

	

}
