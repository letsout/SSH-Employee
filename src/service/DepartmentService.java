package service;

import java.util.List;

import entity.Department;
import entity.PageBean;

/*
 * 部门管理业务接口
 */
public interface DepartmentService {

	PageBean<Department> findByPage(Integer currPage);

	void save(Department department);

	Department findById(Integer did);

	void update(Department department);

	void delete(Department department);

	List<Department> findAll();
	


}
