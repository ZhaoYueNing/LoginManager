package cn.zhaoyuening.web.interceptor;

import java.util.Map;

import javax.validation.constraints.Null;

import org.apache.struts2.ServletActionContext;

import cn.zhaoyuening.model.User;
import cn.zhaoyuening.utils.Constants;
import cn.zhaoyuening.web.action.LoginAction;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * 检测登陆状态拦截器
 * @author buynow
 * 是否处于登陆状态
 * 非登陆状态返回登陆
 */
public class LoginInterceptor extends AbstractInterceptor{

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		//判断是否为登陆界面 登陆界面不拦截
		if (invocation.getAction().getClass()==LoginAction.class) {
			System.out.println("登陆界面");
			LoginAction action = (LoginAction) invocation.getAction();
			System.out.println(action.getUsername()+" "+action.getPassword());
			return invocation.invoke();
		}
		
		Map<String, Object> sessionMap = ActionContext.getContext().getSession();
		User u = (User) sessionMap.get(Constants.USER_SESSION);
		if (u==null) {
			//不在登陆状态
			System.err.println("不在登陆状态");
			return Action.LOGIN;
		}
		//在登陆状态
		System.err.println("处于登陆状态");
		return invocation.invoke();
	}
	
}
