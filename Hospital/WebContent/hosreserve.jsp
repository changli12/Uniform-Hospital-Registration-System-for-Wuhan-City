<%@ page language="java" import="java.util.List,object.hospital,object.Department,java.util.Calendar,java.text.SimpleDateFormat,object.Doctor" contentType="text/html; charset=UTF-8;"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>医院详细信息</title>
<link type="text/css" rel="stylesheet" href="CSS/hosreserve.css">
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
<form action="Doctorinfo" method="post" name="searchdoc">
<%
	hospital hos=new hospital();
	if(request.getSession().getAttribute("hosinfo")!=null)
	{
		 hos=(hospital)session.getAttribute("hosinfo");
	}
%>

  <div class="hospitalinfo">
  	<table width="958" cellspacing="3" cellpadding="3">
  <tr>
    <td width="353"><img class="imgshow" src="images/hos.jpg" width="200" height="150"></td>
    <td width="582"><div>
    	<p>医院名称：<%=hos.getHos_name()%></p><input type="hidden" name="hos_id" value="<%=hos.getHos_id()%>">
        <p>咨询电话：<%=hos.getTel()%></p>
        <p>医院等级：<%=hos.getHos_class()%></p>
        <p>详细地址：<%=hos.getHos_addr()%></p>
    </div></td>
  </tr>
</table>
  </div>
  <div class="selectinfo">
      <table width="1000"  class="tablestyle">
        <tr>
          <td width="500">
            <div class="depart">
              <p>科室：</p><select name="depart_id" style="width:200px; height:30px;">
              <%
              	Department dep;
              	List list=null;
          		if(request.getSession().getAttribute("department")!=null)
          		{
          		 	list=(List)session.getAttribute("department");
          		}
          		for(int i=0;i<list.size();i++)
          		{
          			dep=new Department();
          			dep=(Department)list.get(i);
          			System.out.println(dep.getDepart_id());
              %>
              <option value="<%=dep.getDepart_id()%>"><%=dep.getDepart_name() %></option>
              <%
          		}
              %>
              </select>
            </div>
          <td width="500" rowspan="2">
            <div class="reservediv">
                <span>预约时间：</span><br><br>
                <input name="reservetime" checked="checked" type="radio" value="1">上午8：30-11：30
                <br>
                <br>
                <input name="reservetime" type="radio" value="2">下午13：30-16：30
            </div>
          </td>
        </tr>
        <tr>
          <td>
              <div class="reservedate" >
                  <p>预约日期：</p>
                  <select name="reservedate" style="width:200px; height:30px;">
                  <%
                  	Calendar c=Calendar.getInstance();
          			for(int i=1;i<8;i++)
          			{
          				c=Calendar.getInstance();
          				c.add(Calendar.DATE, i);
          				String str = (new SimpleDateFormat("yyyy-MM-dd")).format(c.getTime());  
         			%>
         				<option value="<%=str%>"><%=str%></option>
         			<%
          			}
                  %>
                  </select>
              </div>
          </td>
          <td>
          </td>
        </tr>
    </table>
    <input name="searchdoc" onclick="" class="button" type="submit" value="查询">
  </form>
  </div>
  <div class="showinfo">
  	<ul>
  	<%
  	List list1=null;
  	Doctor doc;
		if(request.getSession().getAttribute("doctor")!=null)
		{
			list1=(List)session.getAttribute("doctor");
			if(list1.size()>0)
			{
   			for(int i=0;i<list1.size();i++)
   			{
   				doc=new Doctor();
   				doc=(Doctor)list1.get(i);
   			
  	%>
    	<li>
          <table width="946" height="230" cellpadding="3" cellspacing="3">
            <tr>
              <td width="324"><img src="images/doctor.png" class="img2" width="150" height="150"></td>
              <td width="448"><p>医生姓名：<%=doc.getDoctor_name() %></p><p>医生职位：<%=doc.getDoctor_post() %></p><p>擅长领域：<%=doc.getDoctor_specialty() %></p></td>
              <td width="158"><a href="Reserveinfo?action=<%=doc.getDoctor_id()%>"><img src="images/button2.png" width="138" height="55"></a></td>
            </tr>
          </table>
      </li>
      
     <%
   			}
			}
		
		else
		{
			out.println("<p>暂无信息！请选择条件！</p>");
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