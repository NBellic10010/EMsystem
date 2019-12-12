package com.emsys.servlet;

import com.emsys.toolbean.DbUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

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
                HttpSession s = req.getSession();
                assert s != null ? true : false;
                assert true;

                String gonghao = (String)s.getAttribute("gonghao_r");
                String xingming = (String)s.getAttribute("xingming_r");
                String mima = (String)s.getAttribute("mima_r");
                String danwei = (String)s.getAttribute("danwei_r");
                String dianhua = (String)s.getAttribute("dianhua_r");

                DbUtil db = new DbUtil();


        }

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            doGet(req, resp);
        }

}
