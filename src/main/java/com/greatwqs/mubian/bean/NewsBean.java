package com.greatwqs.mubian.bean;

import java.io.Serializable;

import com.greatwqs.mubian.utils.PublicUtils;

/**
 * 
 * 数据库mubian.mubian_news 对应的bean.
 * 
 * @author greatwqs
 *
 */
public class NewsBean implements Serializable{

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

	public NewsBean() {
		super();
	}

	public NewsBean(int id, int type, String title, String content,
			String updatetime, String createtime) {
		super();
		this.id = id;
		this.type = type;
		this.title = PublicUtils.getBlankIfNull(title);
		this.content = PublicUtils.getBlankIfNull(content);
		this.updatetime = PublicUtils.getBlankIfNull(updatetime);
		this.createtime = PublicUtils.getBlankIfNull(createtime);
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
		this.title = PublicUtils.getBlankIfNull(title);
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = PublicUtils.getBlankIfNull(content);
	}

	public String getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(String updatetime) {
		this.updatetime = PublicUtils.getBlankIfNull(updatetime);
	}

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = PublicUtils.getBlankIfNull(createtime);
	}
}
