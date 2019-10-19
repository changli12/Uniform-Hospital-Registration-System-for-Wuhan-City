<%@page import="object.Reserveconfirm"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>预约信息显示</title>
<link type="text/css" rel="stylesheet" href="CSS/infoshow.css">
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
<script>
function back(){
	 window.history.back(-1); 
}
</script>
<%
	Reserveconfirm resfirm=new Reserveconfirm();
	if(request.getSession().getAttribute("reserveshow")!=null)
	{
	 	resfirm=(Reserveconfirm)session.getAttribute("reserveshow");
	}
	

	

%>
  <div class="wrap">
    <div class="info">
    	<form action="reservesearch.jsp" method="post" name="form1">
        	<table class="table" width="329" cellspacing="15" cellpadding="15">
  <tr>
    <th><span style=" ">预约详细信息</span></th>
  </tr>
  <tr>
    <td><span>预约编号：<%=resfirm.getReserve_id() %></span></td>
  </tr>
  <tr>
    <td><span>姓名：<%=resfirm.getPatient_name() %></span></td>
  </tr>
  <tr>
    <td><span>预约时间：<%=resfirm.getReserve_time() %></span></td>
  </tr>
  <tr>
    <td><span>预约医院：<%=resfirm.getHospital_name() %></span></td>
  </tr>
  <tr>
    <td><span>预约医生：<%=resfirm.getDoctor_name() %></span></td>
  </tr>
  <tr>
    <td><span>预约科室：<%=resfirm.getDepart_name() %></span></td>
  </tr>
  <tr>
    <td><a href="#" onClick="back()">返回上一页</a><a href="reservesearch.jsp"><input style="float:right" name="confirm" type="button" value="确认"></a></td>
  </tr>
</table>

        </form>
    </div>
  	
  </div>
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