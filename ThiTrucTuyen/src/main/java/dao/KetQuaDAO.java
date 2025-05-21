package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.KetQua;

public class KetQuaDAO {
	
	private static final String INSERT_SQL = "INSERT INTO KETQUA VALUES(?,?,?,?,?)";
	private static final String SELECT_ALL_SQL = "SELECT * FROM KETQUA";
	private static final String SELECT_BY_ID_SQL = "SELECT * FROM KETQUA WHERE MaHS=?";
	private static final String SELECT_SQL = "SELECT * FROM KETQUA WHERE MaDT=? and MaHS=?";

	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/ht_thitructuyen";
			String user = "root";
			String pwd = "842641";
			connection = DriverManager.getConnection(url, user, pwd);
		} catch(ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		} catch(SQLException se) {
			se.printStackTrace();
		}
		return connection;
	}

	public int luuKetQua(KetQua kq) {
		// TODO Auto-generated method stub
		int insert = 0;
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = getConnection();
			pst = con.prepareStatement(INSERT_SQL);
			pst.setString(1, kq.getMaKQ());
			pst.setString(2, kq.getMaDT());
			pst.setString(3, kq.getMaHS());
			pst.setInt(4, kq.getSoCauDung());
			pst.setInt(5, kq.getTongSoCau());
			
			insert = pst.executeUpdate();
			
			pst.close();
			con.close();
		} catch(SQLException se) {
			se.printStackTrace();
		}
		return insert;
	}

	public List<KetQua> layDanhSachKQ() {
		// TODO Auto-generated method stub
		List<KetQua> list = new ArrayList<>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			pst = con.prepareStatement(SELECT_ALL_SQL);
			rs = pst.executeQuery();
			while(rs.next()) {
				KetQua kq = new KetQua(rs.getString("MaKQ"),
						rs.getString("MaHS"),
						rs.getString("MaDT"),
						rs.getInt("SoCauDung"),
						rs.getInt("TongSoCau"));
				list.add(kq);
			}
			rs.close();
			pst.close();
			con.close();
		} catch(SQLException se) {
			se.printStackTrace();
		}
		return list;
	}

	public List<KetQua> layKQHS(String MaHS) {
		// TODO Auto-generated method stub
		List<KetQua> list = new ArrayList<>();
		Connection con = null;
		PreparedStatement pst= null;
		ResultSet rs = null;
		try {
			con = getConnection();
			pst = con.prepareStatement(SELECT_BY_ID_SQL);
			pst.setString(1, MaHS);
			rs = pst.executeQuery();
			while(rs.next()) {
				KetQua kq = new KetQua();
				kq.setMaKQ(rs.getString("MaKQ"));
				kq.setMaHS(rs.getString("MaHS"));
				kq.setMaDT(rs.getString("MaDT"));
				kq.setSoCauDung(rs.getInt("SoCauDung"));
				kq.setTongSoCau(rs.getInt("TongSoCau"));
				list.add(kq);
			}
			rs.close();
			pst.close();
			con.close();
		} catch(SQLException se) {
			se.printStackTrace();
		}
		return list;
	}

	public boolean kiemTraThi(String maDT, String maHS) {
		// TODO Auto-generated method stub
		boolean kq = false;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			pst = con.prepareStatement(SELECT_SQL);
			pst.setString(1, maDT);
			pst.setString(2, maHS);
			rs = pst.executeQuery();
			while(rs.next()) {
				kq = true;
			}
			
			rs.close();
			pst.close();
			con.close();
		} catch(SQLException se) {
			se.printStackTrace();
		}
		return kq;
	}

	

}
