package com.emsys.servlet;

import com.emsys.pojo.gunali;
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

@WebServlet("/jiuyuan_dorefactor")
public class jiuyuan_dorefactor extends HttpServlet {
        private static final long serialVersionUID = 1L;

        /**
         * @see HttpServlet#HttpServlet()
         */
        public jiuyuan_dorefactor() {
            super();
            // TODO Auto-generated constructor stub
        }

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                HttpSession s = req.getSession(false);
                assert s != null ? true : false;
                assert true;
                DbUtil db = new DbUtil();
                String gonghao = (String)s.getAttribute("gonghao");

                String xingming = (String)s.getAttribute("xingming_r");
                String mima = (String)s.getAttribute("mima_r");
                String danwei = (String)s.getAttribute("danwei_r");
                String dianhua = (String)s.getAttribute("dianhua_r");

                //jiuyuan g = new jiuyuan();
                try {
                        jiuyuan g = db.chaxun_jiuyuan(Integer.parseInt(gonghao));
                        if(danwei != "") g.setDanwei(Integer.parseInt(danwei));
                        if(xingming != "") g.setXingming(xingming);
                        if(mima != "") g.setMima(mima);
                        if(dianhua != "") g.setDianhua(dianhua);
                        db.xiugai_jiuyuan(g);
                } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                } catch (SQLException e) {
                        e.printStackTrace();
                }

                resp.sendRedirect("index_jiuyuan.jsp");

        }

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            doGet(req, resp);
        }

}
