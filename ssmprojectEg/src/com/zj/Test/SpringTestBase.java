package com.zj.Test;
/*
 * 测试基类
 */


import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//读取配置信息
@ContextConfiguration(locations={"classpath:resources/application.xml"})
//使用标准的JUnit @RunWith注释来告诉JUnit使用Spring TestRunner

@RunWith(SpringJUnit4ClassRunner.class)
public class SpringTestBase extends AbstractJUnit4SpringContextTests{
	protected Logger log=LoggerFactory.getLogger(getClass());

}
