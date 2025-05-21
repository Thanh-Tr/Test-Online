package test;

import java.sql.Date;
import java.util.List;

import dao.CauHoiDAO;
import dao.DeThiDAO;
import dao.GiaoVienDAO;
import dao.HocSinhDAO;
import dao.KetQuaDAO;
import model.CauHoi;
import model.DeThi;
import model.GiaoVien;
import model.HocSinh;
import model.KetQua;

public class TestDAO {

	public static void main(String[] args) {
		if (new KetQuaDAO().kiemTraThi("4", "1234567890")) {
			System.out.println("Bạn đã thi rồi");
		} else {
			System.out.println("Bạn có thể thi");
		}
	}

}
