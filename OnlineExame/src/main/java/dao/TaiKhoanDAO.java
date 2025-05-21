package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.TaiKhoan;

public class TaiKhoanDAO {
	private static final String SELECT_ALL_SQL = "SELECT * FROM TAIKHOAN WHERE TenDangNhap=?";
	private static final String INSERT_SQL = "INSERT INTO TAIKHOAN (TenDangNhap,MatKhau) VALUES (?,?)";
	
	
	
	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/ht_thitructuyen";
			String user = "root";
			String password = "842641";
			connection = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return connection;
	}
	
	
	
	public TaiKhoan kiemTraDangNhap(String tendangnhap) {
		TaiKhoan tk = new TaiKhoan();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try{
			con = getConnection();
			pst = con.prepareStatement(SELECT_ALL_SQL);
			pst.setString(1,tendangnhap);
			rs = pst.executeQuery();
			
			if (rs.next()) {
				tk.setTenDangNhap(rs.getString("TenDangNhap"));
				tk.setMatKhau(rs.getString("MatKhau"));
				tk.setMaGV(rs.getString("MaGV"));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return tk;
	}
	
	public void taoTaiKhoanHocSinh(String tenDangNhap,String matKhau) {
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = getConnection();
			pst = con.prepareStatement(INSERT_SQL);
			pst.setString(1, tenDangNhap);
			pst.setString(2, matKhau);
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
