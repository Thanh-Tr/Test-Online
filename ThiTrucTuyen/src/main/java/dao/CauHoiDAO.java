package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.CauHoi;

public class CauHoiDAO {
	private static final String INSERT_SQL = "INSERT INTO CAUHOI VALUES(?,?,?,?,?,?,?,?)";
	private static final String SELECT_BY_ID_SQL = "SELECT MoTaCH, CauA, CauB, CauC, CauD, DapAn\r\n"
												+ "FROM CAUHOI ch JOIN DETHI dt ON ch.MaDT=dt.MaDT\r\n"
												+ "WHERE dt.madt=? AND ch.mach=?";
	private static final String UPDATE_SQL = "UPDATE cauhoi SET MoTaCH=?,CauA=?,CauB=?,CauC=?,CauD=?,DapAn=? "
											+ "WHERE madt=? and mach=?";
	private static final String SELECT_SQL = "SELECT MaCH, MoTaCH, CauA, CauB, CauC, CauD, DapAn\r\n"
											+ "FROM CAUHOI\r\n"
											+ "WHERE madt=?;";

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
	public List<CauHoi> layDanhSachCH(String MaDT){
		List<CauHoi> list = new ArrayList<>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			pst = con.prepareStatement(SELECT_SQL);
			pst.setString(1, MaDT);
			rs = pst.executeQuery();
			
			while(rs.next()) {
				CauHoi ch = new CauHoi();
				ch.setMaCH(rs.getString("MaCH"));
				ch.setMoTaCH(rs.getString("MoTaCH"));
				ch.setCauA(rs.getString("CauA"));
				ch.setCauB(rs.getString("CauB"));
				ch.setCauC(rs.getString("CauC"));
				ch.setCauD(rs.getString("CauD"));
				ch.setDapAn(rs.getString("DapAn"));
				ch.setMaDT(MaDT);
				list.add(ch);
			}
			
			rs.close();
			pst.close();
			con.close();
		} catch(SQLException se) {
			se.printStackTrace();
		}
		return list;
	}
	public CauHoi layThongTinCH(String MaDT,String MaCH){
		CauHoi ch = new CauHoi();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			pst = con.prepareStatement(SELECT_BY_ID_SQL);
			pst.setString(1, MaDT);
			pst.setString(2, MaCH);
			rs = pst.executeQuery();
			while(rs.next()) {
				ch.setMaCH(MaCH);
				ch.setMoTaCH(rs.getString("MoTaCH"));
				ch.setCauA(rs.getString("CauA"));
				ch.setCauB(rs.getString("CauB"));
				ch.setCauC(rs.getString("CauC"));
				ch.setCauD(rs.getString("CauD"));
				ch.setDapAn(rs.getString("DapAn"));
				ch.setMaDT(MaDT);
			}
			
			rs.close();
			pst.close();
			con.close();
		} catch(SQLException se) {
			se.printStackTrace();
		}
		return ch;
	}

	public int luuCauHoi(CauHoi ch) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pst = null;
		int insert = 0;
		try {
			con = getConnection();
			pst = con.prepareStatement(INSERT_SQL);
			pst.setString(1, ch.getMaCH());
			pst.setString(2, ch.getMoTaCH());
			pst.setString(3, ch.getCauA());
			pst.setString(4, ch.getCauB());
			pst.setString(5, ch.getCauC());
			pst.setString(6, ch.getCauD());
			pst.setString(7, ch.getDapAn());
			pst.setString(8, ch.getMaDT());
			pst.executeUpdate();
			
			pst.close();
			con.close();
		} catch(SQLException se) {
			se.printStackTrace();
		}
		return insert;
	}

	public int suaCauHoi(CauHoi ch) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pst = null;
		int updateQ = 0;
		try {
			con = getConnection();
			pst = con.prepareStatement(UPDATE_SQL);
			pst.setString(1, ch.getMoTaCH());
			pst.setString(2, ch.getCauA());
			pst.setString(3, ch.getCauB());
			pst.setString(4, ch.getCauC());
			pst.setString(5, ch.getCauD());
			pst.setString(6, ch.getDapAn());
			pst.setString(7, ch.getMaDT());
			pst.setString(8, ch.getMaCH());
			
			updateQ = pst.executeUpdate();
			
			pst.close();
			con.close();
		} catch(SQLException se) {
			se.printStackTrace();
		}
		return updateQ;
	}

}
