package com.zj.Service;

import com.zj.entities.User;
import common.PagedResult;

/*
 * 注意dao层和service（业务）层的区别
 * 这里已经做了区分,操作dao
 * 实现分页
 *@param userName 查询条件，可为空
 * @param pageNo 查询条件，可为空，默认取1
 * @param pageSize 查询条件，可为空，默认取10
 */
public interface UserService {
	User selectUserByid(int id);
	PagedResult<User> queryByPage(String userName,Integer pageNo,Integer pageSize);
}
