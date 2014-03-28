package com.mycrawler.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil2 {
	
	private static Connection conn = null;
	
	private static final String IP="localhost";
	private static final String POOL="3306";
	private static final String DBNAME="school";
	private static final String Encoding="utf8";
	private static final String USERNAME="root";
	private static final String PASSWORD="root";
	
	static {
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e){
			System.out.println("加载驱动错误");
			e.printStackTrace();
		}
	}
	
	/**
	 * 返回一个数据库连接
	 * @return 一个数据库连接
	 */
	public static Connection getConnection(){
		try {
			conn = DriverManager.getConnection("jdbc:mysql://"+IP+":"+POOL+"/"+DBNAME
					+"?autoReconnect=true&useUnicode=true&characterEncoding="+Encoding, USERNAME, PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("getConnection错误");
			e.printStackTrace();
		}
		return conn;
	}
	
	/**
	 * 释放连接
	 * @param conn
	 * @param ps
	 * @param rs
	 */
	public static void close(Connection conn,PreparedStatement ps,ResultSet rs){
		if (rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (ps!=null){
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
