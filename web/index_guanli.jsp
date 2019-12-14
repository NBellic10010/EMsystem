<%@ page import="com.emsys.pojo.jiuyuan" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/12/13
  Time: 6:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<!--
private int gonghao;
    private String xingming;
    private int danwei;
    private String dianhua;
    private String idnumber;
    private String mima;
    private boolean zhuangtai;
    <table border="1">
    -->
        <tr>
            <td>工號</td>
            <td>姓名</td>
            <td>電話</td>
            <td>身份證號</td>
            <td>狀態</td>
        </tr>
        -
    <%
        HttpSession s = request.getSession();
        ArrayList<jiuyuan> l = (ArrayList<jiuyuan>)request.getAttribute("list");
        //System.out.println(l.get(0));

        for(jiuyuan g: l) {
    %>

    <tr>
    <td><%=g.getGonghao()%></td>
    <td><%=g.getXingming()%></td>
    <td><%=g.getDianhua()%></td>
    <td><%=g.getIdnumber()%></td>
    <td><%=g.getZhuangtai()%></td>
    </tr>
<%
    }
%>

    </table>
</body>
</html>
