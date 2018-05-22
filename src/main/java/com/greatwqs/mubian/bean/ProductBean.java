/**
 * 
 */
package com.greatwqs.mubian.bean;

import java.io.Serializable;
import java.sql.SQLException;

import com.greatwqs.mubian.dao.ProductsTypeDao;

/**
 * 
 * 产品
 * 木匾木刻，木质景区标识标牌、木简、屏风、对联、门牌、吊牌、标识牌、花车、垃圾桶
 * @author greatwqs
 * 
 */
public class ProductBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/***
	 * 产品对应的key;
	 */
	public static final String KEY_ID = "id";
	public static final String KEY_TYPE = "type";
	public static final String KEY_TYPENAME = "typeName";
	public static final String KEY_TITLE = "title";
	public static final String KEY_PICTUREADDRESS = "pictureAddress";
	public static final String KEY_CONTENT = "content";
	public static final String KEY_UPDATETIME = "updatetime";
	public static final String KEY_CREATETIME = "createtime";
	public static final String KEY_INDEXWIDTH = "indexWidth";
	public static final String KEY_INDEXHEIGHT = "indexHeight";
	
	private int id;
	private int type;
	private int indexWidth;
	private int indexHeight;
	private String typeName;
	private String title;
	private String pictureAddress;
	private String content;
	private String updatetime;
	private String createtime;

	public ProductBean() {
		super();
	}

	public ProductBean(int id, int type, String title, String pictureAddress,
			String content, String updatetime, String createtime) {
		super();
		this.id = id;
		this.type = type;
		this.title = title;
		this.pictureAddress = pictureAddress;
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

	public String getPictureAddress() {
		return pictureAddress;
	}

	public void setPictureAddress(String pictureAddress) {
		this.pictureAddress = pictureAddress;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public int getIndexWidth() {
		return indexWidth;
	}

	public void setIndexWidth(int indexWidth) {
		this.indexWidth = indexWidth;
	}
	
	public int getIndexHeight() {
		return indexHeight;
	}

	public void setIndexHeight(int indexHeight) {
		this.indexHeight = indexHeight;
	}

	public String getTypeNameByDB() {
		try {
			ProductsTypeBean bean=ProductsTypeDao.getProductsTypeBean(type);
			if(bean==null || bean.getTypeName()==null 
					|| bean.getTypeName().trim().length()==0){
				return "其他";
			} else {
				return bean.getTypeName().trim();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "其他";
	}
	
	
	
}
