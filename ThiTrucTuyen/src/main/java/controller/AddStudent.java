package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.HocSinh;

import java.io.IOException;

import dao.HocSinhDAO;

import java.text.ParseException;
import java.text.SimpleDateFormat;


public class AddStudent extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String MaHS = request.getParameter("maHS");
		String TenHS = request.getParameter("tenHS");
		boolean GioiTinh = Boolean.parseBoolean(request.getParameter("gioiTinh"));
		String NgaySinh = request.getParameter("ngaySinh"); 
		String Lop = request.getParameter("lop");
		
		HocSinh hs = new HocSinh(MaHS,TenHS,GioiTinh,NgaySinh,Lop);
		HocSinhDAO dao = new HocSinhDAO();
		dao.themThongTinHS(hs);
		
		request.getRequestDispatcher("loadStudent").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
