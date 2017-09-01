package service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import dao.DepartmentDao;
import entity.Department;
import entity.PageBean;
import service.DepartmentService;
/*
 * 部门管理业务实现类
 */
@Transactional
public class DepartmentServiceImpl  implements DepartmentService{
	private DepartmentDao departmentDao;

	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}

	@Override
	//分页查询方法
	public PageBean<Department> findByPage(Integer currPage) {
		PageBean<Department> pageBean = new PageBean<Department>();
		//封装当前页数
		pageBean.setCurrPage(currPage);
		//封装每页显示记录数
		int pageSize = 3;
		pageBean.setPageSize(pageSize);
		//封装总记录数
		int totalCount = departmentDao.findCount();
		pageBean.setTotalCount(totalCount);
		//封装总页数
		double tc = totalCount;
		double num=Math.ceil(tc/pageSize);
		pageBean.setTotalPage(new Double(num).intValue());
		//封装每页显示的数据
		int begin = (currPage-1)*pageSize;
		List<Department> list=departmentDao.findByPage(begin,pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	//添加部门
	public void save(Department department) {
		departmentDao.save(department);
	}

	@Override
	//更具部门id查询
	public Department findById(Integer did) {
	Department department=	departmentDao.findById(did);
		return department;
	}

	@Override
	//修改部门
	public void update(Department department) {
	departmentDao.update(department);
	}

	@Override
	//删除
	public void delete(Department department) {
		departmentDao.delete(department);
	}

	@Override
	//查找所有部门
	public List<Department> findAll() {
		List<Department> list=departmentDao.findAll();
		return list;
	}
}
