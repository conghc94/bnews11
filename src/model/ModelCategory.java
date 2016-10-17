package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Category;

public class ModelCategory {
	Connection conn;
	PreparedStatement pst;
	ResultSet rs;
	
	ModelConnectDb mConnect;
	
	public ModelCategory(){
		mConnect = new ModelConnectDb();
	}
	
	public ArrayList<Category> getList(){
		ArrayList<Category> alItem = new ArrayList<>();
		conn = mConnect.getConnectMySQL();
		String sql = "SELECT *FROM category";
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()){
				int id_cat = rs.getInt("id_cat");
				String name = rs.getString("name");
				Category objCat = new Category(id_cat,name);
				
				alItem.add(objCat);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try {
				conn.close();
				rs.close();
				pst.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		return alItem;
	}

	public int addItem(Category objCat) {
		int result = 0;
		conn = mConnect.getConnectMySQL();
		String sql = "INSERT INTO category (name) VALUES (?) ";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, objCat.getName());
			pst.executeUpdate();
			result =1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		return result;
	}

	public int delItem(int id) {
		int result = 0;
		conn = mConnect.getConnectMySQL();
		String sql = "DELETE FROM category WHERE id_cat = ? LIMIT 1";
		try {
			pst=conn.prepareStatement(sql);
			pst.setInt(1, id);
			pst.executeUpdate();
			result =1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

	public Category getItem(int id) {
		Category objItem = null;
		conn = mConnect.getConnectMySQL();
		String sql = "SELECT * FROM category WHERE id_cat= ?";
		try {
			pst=conn.prepareStatement(sql);
			pst.setInt(1, id);
			rs=pst.executeQuery();
			if(rs.next()){
				objItem = new Category(rs.getInt("id_cat"),rs.getString("name"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return objItem;
	}

	public int editItem(Category objItem) {
		int result = 0;
		conn = mConnect.getConnectMySQL();
		String sql = "Update category SET name=? WHERE id_cat=? LIMIT 1 ";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, objItem.getName());
			pst.setInt(2, objItem.getId_cat());
			pst.executeUpdate();
			result =1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		return result;
	}
}
