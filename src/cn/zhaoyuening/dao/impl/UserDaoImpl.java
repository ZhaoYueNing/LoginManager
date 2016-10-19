package cn.zhaoyuening.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import cn.zhaoyuening.dao.UserDao;
import cn.zhaoyuening.model.User;
import cn.zhaoyuening.model.impl.UserImpl;

public class UserDaoImpl implements UserDao{
	private List<User> userList = new ArrayList<User>();
	public UserDaoImpl() {
		User user = new UserImpl();
		user.setUsername("admin");
		user.setPassword("admin");
		userList.add(user);
	}
	
	@NotNull
	public User getUser(String username){
		for (User user : userList) {
			if (user.getUsername().equals(username)) {
				return user;
			}
		}
		return null;
	}
}
