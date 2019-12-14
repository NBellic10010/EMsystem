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

@WebServlet(name="dispatcher_serlvet",
        urlPatterns="/dispatcher_servlet")
public class dispatcher_servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession s = req.getSession();
        String message = null;
        jiuyuan g = (jiuyuan)req.getAttribute("dispatch");
        DbUtil db = new DbUtil();
        try {
            jiuyuan g1 = db.chaxun_jiuyuan(g.getGonghao());
            if(g1.getZhuangtai() == true) {
                g1.setZhuangtai(false);
                db.xiugai_jiuyuan(g1);
                message = "success";
            }else{
                message = "Not available";
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        req.setAttribute("message", message);
        getServletConfig().getServletContext().getRequestDispatcher("/index_guanli.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
