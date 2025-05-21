package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.HocSinh;


import java.io.IOException;
import java.util.List;

import dao.HocSinhDAO;


public class LoadStudent extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<HocSinh> list = new HocSinhDAO().layTatCaThongTinHS();
		request.setAttribute("listS", list);
		request.getRequestDispatcher("QLHocSinh.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
