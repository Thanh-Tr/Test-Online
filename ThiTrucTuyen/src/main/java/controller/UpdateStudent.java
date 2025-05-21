package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.HocSinh;

import java.io.IOException;

import dao.HocSinhDAO;


public class UpdateStudent extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String MaHS = request.getParameter("mahs");
		HocSinh hs = new HocSinhDAO().layThongTinHS(MaHS);
		request.setAttribute("hs", hs);
		request.getRequestDispatcher("SuaThongTinHS.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String MaHS = request.getParameter("maHS");
		String TenHS = request.getParameter("tenHS");
		boolean GioiTinh = Boolean.parseBoolean(request.getParameter("gioiTinh"));
		String NgaySinh = request.getParameter("ngaySinh");
		String Lop = request.getParameter("lop");
		
		HocSinh hs = new HocSinh(MaHS,TenHS,GioiTinh,NgaySinh,Lop);
		int updS = new HocSinhDAO().suaThongTinHS(hs);
		request.getRequestDispatcher("loadStudent").forward(request, response);
	}

}
