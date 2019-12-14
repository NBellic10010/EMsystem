package com.emsys.servlet;

import com.emsys.pojo.jiuyuan;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "guanli_add_servlet", urlPatterns = "/guanli_add_servlet")
public class guanli_add_servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession s = req.getSession();
        String original_password = (String)s.getAttribute("original_password");
        jiuyuan g = new jiuyuan();
        /**
         * private int gonghao;
         *     private String xingming;
         *     private int danwei;
         *     private String dianhua;
         *     private String idnumber;
         *     private String mima;
         *     private boolean zhuangtai;
         */
        g.setXingming(req.getParameter("xingming"));
        g.setDanwei(Integer.parseInt(req.getParameter("danwei")));
        g.setDianhua(req.getParameter("dianhua"));
        g.setIdnumber(req.getParameter("idnumber"));
        g.setMima(original_password);
        g.setZhuangtai(true);
        getServletConfig().getServletContext().getRequestDispatcher("/index_guanli.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
