package com.greatwqs.mubian.bean;

import java.io.Serializable;

/**
 * 
 * 数据库mubian.mubian_aboutus 对应的bean.
 * 
 * @author greatwqs
 *
 */
public class AboutUsBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private int type;
	private String title;
	private String content;
	private String updatetime;
	private String createtime;

	public AboutUsBean() {
		super();
	}

	public AboutUsBean(int id, int type, String title, String content,
			String updatetime, String createtime) {
		super();
		this.id = id;
		this.type = type;
		this.title = title;
		this.content = content;
		this.updatetime = updatetime;
		this.createtime = createtime;
	}


	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public String getTypeWords(){
		if(type==0){
			return "联系我们";
		} else if(type==1){
			return "公司简介";
		} else if(type==2){
			return "公司业务";
		} else if(type==3){
			return "合作伙伴";
		}
		return "其他";
	}

}
