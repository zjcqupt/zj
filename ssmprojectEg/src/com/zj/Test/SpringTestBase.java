package com.zj.Test;
/*
 * ���Ի���
 */


import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//��ȡ������Ϣ
@ContextConfiguration(locations={"classpath:resources/application.xml"})
//ʹ�ñ�׼��JUnit @RunWithע��������JUnitʹ��Spring TestRunner

@RunWith(SpringJUnit4ClassRunner.class)
public class SpringTestBase extends AbstractJUnit4SpringContextTests{
	protected Logger log=LoggerFactory.getLogger(getClass());

}
