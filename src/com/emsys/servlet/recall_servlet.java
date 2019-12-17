package com.emsys.servlet;

import com.emsys.pojo.jiuyuan;
import com.emsys.toolbean.DbUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name="recall_serlvet",
        urlPatterns="/recall_servlet")
public class recall_servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String gonghao_s = req.getParameter("gonghao_callback");
        int gonghao = Integer.parseInt(gonghao_s);
        DbUtil db = new DbUtil();

        try {
            jiuyuan g = db.chaxun_jiuyuan(gonghao);
            System.out.println(g.getGonghao());
            g.setZhuangtai(true);
            db.xiugai_jiuyuan(g);
            getServletConfig().getServletContext().getRequestDispatcher("/guanli_servlet").forward(req,resp);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
