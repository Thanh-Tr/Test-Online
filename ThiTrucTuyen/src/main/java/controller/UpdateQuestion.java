package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.CauHoi;

import java.io.IOException;

import dao.CauHoiDAO;


public class UpdateQuestion extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String MaDT = request.getParameter("madt");
		String MaCH = request.getParameter("mach");
		CauHoi ch = new CauHoiDAO().layThongTinCH(MaDT,MaCH);
		request.setAttribute("ch", ch);
		request.getRequestDispatcher("SuaCauHoi.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String MaCH = request.getParameter("mach");
		String MoTaCH = request.getParameter("motach");
		String CauA = request.getParameter("cau_a");
		String CauB = request.getParameter("cau_b");
		String CauC = request.getParameter("cau_c");
		String CauD = request.getParameter("cau_d");
		String DapAn = request.getParameter("caudung");
		String MaDT = request.getParameter("madt");
		
		CauHoi ch = new CauHoi(MaCH, MoTaCH, CauA, CauB, CauC, CauD, DapAn, MaDT);
		
		int updateQ = new CauHoiDAO().suaCauHoi(ch);
		request.setAttribute("madt", MaDT);
		request.getRequestDispatcher("loadQuestion").forward(request, response);
	}

}
