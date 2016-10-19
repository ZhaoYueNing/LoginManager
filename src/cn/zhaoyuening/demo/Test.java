package cn.zhaoyuening.demo;

import static org.junit.Assert.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.zhaoyuening.dao.UserDao;
import cn.zhaoyuening.model.User;

public class Test {
	ApplicationContext beanContext = new ClassPathXmlApplicationContext(new String[]{"beans.xml"});
	@org.junit.Test
	public void testSpring() throws Exception {
		UserDao userDao = beanContext.getBean("userdao",UserDao.class);
		User u = userDao.getUser("admin");
		System.out.println(u);
		System.out.println(u.checkPassword("admin"));
	}
}
