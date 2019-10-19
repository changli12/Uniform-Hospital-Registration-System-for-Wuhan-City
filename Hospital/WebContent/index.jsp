<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.sql.*,object.User,dao.com.JDBC"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>预约统一挂号系统</title>
<link href="CSS/index.css" rel="stylesheet" type="text/CSS"/>
<script src="js/myfocus-2.0.1.min.js" type="text/javascript"></script>
<script src="js/mf-pattern/mF_YSlider.js" type="text/javascript"></script>
<link href="js/mf-pattern/mF_YSlider.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
myFocus.set({
	id:'picBox',
	time:3,
	}
	)
	
function displaySubMenu(li) { 
var subMenu = li.getElementsByTagName("ul")[0]; 
subMenu.style.display = "block"; 
} 
function hideSubMenu(li) { 
var subMenu = li.getElementsByTagName("ul")[0]; 
subMenu.style.display = "none"; 
} 
</script>
</head>
<body>
<div class="top">
	<div class="top_content">    	
    	<ul>
    	<%
    	User user=new User();
    	if (null==session.getAttribute("login") || "".equals(session.getAttribute("login")))
    	{
    		%>
    			<li><a href="login.jsp">请登录</a></li>
            	<li><a href="register.jsp">请注册</a></li>
    		<%
    	}
    	else{
    		user=(User)session.getAttribute("login");
    		if(user==null){
    			System.out.println("user 为空");
    		%>
    		<li><a href="login.jsp">请登录</a></li>
            	<li><a href="register.jsp">请注册</a></li>
    		<%
    		}
    		%>
    		<li><a href="Exitlogin">退出登录</a></li><li>欢迎<%=session.getAttribute("patientname") %></li>
    		<% 
    	}
    	%>
        </ul>
    </div>
</div>

<div class="wrap">
  <div class="logo">
    	<img src="images/index/sysname1.png" alt="预约挂号平台"  />
    </div>
    <div class="nav">
    	<div class="nav_left"></div>
        <div class="nav_middle">
        	<ul>
            	<li><a href="index.jsp">首页</a></li>
                <li><a href="Search?action=first">预约挂号</a></li>
                <li><a href="">最新公告</a></li>
                <li><a href="reservesearch.jsp">信息查询</a></li>
            </ul>
        </div>
        <div class="nav_right"></div>
    </div>
  <div class="ad" id="picBox">
      <div class="pic">
    	<ul>
        	<li><img src="images/index/ad1.png" /></li>
           	<li><img src="images/index/ad2.jpg" /></li>
            <li><img src="images/index/ad3.jpg" /></li>
        </ul>
      </div>
  </div> 
  <div class="reserve">
    <form action="Search?action=second" method="post">
    <table id="tab" height="200px" width="200px">
    <caption>快速预约</caption>
    	<tr>
        <td>地区：</td>
        <td><select  style="width:80px;"onchange="handle()"name="region">
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
        </tr>
        <tr>
        <td>级别：</td>
        <td><select style="width:80px;" name="hos_class">
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
        </tr>
        <tr>
        <td>科室：</td>
        <td><select style="width:80px;" name="depart">
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
        </tr>
        <tr>
        <td></td>
        <td>
        <input type="submit" class="reserve_btn" value="&nbsp;&nbsp;&nbsp;立刻预约&nbsp;&nbsp;&nbsp;"/>
        </td>
        </tr>
    </table>
    </form>
    </div>

  <div class="info1">
        <div class="title">
           	公告中心
		</div>
				<div class="new_info">
				<h3>最新公告</h3>
                <ol>
                	<li><a href="#">武汉市中医院开通网上预约啦！</a></li>
                    <li><a href="#">同济医院五一期间服务公告！</a></li>
                    <li><a href="#">武汉牙科医院今起开始提供网上服务！</a></li>
                </ol>
                </div>
                <div class="relay_new">
                <h3>退诊公告</h3>
                <ol>
                	<li><a href="#">武汉市骨科医院暂停网上预约！</a></li>
                    <li><a href="#">武汉市第三人民医院暂停提供网上服务！</a></li>
                    <li><a href="#">湖北省中医院五一假期停止网上服务！</a></li>
                </ol>
                </div>
                <a href="">了解更多&gt;&gt;</a>
        </div>
    	<div class="info2">
       	  <div class="title">
            为您推荐
            </div>
            <div class="info_pic">
            	<img src="images/index/info_pic1.jpg" />
          </div>
             <div class="intr">
                武汉市第一人民医院 [三级甲等]</br>
                联系电话:0724-2837490</br>
                地址：湖北省武汉市中山大道215号
          </div>
  </div>            
    	<div class="info3">
        <div class="title">
       	 加入我们
        </div>
        <div id="erweima">
        <img src="images/index/erweima.png" />
        </div>
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