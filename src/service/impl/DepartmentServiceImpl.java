package service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import dao.DepartmentDao;
import entity.Department;
import entity.PageBean;
import service.DepartmentService;
/*
 * ���Ź���ҵ��ʵ����
 */
@Transactional
public class DepartmentServiceImpl  implements DepartmentService{
	private DepartmentDao departmentDao;

	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}

	@Override
	//��ҳ��ѯ����
	public PageBean<Department> findByPage(Integer currPage) {
		PageBean<Department> pageBean = new PageBean<Department>();
		//��װ��ǰҳ��
		pageBean.setCurrPage(currPage);
		//��װÿҳ��ʾ��¼��
		int pageSize = 3;
		pageBean.setPageSize(pageSize);
		//��װ�ܼ�¼��
		int totalCount = departmentDao.findCount();
		pageBean.setTotalCount(totalCount);
		//��װ��ҳ��
		double tc = totalCount;
		double num=Math.ceil(tc/pageSize);
		pageBean.setTotalPage(new Double(num).intValue());
		//��װÿҳ��ʾ������
		int begin = (currPage-1)*pageSize;
		List<Department> list=departmentDao.findByPage(begin,pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	//��Ӳ���
	public void save(Department department) {
		departmentDao.save(department);
	}

	@Override
	//���߲���id��ѯ
	public Department findById(Integer did) {
	Department department=	departmentDao.findById(did);
		return department;
	}

	@Override
	//�޸Ĳ���
	public void update(Department department) {
	departmentDao.update(department);
	}

	@Override
	//ɾ��
	public void delete(Department department) {
		departmentDao.delete(department);
	}

	@Override
	//�������в���
	public List<Department> findAll() {
		List<Department> list=departmentDao.findAll();
		return list;
	}
}
