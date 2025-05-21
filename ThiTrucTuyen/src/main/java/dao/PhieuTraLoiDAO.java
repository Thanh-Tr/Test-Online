package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.PhieuTraLoi;

public class PhieuTraLoiDAO {
	
	private static final String INSERT_SQL = "INSERT INTO PHIEUTRALOI VALUES(?,?,?,?)";
	private static final String SELECT_BY_ID_SQL = "SELECT * FROM PHIEUTRALOI WHERE MaDT=? and MaHS=?";

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

	public int luuPhieuTraLoi(PhieuTraLoi ptl) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pst = null;
		int insert = 0;
		try {
			con = getConnection();
			pst = con.prepareStatement(INSERT_SQL);
			pst.setString(1, ptl.getMaPTL());
			pst.setString(2, ptl.getCauTraLoi());
			pst.setString(3, ptl.getMaHS());
			pst.setString(4, ptl.getMaDT());
			
			insert = pst.executeUpdate();
			
			pst.close();
			con.close();
			
		} catch(SQLException se) {
			se.printStackTrace();
		}
		return insert;
	}

	public List<PhieuTraLoi> layDanhSachPTL(String maDT,String maHS) {
		// TODO Auto-generated method stub
		List<PhieuTraLoi> list = new ArrayList<>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			pst = con.prepareStatement(SELECT_BY_ID_SQL);
			pst.setString(1, maDT);
			pst.setString(2, maHS);
			rs = pst.executeQuery();
			while(rs.next()) {
				PhieuTraLoi ptl = new PhieuTraLoi(rs.getString("MaPTL"),
						rs.getString("CauTraLoi"),
						maHS,
						maDT);
				list.add(ptl);
			}
			rs.close();
			pst.close();
			con.close();
		} catch(SQLException se) {
			se.printStackTrace();
		}
		return list;
	}
	
}
