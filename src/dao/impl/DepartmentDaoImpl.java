package dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.HibernateTemplate;

import dao.DepartmentDao;
import entity.Department;
/*
 * 部门管理dao实现类
 */
public class DepartmentDaoImpl implements DepartmentDao {
	private HibernateTemplate hibernateTemplate;

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	//分页查询
	public List<Department> findByPage(int begin, int pageSize) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Department.class);
		List<Department> list=(List<Department>) hibernateTemplate.findByCriteria(criteria, begin, pageSize);
		return list;
	}

	@Override
	//查询全部
	public int findCount() {
		String hql = "select count(*) from Department";
		List<Long> list= (List<Long>) hibernateTemplate.find(hql);
		if(list.size()>0) {
			return list.get(0).intValue();
		}	
		return 0;
	}

	@Override
	//添加部门
	public void save(Department department) {
		hibernateTemplate.save(department);
	}

	@Override
	//根据id查询部门
	public Department findById(Integer did) {
		Department department=	hibernateTemplate.get(Department.class, did);
		return department;
	}

	@Override
	//修改部门
	public void update(Department department) {
		hibernateTemplate.update(department);	
	}

	@Override
	//删除
	public void delete(Department department) {
		hibernateTemplate.delete(department);
	}

	@Override
	//查询所有部门
	public List<Department> findAll() {
		String hql="from Department ";
		List<Department>  list = (List<Department>) hibernateTemplate.find(hql);
		return list;
	}
}
