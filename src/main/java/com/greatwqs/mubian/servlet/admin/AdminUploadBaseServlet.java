/**
 * 
 */
package com.greatwqs.mubian.servlet.admin;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.FileUploadBase.SizeLimitExceededException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.greatwqs.mubian.utils.DateUtils;

/**
 * 
 * 上传单个文件使用;
 * 
 * @author greatwqs
 * 
 */
public class AdminUploadBaseServlet extends HttpServlet {

	public static final long serialVersionUID = 1L;
	/**
	 * 上传的默认图片大小不能超过2M;
	 */
	public static final long IMAGE_MAX_SIZE = 1024 * 1024 * 2;
	/**
	 * 图片的保存地址,在此项目中为: 项目绝对地址/uploads/2013/123456789.jpg;
	 */
	public static final String IMAGES_SAVED_DIR = "upload";
	public static final String IMAGE_TYPES_LIST = "gif,jpg,jpeg,bmp,png";
	public static final String FILE_SEPARATOR   = System.getProperty("file.separator");

	/**
	 * 上传图片;
	 * 1. 把图片上传至服务器;
	 * 2. 把生成好的用于页面显示的路径用PictureAddress设置在request中;
	 * @param request
	 * @param response
	 * @return String 如果有错误信息,表示没有上传成功!
	 * @throws ServletException
	 * @throws IOException
	 */
	protected String doUpload(HttpServletRequest request, HttpServletResponse response) 
	        throws ServletException, IOException{
		String errorString = "图片上传网络错误";
		try {
			/** 实例化一个硬盘文件工厂,用来配置上传组件ServletFileUpload **/
			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setSizeThreshold(1024);
			// 设置上传文件时用于临时存放文件的内存大小,这里是1K.多于的部分将临时存在硬盘.
			// 用以上工厂实例化上传组件
			ServletFileUpload fileUpload = new ServletFileUpload(factory);
			// 设置最大上传尺寸
			fileUpload.setSizeMax(IMAGE_MAX_SIZE);
			// 从request得到 所有 上传域的列表,这里只有一个图片附件上传.
			List<FileItem> fileList = null;
			try {
				fileList = fileUpload.parseRequest(request);
			} catch (FileUploadException exp) {// 处理文件尺寸过大异常
				if (exp instanceof SizeLimitExceededException) {
					errorString = "上传文件大小有误!图片文件必须小于2M";
				}
				return errorString;
			}
			// 没有文件上传
			if (fileList == null || fileList.size() == 0) {
				errorString = "上传文件数目有误!";
				return errorString;
			}
			
			FileItem fileItem = null;
			// 得到所有上传的文件  
	        Iterator<FileItem> fileItr = fileList.iterator();  
	        // 循环处理所有文件  
	        while (fileItr.hasNext()) {  
	            // 得到当前文件  
	        	fileItem = fileItr.next();  
	            // 忽略简单form字段而不是上传域的文件域(<input type="text" />等)  
	            if (fileItem != null && !(fileItem.isFormField())) {  
	                break;  
	            }  
	        }
	            
			String fileName = fileItem.getName();
			String fileType = fileName.substring(fileName.lastIndexOf(".") + 1);
			if (!IMAGE_TYPES_LIST.contains(fileType.toLowerCase())) {
				errorString = "上传文件的格式有误!提示:上传图片必须是gif,jpg,jpeg,bmp,png格式!";
				return errorString;
			}
			/***
			 * 项目部署的绝对路径,一般为%TOMCAT_HOME%/webapps/MuBian/
			 */
			String projectAbsPath = this.getServletConfig().getServletContext().getRealPath("/");
			int year = DateUtils.getYear();
			/**
			 * 图片在项目中保存的目录位置;如果年份文件夹不存在,则创建.
			 */
			String imagesSavedDir = projectAbsPath + IMAGES_SAVED_DIR+ FILE_SEPARATOR + year;
			File pathDirFile = new File(imagesSavedDir);
			if (!pathDirFile.exists()) {
				pathDirFile.mkdir();
			}
			String imageFileName = DateUtils.getImageNameDate() + "."+ fileType;
			/**
			 * 图片在数据库报错的地址,在表mubian_products中的PictureAddress字段的值; 
			 * Eg: upload/2013/201204210038.jpg
			 */
			String imagesDBSavedAddress = IMAGES_SAVED_DIR + "/" + year + "/"+ imageFileName;
			/**
			 * 图片文件在磁盘的保存绝对位置;
			 */
			String imageDiskSavedAddress = imagesSavedDir + FILE_SEPARATOR+ imageFileName;
			File imageFile = new File(imageDiskSavedAddress);
			fileItem.write(imageFile);
			/****
			 * PictureAddress用于在doSaveToDB使用;
			 */
			request.setAttribute("PictureAddress", imagesDBSavedAddress);
			return "";
		} catch (Exception exp) {
			errorString = "系统出现出现异常!请稍后再试!";
			return errorString;
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>upload file: </title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>GET不能上传!请稍后再试!</h1>");
        out.println("</body>");
        out.println("</html>");
        out.flush();
        out.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		super.doPost(req, resp);
	}

	@Override
	public void destroy() {
		super.destroy();
	}

	@Override
	public void init() throws ServletException {
		super.init();
	}
}
