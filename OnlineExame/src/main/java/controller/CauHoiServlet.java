package controller;

import dao.CauHoiDAO;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import model.CauHoi;

import java.io.IOException;
import java.util.List;

@WebServlet("/cauhoi")
public class CauHoiServlet extends HttpServlet {

    private CauHoiDAO dao = new CauHoiDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String hanhdong = request.getParameter("action");

        if ("delete".equals(hanhdong)) {
            String ma = request.getParameter("id");
            dao.xoaCauHoi(ma);
        }

        List<CauHoi> ds = dao.layTatCaCauHoi();
        request.setAttribute("list", ds);
        request.getRequestDispatcher("giaovien/dscauhoi.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nd = request.getParameter("noidung");
        String a = request.getParameter("a");
        String b = request.getParameter("b");
        String c = request.getParameter("c");
        String d = request.getParameter("d");
        String dung = request.getParameter("dapan");

        CauHoi ch = new CauHoi();
        ch.setMoTaCH(nd);
        ch.setCauA(a);
        ch.setCauB(b);
        ch.setCauC(c);
        ch.setCauD(d);
        ch.setDapAn(dung);

        dao.themCauHoi(ch);
        response.sendRedirect("cauhoi");
    }
}
