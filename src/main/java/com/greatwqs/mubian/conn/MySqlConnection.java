/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.greatwqs.mubian.conn;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author greatwqs
 */
public class MySqlConnection {
	
	private Connection connection = null;
	
	/**
	 * get mysql Connection
	 * @return
	 */
    public Connection getConnection() {
    	if(connection==null){
    		try {
    			Class.forName("com.mysql.jdbc.Driver").newInstance();
    			Connection connection = java.sql.DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mubian", 
    					"root", "greatwqs");
                return connection;
            } catch (Exception ex) {
                ex.printStackTrace();
                return null;
            }
    	}
        return connection;
    }
	
	public void relaseConnection() {
		try {
			if (connection != null && !connection.isClosed()) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
    
    /**
     * query
     * @param sql
     * @return
     */
    public ResultSet getQuery(String sql){
    	try{
    		return getConnection().createStatement().executeQuery(sql);
    	} catch(Exception exp){
    		exp.printStackTrace();
    	}
    	return null;
    }
    
    /**
     * INSERT、UPDATE 或 DELETE 语句
     * @param sql
     */
    public void executeUpdate(String sql){
    	try{
    		getConnection().createStatement().executeUpdate(sql);
    	} catch(Exception exp){
    		exp.printStackTrace();
    	}
    }
    
    public static void main(String[] fds){
    }
}
