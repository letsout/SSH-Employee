package service;

import java.util.List;

import entity.Department;
import entity.PageBean;

/*
 * ���Ź���ҵ��ӿ�
 */
public interface DepartmentService {

	PageBean<Department> findByPage(Integer currPage);

	void save(Department department);

	Department findById(Integer did);

	void update(Department department);

	void delete(Department department);

	List<Department> findAll();
	


}
