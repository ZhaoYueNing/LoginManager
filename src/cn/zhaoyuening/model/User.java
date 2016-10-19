package cn.zhaoyuening.model;

public interface User {
	String getUsername();
	void setUsername(String username);
	void setPassword(String password);
	boolean checkPassword(String password);
}
