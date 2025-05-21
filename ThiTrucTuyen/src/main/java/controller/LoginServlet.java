package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.GiaoVien;
import model.HocSinh;
import model.TaiKhoan;

import java.io.IOException;

import dao.GiaoVienDAO;
import dao.HocSinhDAO;
import dao.TaiKhoanDAO;


public class LoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String TenDangNhap = request.getParameter("user");
		String MatKhau = request.getParameter("pass");
		String url = "/formdangnhap.jsp";
		TaiKhoan tk = new TaiKhoanDAO().layThongTinDN(TenDangNhap);

		
		if (tk.getTenDangNhap() != null) {
			//Đăng nhập với vai trò là giáo viên
			if (tk.getTenDangNhap().equals("admin")) {
				if (MatKhau.equals(tk.getMatKhau())) {
					GiaoVien gv = new GiaoVienDAO().layThongTinGV();
					session.setAttribute("gv", gv);
					url = "/TeacherHomePage.jsp";
				} else {
					String notification = "Mật khẩu chưa chính xác";
					request.setAttribute("user", TenDangNhap);
					request.setAttribute("notification", notification);
					url = "/formdangnhap.jsp";
				}

			} else {
				//Đăng nhập với vai trò là học sinh
				if (MatKhau.equals(tk.getMatKhau())) {
					HocSinh hs = new HocSinhDAO().layThongTinHS(tk.getTenDangNhap());
					session.setAttribute("hs", hs);
					url = "/StudentHomePage.jsp";
				} else {
					String notification = "Mật khẩu chưa chính xác";
					request.setAttribute("user", TenDangNhap);
					request.setAttribute("notification", notification);
					url = "/formdangnhap.jsp";
				}
			}
			
		} else {
			//Nếu chưa có tài khoản
			String notification = "Tài khoản chưa tồn tại";
			request.setAttribute("notification", notification);
			url = "/formdangnhap.jsp";
		}
		session.setAttribute("tk", tk);
		request.getRequestDispatcher(url).forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
