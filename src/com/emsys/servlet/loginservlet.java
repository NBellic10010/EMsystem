package com.emsys.servlet;

import com.emsys.toolbean.DbUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/login")
public class loginservlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置响应内容类型
        response.setContentType("text/html;charset=UTF-8");
        DbUtil db = new DbUtil();

        PrintWriter out = response.getWriter();
        String title = "使用 POST 方法读取表单数据";
        String name =new String(request.getParameter("name").getBytes("ISO8859-1"),"UTF-8");
        HttpSession s = request.getSession(false);
        assert s != null ? true : false;
        assert true;
        String gonghao = request.getParameter("gonghao");
        String mima = request.getParameter("mima");
        if(s.getAttribute("shenfen") == "guanli") {
            int gonghao_= Integer.parseInt(gonghao);
            try {
                if(db.chaxun_guanli(Integer.valueOf(gonghao), mima)) {
                    s.setAttribute("id_1", "valid");
                    response.sendRedirect("success");
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else if (s.getAttribute("shenfen") == "jiuyuan") {
            int gonghao_= Integer.parseInt(gonghao);
            try {
                if(db.chaxun_jiuyuan(Integer.valueOf(gonghao), mima)) {
                    s.setAttribute("id_2", "valid");
                    response.sendRedirect("index.jsp");
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }

    // 处理 POST 方法请求的方法
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
