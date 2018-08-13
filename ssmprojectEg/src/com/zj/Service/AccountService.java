package com.zj.Service;
//判断注册时信息及添加注册用户
import com.zj.entities.Account;

public interface AccountService {
	//插入
	public void insert(Account record);
	//c查询,确定标志
	public int  select(String userName);
	//正常的查询用户业务
	public Account select2(String userName);

}
