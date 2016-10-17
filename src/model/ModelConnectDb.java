package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ModelConnectDb {
	Connection conn;
	String username = "root";
	String pass = "";
	String url = "jdbc:mysql://localhost:3306/bnews?useUnicode=true&characterEncoding=UTF-8";
	
	public Connection getConnectMySQL(){
		//nạp driver
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Không thể nạp Driver");
			e.printStackTrace();
		}
		
		//tạo chuỗi kết nối conn
		try {
			conn = DriverManager.getConnection(url, username, pass);
		} catch (SQLException e) {
			System.out.println("Sai thông số kết nối");
			e.printStackTrace();
		}
		
		return conn;
	}
	
	public static void main(String[] args) {
		ModelConnectDb mConnect = new ModelConnectDb();
		System.out.println(mConnect.getConnectMySQL());
	}	
	
}
