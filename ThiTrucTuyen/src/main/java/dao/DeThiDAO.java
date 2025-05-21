package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.DeThi;


public class DeThiDAO {
	
	private static final String INSERT_SQL = "INSERT INTO DETHI VALUES(?,?,?,?)";
	private static final String SELECT_ALL_SQL = "SELECT * FROM DETHI";
	private static final String UPDATE_SQL = "UPDATE dethi SET tendt=?,thoigianlambai=? where madt=?";
	private static final String SELECT_BY_ID_SQL = "SELECT * FROM DETHI WHERE MaDT = ?";

	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/ht_thitructuyen";
			String user = "root";
			String pwd = "842641";
			connection = DriverManager.getConnection(url,user,pwd);
		} catch(ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		} catch(SQLException se) {
			se.printStackTrace();
		}
		return connection;
	}
	
	public List<DeThi> layDanhSachDT(){
		List<DeThi> list = new ArrayList<>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			pst = con.prepareStatement(SELECT_ALL_SQL);
			rs = pst.executeQuery();
			while(rs.next()) {
				DeThi dt = new DeThi(rs.getString("MaDT"),
									rs.getString("TenDT"),
									rs.getInt("ThoiGianLamBai"),
									rs.getString("MaGV"));
				list.add(dt);
			}
		} catch(SQLException se) {
			se.printStackTrace();
		}
		return list;
	}

	public int luuDeThi(String maDT, String tenDT, int thoiGianLamBai, String maGV) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pst = null;
		int insert = 0;
		try {
			con = getConnection();
			pst = con.prepareStatement(INSERT_SQL);
			pst.setString(1, maDT);
			pst.setString(2, tenDT);
			pst.setInt(3, thoiGianLamBai);
			pst.setString(4, maGV);
			pst.executeUpdate();
			
			pst.close();
			con.close();
		} catch(SQLException se) {
			se.printStackTrace();
		}
		return insert;
	}

	public int suaDeThi(DeThi dt) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pst = null;
		int updateE = 0;
		try {
			con = getConnection();
			pst = con.prepareStatement(UPDATE_SQL);
			pst.setString(1, dt.getTenDT());
			pst.setInt(2, dt.getThoiGianLamBai());
			pst.setString(3, dt.getMaDT());
			
			updateE = pst.executeUpdate();
			
			pst.close();
			con.close();
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return updateE;
	}

	public DeThi layThongTinDT(String maDT) {
		// TODO Auto-generated method stub
		DeThi dt = new DeThi();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			pst = con.prepareStatement(SELECT_BY_ID_SQL);
			pst.setString(1, maDT);
			rs = pst.executeQuery();
			
			while(rs.next()) {
				dt.setMaDT(rs.getString("MaDT"));
				dt.setTenDT(rs.getString("TenDT"));
				dt.setThoiGianLamBai(rs.getInt("ThoiGianLamBai"));
				dt.setMaGV(rs.getString("MaGV"));
			}
			
			rs.close();
			pst.close();
			con.close();
		} catch(SQLException se) {
			se.printStackTrace();
		}
		return dt;
	}

	
}
