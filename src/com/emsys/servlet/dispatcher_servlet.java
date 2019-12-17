package com.emsys.servlet;

import com.emsys.pojo.jiuyuan;
import com.emsys.toolbean.DbUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name="dispatcher_serlvet",
        urlPatterns="/dispatcher_servlet")
public class dispatcher_servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession s = req.getSession();
        String message = null;
        String id_S = req.getParameter("gonghao_value");
        int id = Integer.parseInt(id_S);
        DbUtil db = new DbUtil();
        try {
            jiuyuan g1 = db.chaxun_jiuyuan(id);
            g1.setZhuangtai(false);
            db.xiugai_jiuyuan(g1);
            message = "success";
            req.setAttribute("message", message);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        getServletConfig().getServletContext().getRequestDispatcher("/guanli_servlet").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
