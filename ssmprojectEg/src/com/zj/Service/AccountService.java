package com.zj.Service;
//�ж�ע��ʱ��Ϣ�����ע���û�
import com.zj.entities.Account;

public interface AccountService {
	//����
	public void insert(Account record);
	//c��ѯ,ȷ����־
	public int  select(String userName);
	//�����Ĳ�ѯ�û�ҵ��
	public Account select2(String userName);

}
