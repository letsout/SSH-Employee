package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import entity.Department;
import entity.PageBean;
import service.DepartmentService;

/*
 * ���Ź���action��
 */
public class DepartmentAction extends ActionSupport implements ModelDriven<Department> {
	//ģ������
	private Department department = new Department();
	@Override
	public Department getModel() {
		
		return department;
	}
	//ע�벿�Ź����service
	private DepartmentService  departmentService;
	
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	//��ҳ��ѯcurrPage
	private Integer currPage=1;
	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}
	//findAll
	public String findAll() {
		
	PageBean<Department> pageBean = departmentService.findByPage(currPage);
	//��pageBean����ֵվ��
	ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}
	
	//��Ӳ�����תҳ��
	public String saveDepartment() {
		return "saveUI";
	}
	
	public String save() {
		departmentService.save(department);
		return "saveSuccess";
	}
	
	//����id��ѯ
	public String edit() {
		department=	departmentService.findById(department.getDid());
		return "editSuccess";
	}
	
	//�޸Ĳ���
	public String update() {
		departmentService.update(department);
		return "updateSuccess";
	}
	
	
	//ɾ��
	public String delete() {
		department=departmentService.findById(department.getDid());
		departmentService.delete(department);
		return "deleteSuccess";
	}
}
