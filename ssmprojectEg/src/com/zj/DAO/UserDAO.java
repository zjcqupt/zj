package com.zj.DAO;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.zj.entities.User;

/*
 * ע��mapper�Ǻ�dao��Ӧ�ģ�û�з���ͬһ�ļ����£�����ͨ��ȫ������mapper
 */

public interface UserDAO {
	public User SelectUserByid(int id);
	public List<User>SelectUserByName(@Param("name")String name);
}
