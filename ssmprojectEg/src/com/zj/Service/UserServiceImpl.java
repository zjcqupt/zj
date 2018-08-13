package com.zj.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zj.DAO.UserDAO;
import com.zj.entities.User;
import common.BeanUtil;
import common.PagedResult;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDAO userdao;
	
	@Override
	public User selectUserByid(int id) {
		return userdao.SelectUserByid(id);
	}

	@Override
	public PagedResult<User> queryByPage(String userName, Integer pageNo, Integer pageSize) {
		//дЩĬ������
		
		pageNo = pageNo == null?1:pageNo;
		pageSize = pageSize == null?5:pageSize;
		PageHelper.startPage(pageNo,pageSize);  //startPage�Ǹ���������˵��Ҫ��ʼ��ҳ�ˡ���ҳ��������������pageNo����ѭ�������
		//pageinfoʾ�⣺ֱ���õ�pageInfo����,���ַ�ʽ������ʵ��
		PageInfo<User> UserList = new PageInfo<User>(userdao.SelectUserByName(userName));
		//�õ�ȫ����Ϣ��ת��Ϊ��װ��
		//return BeanUtil.toPagedResult(userdao.SelectUserByName(userName));
		return BeanUtil.toPagedResult(UserList.getList(),UserList);
	}

}
								//����˵��
		//System.out.println("��ѯ��ҳ����"+UserList.getPages());
		//System.out.println("��ǰҳ����"+UserList.getPageNum());
		//System.out.println("ÿҳ��С��"+UserList.getPageSize());
		//System.out.println("��ʼ��ѯ��row��"+UserList.getStartRow());
		//System.out.println("�ܼ�¼����"+UserList.getTotal());
		//System.out.println("����:"+UserList.getList());