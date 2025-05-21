package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.GiaoVien;

public class GiaoVienDAO {

	private static final String SELECT_SQL = "SELECT * FROM GIAOVIEN";
	protected Connection getConnection() {
		// TODO Auto-generated method stub
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

	public GiaoVien layThongTinGV() {
		// TODO Auto-generated method stub
		GiaoVien gv = new GiaoVien();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			pst = con.prepareStatement(SELECT_SQL);
			rs = pst.executeQuery();
			while(rs.next()) {
				gv.setMaGV(rs.getString("MaGV"));
				gv.setTenGV(rs.getString("TenGV"));
				gv.setGioiTinh(rs.getBoolean("GioiTinh"));
				gv.setNgaySinh(rs.getString("NgaySinh"));
				gv.setSdt(rs.getString("Sdt"));
				gv.setEmail(rs.getString("Email"));
			}
			
			rs.close();
			pst.close();
			con.close();
			
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return gv;
	}

	

}
