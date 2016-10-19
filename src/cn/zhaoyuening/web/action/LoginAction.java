package cn.zhaoyuening.web.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import cn.zhaoyuening.dao.UserDao;
import cn.zhaoyuening.model.User;
import cn.zhaoyuening.utils.Constants;

public class LoginAction extends MyActionSupport{
	private String username;
	private String password;
	private UserDao userDao;
	@Override
	public String execute() throws Exception {
		if (username==null) {
			System.err.println("放回登陆界面");
			//返回登陆界面
			return LOGIN;
		}
		userDao = getBeansContext().getBean(Constants.USERDAO,UserDao.class);
		User u = userDao.getUser(username);
		if (u==null) {
			System.err.println("无该用户");
			//无该用户
			return LOGIN;
		}
		if (!u.checkPassword(password)) {
			return LOGIN;		
		}
		//登陆成功
		//将该用户放到会话中
		putUser2Sessio1n(u);
		System.err.println("登陆成功");
		return SUCCESS;
	}
	//将登陆后的用户实例放到session
	private void putUser2Sessio1n(User u) {
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute(Constants.USER_SESSION, u);
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
}
