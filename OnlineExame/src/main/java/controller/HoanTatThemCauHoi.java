package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import dao.DeThiDAO;

@WebServlet("/hoan-tat-them-cau-hoi")
public class HoanTatThemCauHoi extends HttpServlet {



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String maDT = request.getParameter("madt");
        HttpSession session = request.getSession();
        List<String> dsMaCH = (List<String>) session.getAttribute("dsMaCauHoi");

        if (dsMaCH != null && maDT != null) {
            new DeThiDAO().themCauHoiVaoDeThi(maDT, dsMaCH);
            session.removeAttribute("dsMaCauHoi");
        }

        response.sendRedirect("danhsachdethi.jsp"); // hoặc trang chi tiết đề thi
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
