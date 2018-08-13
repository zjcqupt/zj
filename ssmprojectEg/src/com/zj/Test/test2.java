package com.zj.Test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.zj.Service.UserService;
import com.zj.entities.User;

import common.PagedResult;

/*
 * ע�����ʱ��ͨ��ҵ��㣬ע����ioc������ע��
 * ����ʽ����
 */
public class test2 {

public static void main(String[] args) {
	@SuppressWarnings("resource")
	ApplicationContext context= new ClassPathXmlApplicationContext("resources/application.xml");
    UserService user=context.getBean(UserService.class);
    System.out.println(user.selectUserByid(2));
    PagedResult<User>  pagedResult = user.queryByPage("СС",1,10);
    System.out.println(pagedResult);
    //���������DataList����
    System.out.println(pagedResult.getDataList());
}
}
