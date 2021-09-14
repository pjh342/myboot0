package mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface EmpDAO {


	public List<EmpVO> emplist();

	
	
	
	public EmpVO getEmpOne(int id);
	
	public void insertEmp(EmpVO vo);
	
	public void updateEmp(EmpVO vo);
	
	public void deleteEmp(String name);
	
	public int countEmp();
	
	public List<EmpVO>  empDeptList(int [] dept_list);
}



