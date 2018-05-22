/**
 * 
 */
package com.greatwqs.mubian.bean;

/**
 * @author greatwqs
 * 
 */
public class AdminBean {

	private int id;
	private String username;
	private String password;
	private String loginTime;
	private String updateTime;
	private String createTime;

	public AdminBean() {
		super();
	}

	public AdminBean(int id, String username, String password,
			String loginTime, String updateTime, String createTime) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.loginTime = loginTime;
		this.updateTime = updateTime;
		this.createTime = createTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(String loginTime) {
		this.loginTime = loginTime;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
}
