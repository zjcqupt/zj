package com.zj.Service;
//判断注册时信息及添加注册用户
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zj.DAO.AccountDAO;
import com.zj.entities.Account;

@Service
	public class AccountServiceImpl implements AccountService {
	@Autowired
	private AccountDAO accountDao;

	@Override
	public void insert(Account record) {
		accountDao.insert(record);//添加注册账户
	}

	@Override
	public int select(String record) {
		Account egg=accountDao.select(record);
		if(egg==null)
		{
			return 1;//无该用户
		}
		return 0;//有该用户
	}

	@Override
	public Account select2(String userName) {
		Account egg=accountDao.select(userName);
		return egg;
	}
	
}
