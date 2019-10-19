<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="CSS/reservesearch.css">
<title>预约编号查询</title>
</head>

<body>

<div class="logo">
    	<img src="images/index/sysname1.png" alt="预约挂号平台"  />
    </div>
    <div class="nav">
        <div class="nav_middle">
        	<ul>
            	<li><a href="index.jsp">首页</a></li>
                <li><a href="hosreserve.jsp">预约挂号</a></li>
                <li><a href="">最新公告</a></li>
                <li><a href="search.jsp">信息查询</a></li>
            </ul>
        </div>
    </div>
<div class="search"><form action="Reserveshow" method="post">
请输入要查询的预约编号：<input name="reserve_id" type="text" style="width=150px;height:30px;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input name="search" type="submit" value="搜索" style="width=50px;height:30px;"></form></div>

<div class="footer">
       <div class="footer_text">
        <ul>
        <li>联系方式：13477364759</li>
        <li>联系地址：武汉市南湖大道21号</li>
        <li>邮编：430073</li>
        </ul>
        </div> 
 </div>

</body>
</html>
