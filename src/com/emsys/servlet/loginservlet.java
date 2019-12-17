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
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(
        name="loginserlvet",
        urlPatterns="/loginservlet",
        loadOnStartup=1 )
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

        HttpSession s = request.getSession();

        String gonghao = request.getParameter("gonghao");
        String mima = request.getParameter("mima");
        String option = request.getParameter("optionsRadios");
        if(option.equals("option1")) {
            int gonghao_= Integer.parseInt(gonghao);
            try {
                gunali g = db.chaxun_guanli(Integer.valueOf(gonghao), mima);
                    s.setAttribute("id_guanli", g);
                    response.sendRedirect("guanli_servlet");

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else if (option.equals("option2")) {
            int gonghao_= Integer.parseInt(gonghao);
            try {
                jiuyuan g = db.chaxun_jiuyuan(Integer.valueOf(gonghao), mima);
                s.setAttribute("id_jiuyuan", g);
                response.sendRedirect("index_jiuyuan.jsp");

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
