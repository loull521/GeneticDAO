package com.mycrawler.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Application {
	public static void main(String[] args) {
		Connection conn = DBUtil2.getConnection();
		String sql = "select * from student";
		try {
//			Statement stat = conn.createStatement();
//			ResultSet rs = stat.executeQuery(sql);
			PreparedStatement pstat = conn.prepareStatement(sql);
			ResultSet rs = pstat.executeQuery();
			while(rs.next()){
				System.out.println("id:" + rs.getInt("id"));
				System.out.println("name: " + rs.getString("name"));
				System.out.println();
			}
			DBUtil2.close(conn, pstat, rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
