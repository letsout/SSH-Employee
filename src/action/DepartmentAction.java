package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import entity.Department;
import entity.PageBean;
import service.DepartmentService;

/*
 * 部门管理action类
 */
public class DepartmentAction extends ActionSupport implements ModelDriven<Department> {
	//模型驱动
	private Department department = new Department();
	@Override
	public Department getModel() {
		
		return department;
	}
	//注入部门管理的service
	private DepartmentService  departmentService;
	
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	//分页查询currPage
	private Integer currPage=1;
	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}
	//findAll
	public String findAll() {
		
	PageBean<Department> pageBean = departmentService.findByPage(currPage);
	//将pageBean存入值站中
	ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}
	
	//添加部门跳转页面
	public String saveDepartment() {
		return "saveUI";
	}
	
	public String save() {
		departmentService.save(department);
		return "saveSuccess";
	}
	
	//更具id查询
	public String edit() {
		department=	departmentService.findById(department.getDid());
		return "editSuccess";
	}
	
	//修改部门
	public String update() {
		departmentService.update(department);
		return "updateSuccess";
	}
	
	
	//删除
	public String delete() {
		department=departmentService.findById(department.getDid());
		departmentService.delete(department);
		return "deleteSuccess";
	}
}
