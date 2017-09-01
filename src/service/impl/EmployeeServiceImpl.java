package service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import dao.EmployeeDao;
import entity.Employee;
import entity.PageBean;
import service.EmployeeService;
/*
 * 员工管理的业务层实现类
 */
@Transactional
public class EmployeeServiceImpl implements EmployeeService{
	private  EmployeeDao  employeeDao;
	 
	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	@Override
	public Employee login(Employee employee) {
		
		Employee existEmployee=employeeDao.findBuyPasswordAndUsername(employee);
		return existEmployee;
	}

	@Override
	//封装分页查询
	public PageBean<Employee> findByPage(Integer currPage) {
		PageBean<Employee> pageBean = new PageBean<Employee>();
		//封装当前页数
		pageBean.setCurrPage(currPage);
		//封装每页显示数
		int pageSize=3;
		pageBean.setPageSize(pageSize);
		//封装总记录数
		int totalCount=employeeDao.findCount();
		pageBean.setTotalCount(totalCount);
		//封装总页数
		double tc = totalCount;
		double num=Math.ceil(tc/pageSize);
		pageBean.setTotalPage(new Double(num).intValue());
		//封装每页显示数据
		int begin = (currPage-1)*pageSize;
		List<Employee> list= employeeDao.findByPage(begin,pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	//添加员工
	public void add(Employee employee) {
		employeeDao.add(employee);
	}

	@Override
	//删除员工
	public void delete(Employee employee) {
		employeeDao.delete(employee);
	}

	@Override
	//根据id查询
	public Employee findById(Integer eid) {
		Employee existEmployee = employeeDao.findById(eid);
		return existEmployee;
	}

	@Override
	//修改员工信息
	public void update(Employee employee) {
		employeeDao.update(employee);
	}


}
