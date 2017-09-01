package service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import dao.EmployeeDao;
import entity.Employee;
import entity.PageBean;
import service.EmployeeService;
/*
 * Ա�������ҵ���ʵ����
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
	//��װ��ҳ��ѯ
	public PageBean<Employee> findByPage(Integer currPage) {
		PageBean<Employee> pageBean = new PageBean<Employee>();
		//��װ��ǰҳ��
		pageBean.setCurrPage(currPage);
		//��װÿҳ��ʾ��
		int pageSize=3;
		pageBean.setPageSize(pageSize);
		//��װ�ܼ�¼��
		int totalCount=employeeDao.findCount();
		pageBean.setTotalCount(totalCount);
		//��װ��ҳ��
		double tc = totalCount;
		double num=Math.ceil(tc/pageSize);
		pageBean.setTotalPage(new Double(num).intValue());
		//��װÿҳ��ʾ����
		int begin = (currPage-1)*pageSize;
		List<Employee> list= employeeDao.findByPage(begin,pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	//���Ա��
	public void add(Employee employee) {
		employeeDao.add(employee);
	}

	@Override
	//ɾ��Ա��
	public void delete(Employee employee) {
		employeeDao.delete(employee);
	}

	@Override
	//����id��ѯ
	public Employee findById(Integer eid) {
		Employee existEmployee = employeeDao.findById(eid);
		return existEmployee;
	}

	@Override
	//�޸�Ա����Ϣ
	public void update(Employee employee) {
		employeeDao.update(employee);
	}


}
