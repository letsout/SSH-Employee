package service;

import entity.Employee;
import entity.PageBean;

/*
 * 员工管理的业务成接口
 */
public interface EmployeeService {

	Employee login(Employee employee);

	PageBean<Employee> findByPage(Integer currPage);

	void add(Employee employee);

	void delete(Employee existEmployee);

	Employee findById(Integer eid);

	void update(Employee employee);
	
}
