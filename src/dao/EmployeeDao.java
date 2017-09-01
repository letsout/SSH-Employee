package dao;

import java.util.List;

import entity.Employee;

/*
 * 员工管理Dao接口
 */
public interface EmployeeDao {
	
	Employee findBuyPasswordAndUsername(Employee employee);

	List<Employee> findByPage(int begin, int pageSize);

	int findCount();

	void add(Employee employee);

	Employee findById(Integer eid);

	void delete(Employee employee);

	void update(Employee employee);

}
