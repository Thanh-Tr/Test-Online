package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.GiaoVien;

import java.io.IOException;

import dao.GiaoVienDAO;
import dao.HocSinhDAO;
import dao.TaiKhoanDAO;

@WebServlet("/GiaoVienServlet")
public class GiaoVienServlet extends HttpServlet {
	
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("user") != null) {
            String tenDangNhap = (String) ((model.TaiKhoan) session.getAttribute("user")).getTenDangNhap();
            GiaoVien gv = new GiaoVienDAO().xemThongTinGiaoVien(tenDangNhap);
            request.setAttribute("gv", gv);
            request.getRequestDispatcher("trangchugv.jsp").forward(request, response);
        } else {
            response.sendRedirect("dangnhap.jsp");
        }
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
