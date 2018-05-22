<%@ page language="java" pageEncoding="UTF-8"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.naming.Context"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%
	//连接池的获取
	Connection conn = null;
	DataSource ds = null;
	ResultSet rs = null;
	Statement stmt = null;
	Context initCtx = new InitialContext();
	ds = (DataSource) initCtx.lookup("java:comp/env/jdbc/MuBian");
	if (ds != null) {
		out.println("已经获得DataSource!");
		out.println("<br>");
		conn = ds.getConnection();
		try {
			stmt = conn.createStatement();
			String sql = "select * from mubian_aboutus";
			rs = stmt.executeQuery(sql);
			out.println("以下是从数据库中读取出来的数据:<br>");
			while (rs.next()) {
				out.println("<br>");
				out.println(rs.getString("title"));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			rs.close();
			stmt.close();
			conn.close();
		}
	}
%>