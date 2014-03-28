package com.mycrawler.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 * @author loull
 * һ�����ݿ⹤���࣬����һ���µ����ӣ�����ϴ�
 *
 */
public class DBUtil {
	private static final String IP="localhost";
	private static final String POOL="3306";
	private static final String DBNAME="haodf";
	private static final String Encoding="utf8";
	private static final String USERNAME="root";
	private static final String PASSWORD="root";
	
	/**
	 * ����һ������
	 * @return
	 */
	public static Connection getConnection() {
		Connection conn = null;	
		//1.������
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver failed");
			e.printStackTrace();
		}
		//2.��ݿ�����
		try {//IP,�˿ڣ���ݿ����ַ��û�������
			conn = DriverManager.getConnection("jdbc:mysql://"+IP+":"+POOL+"/"+DBNAME
					+"?autoReconnect=true&useUnicode=true&characterEncoding="+Encoding, USERNAME, PASSWORD);
		} catch (SQLException e) {
			System.out.println("getConnection failed");
			e.printStackTrace();
		}
		return conn;
	}
	/**
	 * �ͷ����ӣ���ͬstatement��resultset
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

