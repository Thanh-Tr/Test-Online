package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.CauHoi;
import model.HocSinh;
import model.KetQua;
import model.PhieuTraLoi;

import java.io.IOException;
import java.util.List;

import dao.KetQuaDAO;
import dao.PhieuTraLoiDAO;


public class CheckExamServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String MaDT = request.getParameter("madt");
		int tg = Integer.parseInt(request.getParameter("thoigian"));
		HocSinh hs = (HocSinh) request.getSession().getAttribute("hs");
		
		if (new KetQuaDAO().kiemTraThi(MaDT, hs.getMaHS())) {
			//Đã thi rồi
			request.setAttribute("notification", "Bạn đã làm bài thi này rồi. Không thể làm lại!");
			request.getRequestDispatcher("loadExamHS").forward(request, response);
		} else {
			//Chưa thi
			request.setAttribute("madt",MaDT);
			request.setAttribute("thoigian",tg);
			request.getRequestDispatcher("loadQuestionHS").forward(request, response);
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String MaDT = request.getParameter("madt");
		
		//Lấy danh sách câu hỏi
		List<CauHoi> listCH = (List<CauHoi>) request.getSession().getAttribute("listCH");
		
		int SoCauDung = 0;
		int TongSoCau = listCH.size();
		
		//Duyệt từng câu hỏi để kiểm tra
		for (CauHoi o: listCH) {
			String maCH = o.getMaCH();
			String cauTraLoi = request.getParameter("cautraloi"+maCH);
			String dapAn = o.getDapAn();
			
			if (cauTraLoi != null && cauTraLoi.equalsIgnoreCase(dapAn)) {
				SoCauDung++;
			}
		}
		request.setAttribute("socaudung", SoCauDung);
		request.setAttribute("tongsocau", TongSoCau);
		request.setAttribute("madt", MaDT);
		request.getRequestDispatcher("KetQua.jsp").forward(request, response);
	}

}
