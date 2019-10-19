<%@page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@page contentType="text/html; charset=UTF-8"%> 
<%@page import="object.User,dao.com.UserDao"%>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.List " %> 
<%@page import="object.reserveinfo" %>
<%@page import="dao.com.reserDao" %>
<%@page import="java.sql.Date" %>
<%@page import="object.Doctor" %>
<%@page import="dao.com.DoctorDao" %>
<%@page import="object.getWeekDate" %>
<%@page import="dao.com.insertShaDao" %>
<%@page import="object.shedule"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<title>Background Management</title>
<style type="text/css">
body{
background-color:#E5E5E5;
}

#apDiv1 {
	position: absolute;
	left: 8px;
	top: 90px;
	width: 559px;
	height: 376px;
	z-index: 1;
	background-color: #D6FCF8;
	border: medium ridge rgb(61,175,127);
}
#apDiv2 {
	position: absolute;
	left: 579px;
	top: 90px;
	width: 544px;
	height: 375px;
	z-index: 2;
	background-color: #C1C1FF;
	border: medium ridge rgb(61,175,127);
}
#apDiv3 {
	position: absolute;
	left: 5px;
	top: 490px;
	width: 561px;
	height: 400px;
	z-index: 3;
	background-color: #FFFFAA;
	border: medium ridge rgb(61,175,127);
}
#apDiv4 {
	position: absolute;
	left: 579px;
	top: 490px;
	width: 533px;
	height: 400px;
	z-index: 4;
	background-color: #FFCAFF;
	border: medium ridge rgb(61,175,127);
}
h1 {
	color: #000099;
}
</style>
</head>

<body><%
  User user1=new User();
  user1=(User)request.getSession().getAttribute("login");
  %>
  欢迎医院管理员!<%=user1.getUser_name()%><a href="Exitlogin">退出登录</a>

<div><h1>后台信息管理</h1>
</div>

<div id="apDiv1">
  <h2>用户信息管理  </h2>
  
<form name="form1" action="<%=request.getContextPath()%>/userServlet1"  method="post" >
                <blockquote>请输入用户账号：
      <input type="text" name="textfield" id="textfield"> 
      <input type="submit" name="sub"  value="查找">
    </blockquote>
</form>
  <hr>
  <p> 查询结果显示：</p>
 <table border="1">
      <tr>
          <td>用户编号</td>
          <td>用户名</td>
          <td>密码</td>
          <td>类型</td>
          <td>操                                作</td>
      </tr>
       <%
      
        User u ;
       
        if(session.getAttribute("ValueList")!=null)
        {
        	
        	u=(User)session.getAttribute("ValueList");            
        }
        else
        {
        	//out.println("<script>alert('抱歉没有此用户！');</script>");
        	u=new User(0,null,null,null);
        }
                   
        %>
         <%
       			 if(session.getAttribute("uuser")!=null)
      			  {
       				//out.println("<script>alert('抱歉没有此用户！');</script>");
        				u=(User)session.getAttribute("uuser");            
     			   }
     
  			 %>
        <form name="ff" action="<%=request.getContextPath()%>/deleteUser"  method="post">
          <tr>
              <td><%=u.getUser_id()%></td>
              <td><%=u.getUser_name()%></td>
              <td><%=u.getPassword()%></td>
              <td><%=u.getSort()%></td>
              <td>
                <input type=hidden name="id" id="id" value="<%=u.getUser_name()%>" >
				<input type="submit" name="subb"  value="删除" >
            </td>
          </tr>
          
          </form>
 
   
  </table>
  <p><a href="register.jsp">点此进入新用户信息录入</a></p>
</div>
<div id="apDiv2"  align="center">

     <h2>医院科室信息管理</h2>
  <form name="form2" method="post" action="<%=request.getContextPath()%>/shaServlet">
  
    <p>更新一周后信息：<br>
      挂号数：<input type="text" name="select2" style="width:70px;">
      <label for="docId"></label>
      
     医生工号： <input type="text" name="docId" id="docId">
     
    
      <input type="submit" name="ton" id="ton" value="更新">
    </p>
    <hr>
    <p>
      
   </p></form>
   医生排班表：
   <table border=1px>
   <tr>
          <td>医生工号</td>
          <td>医生姓名</td>
          <td>排班最大人数</td>
          
   </tr>
  <%
  		insertShaDao da=new insertShaDao();
    	List<shedule> list=da.InsertDoc();
    	for(shedule she:list){
    		%>
    		<tr>
    		  <td><%=she.getDoc_id()%></td>
              <td><%=she.getDoc_name()%></td>
              <td><%=she.getNum()%></td>
              </tr>
    		<%
    	}	  
  %>
  </table>
</div>
<div id="apDiv3">
  <h2>预约信息管理</h2>
  <p>
    
    <form name="form3" action="<%=request.getContextPath()%>/reserServlet"  method="post" >
                <blockquote>请输入预约编号：
      <input type="text" name="textf" id="textf"> 
      <input type="submit" name="su"  value="查找">
    </blockquote>
</form>
  </p>
  <hr>
  <p>查询结果显示：</p>
  
       
  <table border="1">
      <tr>
              <td>预约编号</td>
              <td>用户编号</td>
              <td>预约人姓名</td>
              <td>预约时间</td>
              <td>医院ID</td>
              <td>医生ID</td>
              <td>操 作</td>
      </tr>
        <%
                reserveinfo f ;
             if(session.getAttribute("serinfo")!=null)
      	   {
        		f=(reserveinfo)session.getAttribute("serinfo");            
     	   }
       	 else
       	 {
       	 	Date ll=null;
       		 f=new reserveinfo(0,0,ll,0,0,"null",0,"null");
       	 }
                   
        %>
         <%
                    if(session.getAttribute("ser")!=null)
                    {
        	            f=(reserveinfo)session.getAttribute("ser");            
                    }
             %>
<form name="f123"  action="<%=request.getContextPath()%>/deleteRes"   method="post">
         <tr>
              <td><%=f.getReserve_id()%></td>
              <td><%=f.getPatient_id()%></td>
              <td><%=f.getPatient_name()%></td>
              <td><%=f.getReserve_time()%></td>
              <td><%=f.getHop_id()%></td>
              <td><%=f.getDoc_id()%></td>
               <td>
                <input type="hidden"  name="m"  id="m"  value="<%=f.getReserve_id()%>" >
				<input type="submit"  name="subb"  value="删除" >
               </td>
          </tr>
           </form>
           
          </table>
       

</div>
<div id="apDiv4">
  <h2>医生信息管理</h2>
  <p>
    
   <form name="form4" action="<%=request.getContextPath()%>/doctorServlet"  method="post" >
                <blockquote><label for="textfield3"></label>
    请输入医生工号：
      <input type="text" name="t" id="t"> 
      <input type="submit" name="sub333"  value="查找">
    </blockquote>
</form>
  </p>
  <hr>
  <p>查询结果显示：</p>
  <table width="350" height="100" border="1">
    <tr>
          <td>医生工号</td>
          <td>姓名</td>
          <td>职位</td>
          <td>专长</td>
          <td>e-mail</td>
          <td>科室编号</td>
          <td>性别</td>
          <td> 电话</td>
          <td>操                                作</td>
      </tr>
       <%
      
        Doctor c ;
        if(session.getAttribute("doc1")!=null)
        {
        	c=(Doctor)session.getAttribute("doc1");            
        }
        else
        {
        	c=new Doctor(0,"null","null", "null","null","null","null",0);
        }
                 
        %>
        <%
        if(session.getAttribute("doin")!=null)
        {
        	c=(Doctor)session.getAttribute("doin");            
        }
     
        %>
         <form name="fdoc" action="<%=request.getContextPath()%>/deleteDoc"  method="post">
          <tr>
              <td><%=c.getDoctor_id()%></td>
              <td><%=c.getDoctor_name()%></td>
              <td><%=c.getDoctor_post()%></td>
              <td><%=c.getDoctor_specialty()%></td>
              <td><%=c.getEmail()%></td>
              <td><%=c.getdepart_id()%></td>
              <td><%=c.getSex()%></td>
              <td><%=c.getTel()%></td>
              <td>
                <input type=hidden name="do" id="do" value="<%=c.getDoctor_id()%>" >
				<input type="submit" name="subb"  value="删除" >
            </td>
          </tr>
          </form>
    
  </table>
  <p><a href="doctorRegister.jsp">点此进入医生信息录入</a></p>
</div>

</body>
</html>