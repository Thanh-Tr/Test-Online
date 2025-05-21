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

import dao.CauHoiDAO;
import dao.DeThiDAO;


public class AddExam extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		String MaDT = request.getParameter("madt");
		String TenDT = request.getParameter("tendt");
		int ThoiGianLamBai = Integer.parseInt(request.getParameter("thoigianlambai"));
		GiaoVien gv = (GiaoVien) session.getAttribute("gv");
		
		String[] MoTaCH = request.getParameterValues("motach");
		String[] Cau_A = request.getParameterValues("cau_a");
		String[] Cau_B = request.getParameterValues("cau_b");
		String[] Cau_C = request.getParameterValues("cau_c");
		String[] Cau_D = request.getParameterValues("cau_d");
		String[] DapAn = request.getParameterValues("caudung");
		
		//Lưu đề thi
		int addExam = new DeThiDAO().luuDeThi(MaDT,TenDT,ThoiGianLamBai,gv.getMaGV());
		
		//Lưu từng câu hỏi
		
		for (int i=0; i<MoTaCH.length;i++) {
			CauHoi ch = new CauHoi();
			ch.setMaCH(""+(i+1));
			ch.setMoTaCH(MoTaCH[i]);
			ch.setCauA(Cau_A[i]);
			ch.setCauB(Cau_B[i]);
			ch.setCauC(Cau_C[i]);
			ch.setCauD(Cau_D[i]);
			ch.setDapAn(DapAn[i]);
			ch.setMaDT(MaDT);
			
			int addQuestion = new CauHoiDAO().luuCauHoi(ch);
		}
		
		request.getRequestDispatcher("loadExam").forward(request, response);
	}

}
