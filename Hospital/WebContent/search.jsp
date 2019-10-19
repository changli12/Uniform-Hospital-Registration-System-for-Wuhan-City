<%@ page language="java" import="java.sql.*,java.util.List,object.hospital,dao.com.JDBC" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>医院搜索</title>
<%

%>
<link type="text/css" rel="stylesheet" href="CSS/search.css">
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
<div class="wrap">
  <div class="seachclassify">
  	<form action="Search?action=second" method="post">
      <select name="region" style="width:80px; height:28px;text-align:center;">
        <option value="all">全部</option>
          <%
         Connection connection=JDBC.getConnection();
      String sql1="select distinct region from hospital";
      PreparedStatement ptmt1=connection.prepareStatement(sql1);
      ResultSet rs1=ptmt1.executeQuery();
      try{
      while(rs1.next()){
   %>
   <option value="<%=rs1.getString("region")%>"><%=rs1.getString("region")%></option>
    <%}}
      catch (Exception e){}%> 
      </select>
      <select name="hos_class" style="width:120px; height:28px; text-align:center;">
       <option value="all">全部</option>
        <%
      String sql2="select distinct hos_class from hospital";
      PreparedStatement ptmt2=connection.prepareStatement(sql2);
      ResultSet rs2=ptmt2.executeQuery();
      try{
      while(rs2.next()){
   %>
        <option value="<%=rs2.getString("hos_class")%>"><%=rs2.getString("hos_class")%></option>
       <%}}
      catch (Exception e){}%> 
      </select>
      <select name="depart" style="width:160px; height:28px;text-align:center;">
         <option value="all">全部</option>
        <%
      String sql3="select distinct  depart_name  from department";
      PreparedStatement ptmt3=connection.prepareStatement(sql3);
      ResultSet rs3=ptmt3.executeQuery();
      try{
      while(rs3.next()){
   %>
   <option value="<%=rs3.getString("depart_name") %>"><%=rs3.getString("depart_name") %></option>
   <%}}
      catch (Exception e){}%> 
      </select>
      <input name="mohusearch" type="text" style="width:200px; height:28px;">
   <input class="searchbutton" name="search" type="submit" value="搜索">		
   </form>				 
   </div>
   	<div class="repeatinfo">
    <ul>
   		<%
   			List list=null;
    		hospital hos;
   			if(request.getSession().getAttribute("hossele")!=null)
   			{
   				System.out.println("!null");
	   			list=(List)session.getAttribute("hossele");
	   			if(list.size()>0)
	   			{
		   			for(int i=0;i<list.size();i++)
		   			{
			   			hos=new hospital();
			   			hos=(hospital)list.get(i);
			   			System.out.println(i);
			   %>
			   		<li>
        				<div class="infocell">
          					<img class="img1" src="images/hostest.jpg" width="223" height="134">
          					<div class="wordinfo">
            					<span class="hospitalname">医院名称：   <%=hos.getHos_name() %></span>
            					<span class="specipicinfo">咨询电话:</span><%=hos.getTel() %><br>
            					<span class="specipicinfo">详细地址:</span><%=hos.getHos_addr() %>
          					</div>
             				<a href="Hosinfo?action=<%=hos.getTel()%>"><img class="img2" src="images/button1.JPG" width="101" height="56"></a>
        				
        				</div>
      				</li>
      				<br>
			   <% 
		   			}
	   			}
	   			else
	   			{
	   				%>
	   				<p>抱歉没有您想要查到的结果！</p>
	   				<% 
	   			}
   			}
   		%>
  
      
    </ul>
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