package com.mycrawler.db;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBUtil3 {
	private String driver = null;
	private String url = null;
	private String username = null;
	private String password = null;
	private Connection conn = null;
	private Statement stat = null;
	private ResultSet rset = null;
	
	public DBUtil3() {
		// TODO Auto-generated constructor stub
		this("jdbc.properties");
	}
	
	public DBUtil3(String conf){
		loadProperties(conf);
		setConn();
	}
	
	public Connection getConnection(){
		return conn;
	}
	
	private void loadProperties(String conf){
		Properties props = new Properties();
		try {
			props.load(new FileInputStream(conf));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.driver = props.getProperty("driver");
		this.url = props.getProperty("url");
		this.username = props.getProperty("username");
		this.password = props.getProperty("password");
	}
	
	private void setConn(){
		try {
			System.out.println(driver);
			Class.forName(driver);
			this.conn = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void doInsert(String sql){
		try {
			stat = conn.createStatement();
			stat.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void doDelete(String sql){
		try {
			stat = conn.createStatement();
			stat.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void doUpdate(String sql){
		try {
			stat = conn.createStatement();
			stat.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ResultSet doQuery(String sql){
		try {
			stat = conn.createStatement();
			rset = stat.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rset;
	}
	
	public void close(){
		if (rset != null){
			try {
				rset.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (stat != null){
			try {
				stat.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		try {
			//Statement stt = new DBUtil3().getConnection().createStatement();
			Connection con = new DBUtil3().getConnection();
			Statement stt = con.createStatement();
			ResultSet rs = stt.executeQuery("select * from student");
			while(rs.next()){
				System.out.println(rs.getInt("id"));
				System.out.println(rs.getString("name") + "\n");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
