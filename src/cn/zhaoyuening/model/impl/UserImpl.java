package cn.zhaoyuening.model.impl;

import javax.validation.constraints.NotNull;

import cn.zhaoyuening.model.User;

public class UserImpl implements User{
	private String username;
	private String password;
	
	
	@Override
	public String getUsername() {
		return this.username;
	}

	@Override
	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	@NotNull
	public boolean checkPassword(String password) {
		if (password.equals(this.password)) {
			return true;
		}
		return false;
	}

}
