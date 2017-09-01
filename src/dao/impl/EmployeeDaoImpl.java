package dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.HibernateTemplate;

import dao.EmployeeDao;
import entity.Employee;
/*
 * Ա������daoʵ����
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
	//��ҳ��ѯ
	public List<Employee> findByPage(int begin, int pageSize) {
		DetachedCriteria  criteria = DetachedCriteria.forClass(Employee.class);
		List<Employee> list=(List<Employee>) hibernateTemplate.findByCriteria(criteria, begin, pageSize);
		return list;
	}


	@Override
	//��ѯ����
	public int findCount() {
		String hql="select count(*) from Employee";
		List<Long> list= (List<Long>) hibernateTemplate.find(hql);
		if(list.size()>0) {
			return list.get(0).intValue();
		}	
		return 0;
	}


	@Override
	//���Ա��
	public void add(Employee employee) {
		hibernateTemplate.save(employee);
	}


	@Override
	//����id��ѯԱ��
	public Employee findById(Integer eid) {
		Employee	existEmployee = hibernateTemplate.get(Employee.class, eid);
		return existEmployee;
	}


	@Override
	//ɾ��Ա��
	public void delete(Employee employee) {
		hibernateTemplate.delete(employee);
	}


	@Override
	public void update(Employee employee) {
		hibernateTemplate.update(employee);
	}

}
