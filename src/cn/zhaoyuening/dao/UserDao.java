package cn.zhaoyuening.dao;

import javax.validation.constraints.NotNull;

import cn.zhaoyuening.model.User;

public interface UserDao {
	@NotNull
	User getUser(String username);
}
