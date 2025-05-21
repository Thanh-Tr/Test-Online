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


public class LoadQuestionHS extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String MaDT = request.getParameter("madt");
		int ThoiGianLamBai = Integer.parseInt(request.getParameter("thoigian"));
		List<CauHoi> listCH = new CauHoiDAO().layDanhSachCH(MaDT);
		request.setAttribute("madt", MaDT);
		request.setAttribute("thoigianlambai", ThoiGianLamBai);
		request.getSession().setAttribute("listCH", listCH);
		request.getRequestDispatcher("VaoThi.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
