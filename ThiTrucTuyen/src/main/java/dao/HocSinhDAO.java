package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.HocSinh;

public class HocSinhDAO {
	private static final String SELECT_ALL_SQL = "SELECT * FROM hocsinh";
	private static final String SELECT_BY_ID_SQL = "SELECT * FROM HOCSINH WHERE MaHS=?";
	private static final String INSERT_SQL = "INSERT INTO hocsinh values (?,?,?,?,?)";
	private static final String DELETE_SQL = "DELETE FROM HOCSINH where MaHS=?";
	private static final String UPDATE_SQL = "UPDATE HOCSINH SET TenHS=?,GioiTinh=?,NgaySinh=?,Lop=? WHERE MaHS=?";
	
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
	
	public List<HocSinh> layTatCaThongTinHS() {
		List<HocSinh> list = new ArrayList<>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			pst = con.prepareStatement(SELECT_ALL_SQL);
			rs = pst.executeQuery();
			while(rs.next()) {
				HocSinh hs = new HocSinh();
				hs.setMaHS(rs.getString("MaHS"));
				hs.setTenHS(rs.getString("TenHS"));
				hs.setGioiTinh(rs.getBoolean("GioiTinh"));
				hs.setNgaySinh(rs.getString("NgaySinh"));
				hs.setLop(rs.getString("Lop"));
				list.add(hs);
			}
			rs.close();
			pst.close();
			con.close();
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return list;
	}

	public HocSinh layThongTinHS(String maHS) {
		HocSinh hs = new HocSinh();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			pst = con.prepareStatement(SELECT_BY_ID_SQL);
			pst.setString(1, maHS);
			rs = pst.executeQuery();
			while(rs.next()) {
				hs.setMaHS(rs.getString("MaHS"));
				hs.setTenHS(rs.getString("TenHS"));
				hs.setGioiTinh(rs.getBoolean("GioiTinh"));
				hs.setNgaySinh(rs.getString("NgaySinh"));
				hs.setLop(rs.getString("Lop"));
			}
			rs.close();
			pst.close();
			con.close();
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return hs;
	}

	public int themThongTinHS(HocSinh hs) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pst = null;
		int update = 0;
		try {
			con = getConnection();
			pst = con.prepareStatement(INSERT_SQL);
			pst.setString(1, hs.getMaHS());
			pst.setString(2, hs.getTenHS());
			pst.setBoolean(3, hs.getGioiTinh());
			pst.setString(4, hs.getNgaySinh());
			pst.setString(5, hs.getLop());
			update = pst.executeUpdate();
			
			pst.close();
			con.close();
		} catch(SQLException se) {
			se.printStackTrace();
		}
		return update;
	}
	public int xoaThongTinHS(String maHS) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pst = null;
		int del = 0;
		try {
			con = getConnection();
			pst = con.prepareStatement(DELETE_SQL);
			pst.setString(1, maHS);
			del = pst.executeUpdate();
			
			pst.close();
			con.close();
		} catch(SQLException se) {
			se.printStackTrace();
		}
		return del;
	}

	public int suaThongTinHS(HocSinh hs) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pst = null;
		int update = 0;
		try {
			con = getConnection();
			pst = con.prepareStatement(UPDATE_SQL);
			pst.setString(5, hs.getMaHS());
			pst.setString(1, hs.getTenHS());
			pst.setBoolean(2, hs.getGioiTinh());
			pst.setString(3, hs.getNgaySinh());
			pst.setString(4, hs.getLop());
			update = pst.executeUpdate();
			
			pst.close();
			con.close();
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return update;
	}
}
