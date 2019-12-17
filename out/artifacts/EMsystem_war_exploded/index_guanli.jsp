<%@ page import="com.emsys.pojo.gunali" %>
<%@ page import="com.emsys.pojo.jiuyuan" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="https://v3.bootcss.com/favicon.ico">

    <title>Dashboard Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="https://v3.bootcss.com/assets/css/ie10-viewport-bug-workaround.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="https://v3.bootcss.com/examples/dashboard/dashboard.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="https://v3.bootcss.com/assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="https://v3.bootcss.com/assets/js/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>

    <![endif]-->
    <style>
        h1 {
            text-decoration-style: dashed;
        }

    </style>
</head>

<body>
<%
    HttpSession s = request.getSession();
    gunali d = null;
    if(s.getAttribute("id_guanli") == null) response.sendRedirect("start.jsp");
    else{
        d = (gunali)s.getAttribute("id_guanli");
    }
%>
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">应急管理后台系统</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#">修改密码</a></li>
                <li><a href="#">管理面板</a></li>
            </ul>
        </div>
    </div>
</nav>
<form action="index_guanli.jsp" id="dumform">
    <input id="gonghao_dispatch" type="hidden" name="gonghao_dispatch">
</form>

<div class="container-fluid">
    <div class="row">
        <div class="col-sm-12 main">
            <h1 class="page-header">应急救援员管理面板</h1>
            <div class="row placeholders">
                <div class="col-xs-6 col-sm-6 placeholder">
                    <img src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw==" width="200" height="200" class="img-responsive" alt="Generic placeholder thumbnail">
                    <h4>Label</h4>
                    <span class="text-muted">Something else</span>
                </div>
                <div class="col-xs-6 col-sm-6 targ">
                    <span><h2>亲爱的管理员#<%=d.getGonghao()%> ，欢迎回来！</h2></span>
                    <span><h1><b>国家的安全，是我们的责任</b></h1></span>
                </div>
            </div>

            <h2 class="sub-header">Section title</h2>
            <div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <td>工号</td>
                        <td>姓名</td>
                        <td>电话</td>
                        <td>身份证号</td>
                        <td>状态</td>
                        <td>操作</td>
                    </tr>
                    </thead>
                    <tbody>
                    <%
                        ArrayList<jiuyuan> l = (ArrayList<jiuyuan>)request.getAttribute("list");
                        //System.out.println(l.get(0));

                        for(jiuyuan g: l) {
                            boolean status = g.getZhuangtai();
                            String zhuangtai;
                            if(status) zhuangtai = "空闲";
                            else zhuangtai = "任务中";
                    %>
                    <tr>
                        <td><%=g.getGonghao()%></td>
                        <td><%=g.getXingming()%></td>
                        <td><%=g.getDianhua()%></td>
                        <td><%=g.getIdnumber()%></td>
                        <td id="status"><%=zhuangtai%></td>
                        <td>
                            <%
                                if(status) {
                                    %>
                            <span><a type="button" class="btn btn-default" href="dispatcher_servlet?gonghao_value=<%=g.getGonghao()%>">派遣</a></span>
                            <%
                                }else {
                            %>
                            <span><a type="button" class="btn btn-default" href="recall_servlet?gonghao_callback=<%=g.getGonghao()%>">召回</a></span>
                            <%
                                }
                            %>
                            <span><a type="button" class="btn btn-default">添加待办事项</a></span>

                        </td>
                    </tr>
                    <%
                        }
                    %>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

</div>
<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script>
</script>
<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<script>window.jQuery || document.write('<script src="https://v3.bootcss.com/assets/js/vendor/jquery.min.js"><\/script>')</script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<!-- Just to make our placeholder images work. Don't actually copy the next line! -->
<script src="https://v3.bootcss.com/assets/js/vendor/holder.min.js"></script>
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="https://v3.bootcss.com/assets/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>
