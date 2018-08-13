package com.zj.Service;
//�ж�ע��ʱ��Ϣ�����ע���û�
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
		accountDao.insert(record);//���ע���˻�
	}

	@Override
	public int select(String record) {
		Account egg=accountDao.select(record);
		if(egg==null)
		{
			return 1;//�޸��û�
		}
		return 0;//�и��û�
	}

	@Override
	public Account select2(String userName) {
		Account egg=accountDao.select(userName);
		return egg;
	}
	
}
