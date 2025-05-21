package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.CauHoi;

import java.io.IOException;
import java.util.List;

import dao.CauHoiDAO;


public class LoadQuestion extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String MaDT = request.getParameter("madt");
		List<CauHoi> listCH = new CauHoiDAO().layDanhSachCH(MaDT);
		request.setAttribute("madt", MaDT);
		request.setAttribute("listCH", listCH);
		request.getRequestDispatcher("ChiTietDeThi.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String MaDT = (String) request.getAttribute("madt");
		List<CauHoi> listCH = new CauHoiDAO().layDanhSachCH(MaDT);
		request.setAttribute("madt", MaDT);
		request.setAttribute("listCH", listCH);
		request.getRequestDispatcher("ChiTietDeThi.jsp").forward(request, response);
	}

}
