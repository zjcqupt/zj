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
		//写些默认配置
		
		pageNo = pageNo == null?1:pageNo;
		pageSize = pageSize == null?5:pageSize;
		PageHelper.startPage(pageNo,pageSize);  //startPage是告诉拦截器说我要开始分页了。分页参数是这两个。pageNo随着循环会更新
		//pageinfo示意：直接拿到pageInfo对象,两种方式均可以实现
		PageInfo<User> UserList = new PageInfo<User>(userdao.SelectUserByName(userName));
		//拿到全部信息差转化为封装类
		//return BeanUtil.toPagedResult(userdao.SelectUserByName(userName));
		return BeanUtil.toPagedResult(UserList.getList(),UserList);
	}

}
								//参数说明
		//System.out.println("查询总页数："+UserList.getPages());
		//System.out.println("当前页数："+UserList.getPageNum());
		//System.out.println("每页大小："+UserList.getPageSize());
		//System.out.println("开始查询的row："+UserList.getStartRow());
		//System.out.println("总记录数："+UserList.getTotal());
		//System.out.println("数据:"+UserList.getList());