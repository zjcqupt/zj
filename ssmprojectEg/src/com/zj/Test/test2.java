package com.zj.Test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.zj.Service.UserService;
import com.zj.entities.User;

import common.PagedResult;

/*
 * 注意调用时，通过业务层，注意在ioc容器中注册
 * 非正式测试
 */
public class test2 {

public static void main(String[] args) {
	@SuppressWarnings("resource")
	ApplicationContext context= new ClassPathXmlApplicationContext("resources/application.xml");
    UserService user=context.getBean(UserService.class);
    System.out.println(user.selectUserByid(2));
    PagedResult<User>  pagedResult = user.queryByPage("小小",1,10);
    System.out.println(pagedResult);
    //结果集就这DataList里面
    System.out.println(pagedResult.getDataList());
}
}
