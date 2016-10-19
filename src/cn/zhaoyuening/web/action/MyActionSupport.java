package cn.zhaoyuening.web.action;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionSupport;

public abstract class MyActionSupport extends ActionSupport{
	private ApplicationContext beansContext = new ClassPathXmlApplicationContext(new String[]{"beans.xml"});
	protected ApplicationContext getBeansContext(){
		return this.beansContext;
	}
}
