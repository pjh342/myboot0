package mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmpMybatisController {
	@Autowired
	EmpService service;
	
	//select * from employees ===> List<EmpVO> 리턴
	
	@RequestMapping("/emplist")
	public ModelAndView emplist() {
		List<EmpVO> list = service.getEmpList();
		ModelAndView mv = new ModelAndView();
		mv.addObject("emplist", list);
		mv.setViewName("/mybatis/emplist");
		return mv;
	}
	
	
	@RequestMapping(value="/empdeptlist", method=RequestMethod.GET) 
		public String empDeptForm() {
			return "/mybatis/empdeptform";
		}
		
	
	@RequestMapping(value="/empdeptlist", method=RequestMethod.POST) 
	public ModelAndView empDeptList(int [] dept_list) { //여러개 저장, 정수타입 형변환 자동
		List<EmpVO> deptlist = service.empDeptList(dept_list);
		ModelAndView mv = new ModelAndView();
		mv.addObject("empdeptlist", deptlist);
		mv.setViewName("/mybatis/empdeptlist.jsp");
		return mv;
	}
 	
		
		
	}
	

