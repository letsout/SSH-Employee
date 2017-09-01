package action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import entity.Department;
import entity.Employee;
import entity.PageBean;
import service.DepartmentService;
import service.EmployeeService;

public class EmployeeAction extends  ActionSupport implements ModelDriven<Employee>{
	//使用驱动模型的对象
	private Employee employee = new Employee();
	@Override
	public Employee getModel() {
		
		return employee;
	}
	//注入业务层类
	private EmployeeService employeeService;
	
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	private DepartmentService departmentService;
	

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	//login
	public String login() {
		System.out.println("login");
		//调用业务层的类
		Employee existEmployee=employeeService.login(employee);
		System.out.println(existEmployee);
		if(existEmployee==null) {
			//失败
			this.addActionError("用户名或密码错误!");
			return INPUT;
		}else {
			//成功
			ServletActionContext.getRequest().getSession().setAttribute("existEmployee", existEmployee);
			return SUCCESS;
		}
	}
	//分页查询
	private Integer currPage=1;
	
	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}

	//查询所有员工
	public String findAll() {
	PageBean<Employee> pageBean=employeeService.findByPage(currPage);
	//将pagebean存放在值站中
	ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}
	
	//添加员工跳转页面
	public String save() {
		List<Department> list=departmentService.findAll();
		ActionContext.getContext().getValueStack().set("list", list);
		return "save";
	}
	
	//员工添加
	public String add() {
		employeeService.add(employee);
		return "addSuccess";
	}
	//根据id查询
	public String findById() {
		Employee existEmployee = employeeService.findById(employee.getEid());
		return "findSuccess";
	}
	//删除员工
	public String delete() {
		Employee existEmployee =employeeService.findById(employee.getEid());
		employeeService.delete(existEmployee);
		return "deleteSuccess";
	}
	
	//修改员工界面跳转
	public  String edit () {
		employee=employeeService.findById(employee.getEid());
		List<Department> list=departmentService.findAll();
		ActionContext.getContext().getValueStack().set("list", list);
		return "edit";
	}
	
	//修改员工信息
	public String update() {
		employeeService.update(employee);
		return "updateSuccess";
	}
}
