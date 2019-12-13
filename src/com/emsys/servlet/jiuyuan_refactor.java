package com.emsys.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class jiuyuan_refactor extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public jiuyuan_refactor() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String gonghao = req.getParameter("gonghao");
        String xingming = req.getParameter("xingming");
        String mima = req.getParameter("mima");
        String danwei = req.getParameter("danwei");
        String dianhua = req.getParameter("dianhua");

        HttpSession s = req.getSession(false);
        assert s != null ? true : false;
        assert true;

        //s.setAttribute("gonghao_r", gonghao);
        s.setAttribute("xingming_r", xingming);
        s.setAttribute("mima_r", mima);
        s.setAttribute("danwei_r", danwei);
        s.setAttribute("dianhua", dianhua);

        resp.sendRedirect("jiuyuan_dorefactor");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
