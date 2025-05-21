package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.CauHoi;
import model.DeThi;
import model.GiaoVien;

import java.io.IOException;
import java.util.List;

import dao.CauHoiDAO;
import dao.DeThiDAO;


public class UpdateExam extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String MaDT = request.getParameter("madt");		
		DeThi dt = new DeThiDAO().layThongTinDT(MaDT);
		request.setAttribute("dt", dt);
		request.getRequestDispatcher("SuaDeThi.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String MaDT = request.getParameter("madt");
		String TenDT = request.getParameter("tendt");
		int ThoiGianLamBai = Integer.parseInt(request.getParameter("thoigianlambai"));
		String MaGV = request.getParameter("magv");
		DeThi dt = new DeThi(MaDT, TenDT, ThoiGianLamBai, MaGV);
		int updateE = new DeThiDAO().suaDeThi(dt);
		request.getRequestDispatcher("loadExam").forward(request, response);
	}

}
