/**
 * 
 */
package com.greatwqs.mubian.bean;

import java.io.Serializable;
import java.sql.SQLException;

import com.greatwqs.mubian.dao.ProductsTypeDao;
import com.greatwqs.mubian.utils.PublicUtils;

/**
 * 
 * mubian.mubian_products_type
 * 
 * @author greatwqs
 * 
 */
public class ProductsTypeBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// TYPENAME,PRIORITY,CONTENT,UPDATETIME,CREATETIME
	private int id;
	private int priority;
	private String typeName;
	private String content;
	private String updateTime;
	private String createTime;
	private int width;
	private int height;
	private String picture;

	public ProductsTypeBean() {
		super();
	}

	public ProductsTypeBean(int id, int priority, String typeName,
			String content, String updateTime, String createTime) {
		super();
		this.id = id;
		this.priority = priority;
		this.typeName = typeName;
		this.content = content;
		this.updateTime = updateTime;
		this.createTime = createTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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
	
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public static String getTypeNameByDB(int type) {
		try {
			ProductsTypeBean bean=ProductsTypeDao.getProductsTypeBean(type);
			if(bean==null || bean.getTypeName()==null 
					|| bean.getTypeName().trim().length()==0){
				return "木匾木刻所有系列";
			} else {
				return bean.getTypeName().trim();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "木匾木刻所有系列";
	}
	
	public static String getTypeNameByDB(String type) {
		if(type==null || type.trim().length()==0 || !PublicUtils.isNumeric(type)){
			return "木匾木刻所有系列";
		}
		int typeInt = Integer.parseInt(type.trim());
		return getTypeNameByDB(typeInt);
	}

}
