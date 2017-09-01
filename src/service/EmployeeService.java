package service;

import entity.Employee;
import entity.PageBean;

/*
 * Ա�������ҵ��ɽӿ�
 */
public interface EmployeeService {

	Employee login(Employee employee);

	PageBean<Employee> findByPage(Integer currPage);

	void add(Employee employee);

	void delete(Employee existEmployee);

	Employee findById(Integer eid);

	void update(Employee employee);
	
}
