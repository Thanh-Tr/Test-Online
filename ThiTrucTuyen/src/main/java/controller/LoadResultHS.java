package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.HocSinh;
import model.KetQua;

import java.io.IOException;
import java.util.List;

import dao.KetQuaDAO;


public class LoadResultHS extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HocSinh hs = (HocSinh) request.getSession().getAttribute("hs");
		List<KetQua> listKQHS = new KetQuaDAO().layKQHS(hs.getMaHS());
		request.setAttribute("listKQHS", listKQHS);
		request.setAttribute("hs", hs);
		request.getRequestDispatcher("QLHocTapCaNhan.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String MaDT = request.getParameter("madt");
		int SoCauDung = Integer.parseInt(request.getParameter("socaudung"));
		int TongSoCau = Integer.parseInt(request.getParameter("tongsocau"));
		HocSinh hs = (HocSinh) request.getSession().getAttribute("hs");
		
		KetQua kq = new KetQua();
		kq.setMaKQ("KQ"+System.currentTimeMillis()%1000+MaDT);
		kq.setMaDT(MaDT);
		kq.setMaHS(hs.getMaHS());
		kq.setSoCauDung(SoCauDung);
		kq.setTongSoCau(TongSoCau);
		
		int addR = new KetQuaDAO().luuKetQua(kq);
		request.getRequestDispatcher("loadExamHS").forward(request, response);
	}

}
