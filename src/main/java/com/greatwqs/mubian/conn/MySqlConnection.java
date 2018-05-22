/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.greatwqs.mubian.conn;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

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
    public Connection getConnectionJndi() {
    	if(connection==null){
    		try {
    			Context initCtx = new InitialContext();  
    			DataSource ds =(DataSource)initCtx.lookup("java:comp/env/jdbc/MuBian");  
                connection = ds.getConnection();
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
    		return getConnectionJndi().createStatement().executeQuery(sql);
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
    		getConnectionJndi().createStatement().executeUpdate(sql);
    	} catch(Exception exp){
    		exp.printStackTrace();
    	}
    }
    
    public static void main(String[] fds){
    }
}
