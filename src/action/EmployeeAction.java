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
	//ʹ������ģ�͵Ķ���
	private Employee employee = new Employee();
	@Override
	public Employee getModel() {
		
		return employee;
	}
	//ע��ҵ�����
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
		//����ҵ������
		Employee existEmployee=employeeService.login(employee);
		System.out.println(existEmployee);
		if(existEmployee==null) {
			//ʧ��
			this.addActionError("�û������������!");
			return INPUT;
		}else {
			//�ɹ�
			ServletActionContext.getRequest().getSession().setAttribute("existEmployee", existEmployee);
			return SUCCESS;
		}
	}
	//��ҳ��ѯ
	private Integer currPage=1;
	
	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}

	//��ѯ����Ա��
	public String findAll() {
	PageBean<Employee> pageBean=employeeService.findByPage(currPage);
	//��pagebean�����ֵվ��
	ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}
	
	//���Ա����תҳ��
	public String save() {
		List<Department> list=departmentService.findAll();
		ActionContext.getContext().getValueStack().set("list", list);
		return "save";
	}
	
	//Ա�����
	public String add() {
		employeeService.add(employee);
		return "addSuccess";
	}
	//����id��ѯ
	public String findById() {
		Employee existEmployee = employeeService.findById(employee.getEid());
		return "findSuccess";
	}
	//ɾ��Ա��
	public String delete() {
		Employee existEmployee =employeeService.findById(employee.getEid());
		employeeService.delete(existEmployee);
		return "deleteSuccess";
	}
	
	//�޸�Ա��������ת
	public  String edit () {
		employee=employeeService.findById(employee.getEid());
		List<Department> list=departmentService.findAll();
		ActionContext.getContext().getValueStack().set("list", list);
		return "edit";
	}
	
	//�޸�Ա����Ϣ
	public String update() {
		employeeService.update(employee);
		return "updateSuccess";
	}
}
