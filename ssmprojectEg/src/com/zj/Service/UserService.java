package com.zj.Service;

import com.zj.entities.User;
import common.PagedResult;

/*
 * ע��dao���service��ҵ�񣩲������
 * �����Ѿ���������,����dao
 * ʵ�ַ�ҳ
 *@param userName ��ѯ��������Ϊ��
 * @param pageNo ��ѯ��������Ϊ�գ�Ĭ��ȡ1
 * @param pageSize ��ѯ��������Ϊ�գ�Ĭ��ȡ10
 */
public interface UserService {
	User selectUserByid(int id);
	PagedResult<User> queryByPage(String userName,Integer pageNo,Integer pageSize);
}
