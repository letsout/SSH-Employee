package dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.HibernateTemplate;

import dao.DepartmentDao;
import entity.Department;
/*
 * ���Ź���daoʵ����
 */
public class DepartmentDaoImpl implements DepartmentDao {
	private HibernateTemplate hibernateTemplate;

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	//��ҳ��ѯ
	public List<Department> findByPage(int begin, int pageSize) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Department.class);
		List<Department> list=(List<Department>) hibernateTemplate.findByCriteria(criteria, begin, pageSize);
		return list;
	}

	@Override
	//��ѯȫ��
	public int findCount() {
		String hql = "select count(*) from Department";
		List<Long> list= (List<Long>) hibernateTemplate.find(hql);
		if(list.size()>0) {
			return list.get(0).intValue();
		}	
		return 0;
	}

	@Override
	//��Ӳ���
	public void save(Department department) {
		hibernateTemplate.save(department);
	}

	@Override
	//����id��ѯ����
	public Department findById(Integer did) {
		Department department=	hibernateTemplate.get(Department.class, did);
		return department;
	}

	@Override
	//�޸Ĳ���
	public void update(Department department) {
		hibernateTemplate.update(department);	
	}

	@Override
	//ɾ��
	public void delete(Department department) {
		hibernateTemplate.delete(department);
	}

	@Override
	//��ѯ���в���
	public List<Department> findAll() {
		String hql="from Department ";
		List<Department>  list = (List<Department>) hibernateTemplate.find(hql);
		return list;
	}
}
