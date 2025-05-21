package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.TaiKhoan;

public class TaiKhoanDAO {
	private static final String SELECT_BY_ID_SQL = "SELECT * FROM TAIKHOAN WHERE TenDangNhap=?";
	
	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/ht_thitructuyen";
			String user = "root";
			String pwd = "842641";
			connection = DriverManager.getConnection(url, user, pwd);
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return connection;
	}
	
	public TaiKhoan layThongTinDN(String user) {
		TaiKhoan tk = new TaiKhoan();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			pst = con.prepareStatement(SELECT_BY_ID_SQL);
			pst.setString(1, user);
			rs = pst.executeQuery();
			while(rs.next()) {
				tk.setTenDangNhap(rs.getString("TenDangNhap"));
				tk.setMatKhau(rs.getString("MatKhau"));
			}
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return tk;
	}
}
