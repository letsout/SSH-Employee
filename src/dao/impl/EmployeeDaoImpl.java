package dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.HibernateTemplate;

import dao.EmployeeDao;
import entity.Employee;
/*
 * 员工管理dao实现类
 */
public class EmployeeDaoImpl  implements EmployeeDao {
	private HibernateTemplate  hibernateTemplate;

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}


	public Employee findBuyPasswordAndUsername(Employee employee) {
		String hql="from Employee where username=? and password=?";
		List<Employee> list=(List<Employee>) hibernateTemplate.find(hql, employee.getUsername(),employee.getPassword());
		if(list.size()>0) {
			return list.get(0) ;
		}
		return null;
	}


	@Override
	//分页查询
	public List<Employee> findByPage(int begin, int pageSize) {
		DetachedCriteria  criteria = DetachedCriteria.forClass(Employee.class);
		List<Employee> list=(List<Employee>) hibernateTemplate.findByCriteria(criteria, begin, pageSize);
		return list;
	}


	@Override
	//查询总数
	public int findCount() {
		String hql="select count(*) from Employee";
		List<Long> list= (List<Long>) hibernateTemplate.find(hql);
		if(list.size()>0) {
			return list.get(0).intValue();
		}	
		return 0;
	}


	@Override
	//添加员工
	public void add(Employee employee) {
		hibernateTemplate.save(employee);
	}


	@Override
	//根据id查询员工
	public Employee findById(Integer eid) {
		Employee	existEmployee = hibernateTemplate.get(Employee.class, eid);
		return existEmployee;
	}


	@Override
	//删除员工
	public void delete(Employee employee) {
		hibernateTemplate.delete(employee);
	}


	@Override
	public void update(Employee employee) {
		hibernateTemplate.update(employee);
	}

}
