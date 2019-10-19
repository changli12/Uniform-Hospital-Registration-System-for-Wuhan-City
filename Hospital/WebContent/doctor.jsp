<%@ page language="java" import="java.util.*,dao.com.OrderDao,object.reserveinfo,object.Doctor" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
request.setCharacterEncoding("utf-8");
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />

<!--[if IE]>
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<![endif]-->
<title>医生界面</title>

<link href="CSS/bootstrap.css" rel="stylesheet" />

<link href="CSS/font-awesome.css" rel="stylesheet" />

<link href="CSS/style.css" rel="stylesheet" />

<link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
<script type="text/javascript">
  
</script>

</head>



<body>

<div class="panel panel-primary ">
					<div class="panel-heading head">
						医 生 界 面
					</div>
</div><a href="Exitlogin">退出登录</a>

<div class="container">
<div class="row pad-botm">
	<div class="col-md-12">
			<h4 class="header-line">热点资讯</h4>
			
	</div>

</div>
	  	       
<div class="row">

		  <div class="col-md-8 col-sm-8 col-xs-12">
				<div id="carousel-example" class="carousel slide slide-bdr" data-ride="carousel" >
			   
				<div class="carousel-inner">
					<div class="item active">

						<img src="images/1.jpg" alt="" />
					   
					</div>
					<div class="item">
						<img src="images/2.jpg" alt="" />
					  
					</div>
					<div class="item">
						<img src="images/3.jpg" alt="" />
					   
					</div>
				</div>
				<!--INDICATORS-->
				 <ol class="carousel-indicators">
				    <li data-target="#carousel-example" data-slide-to="0" class="active"></li>
					<li data-target="#carousel-example" data-slide-to="1"></li>
					<li data-target="#carousel-example" data-slide-to="2"></li>
				</ol>
				<!--PREVIUS-NEXT BUTTONS-->
				 <a class="left carousel-control" href="#carousel-example" data-slide="prev">
<span class="glyphicon glyphicon-chevron-left"></span>
</a>
<a class="right carousel-control" href="#carousel-example" data-slide="next">
<span class="glyphicon glyphicon-chevron-right"></span>
</a>
			</div>
		  </div>
			 
		   <div class="col-md-4 col-sm-4 col-xs-12">
			 <div class="panel panel-primary ">
					<div class="panel-heading">
						最 新 资 讯
					</div>
					<div class="panel-body news-widget-main">
						<div class="news-widget" onclick="window.open('http://www.whtv.com.cn/tv/1/w/z/201608/t20160805_692562.shtml')">
							武汉地区三所医院将建白血病终极治疗中心
						</div>
						<p/>
						<div class="news-widget" onclick="window.open('http://www.whtv.com.cn/tv/1/jj/l/201705/t20170509_729659.shtml')">
							全国首个“白血病”停药门诊在汉设立 2017-05-09
						</div>
				        <p/>
					    <div class="btn btn-info" onclick="window.open('http://www.tjh.com.cn/News/Meeting.shtml#title')" >查看更多</div> 
						

				</div>
		 </div>
		 
	   </div>


</div>
<P/>
<hr/>
<div class="row">
			 <div class="col-md-4 col-sm-4 col-xs-12">
			 <%
			 	Doctor doc=new Doctor();
			 	doc=(Doctor)request.getSession().getAttribute("nanadoctor");
			 %>
<div class="panel panel-default">
					<div class="panel-heading">
					  个人信息
					</div>
		<div class="panel-body text-center doctorself_src">
                        <img class="img-thumbnail" src="images/user.gif" />
					  <div class="news-widget">医生简介信息
					   <p>医生信息：<%=doc.getDoctor_name()%></p>
					  <p>医生职位：<%=doc.getDoctor_post()%></p>
					  <p>医生专长：<%=doc.getDoctor_specialty()%></p>
						</div>
					
				</div>
 </div>
		 </div>
			  <div class="col-md-8 col-sm-8 col-xs-12">
				  <div class="panel panel-success">
					<div class="panel-heading">
					 患者预约信息
					</div>
					<div class="panel-body">
						<div class="table-responsive">
							<table class="table table-striped table-bordered table-hover">
								<thead>
									<tr>
										<th>ID</th>
										<th>患者姓名</th>
										<th>年龄</th>
										<th>性别</th>
										<th>预约时间</th>
										<th>医嘱</th>
										<th>操作</th>
									</tr>
								</thead>
								<tbody>
								<% 
								OrderDao dao =new OrderDao();
								System.out.println(doc.getDoctor_id());
								List<reserveinfo> list=dao.readFirstOrder(doc.getDoctor_id());
								for(reserveinfo t1:list)
								{
							
								%>
																		
								<tr><form action="medicalRecord.jsp" method="post">
										<td><input id="reserve_id" type="hidden" name="reserve_id" value="<%=t1.getReserve_id()%>" /><%=t1.getReserve_id()%></td>
										<td><input id="patient_name" type="hidden" name="patient_name" value="<%=t1.getPatient_name()%>" /><%=t1.getPatient_name()%></td>
										<td><input id="age" type="hidden" name="age" value="<%=t1.getAge()%>" /><%=t1.getAge()%></td>
										<td><input id="sex" type="hidden" name="sex" value="<%=t1.getSex()%>" /><%=t1.getSex()%></td>
										<td><%=t1.getReserve_time() %></td>
										<td><%=t1.getTextinfo() %></td>
									
									
										<td><input value="编辑医嘱" class="btn btn-info" type="submit" name="button" id="button" "/></td>
									</form></tr>
						<%} 
								
								
						%>
							</tbody>
							</table>
						</div>
					</div>
				</div>
		 </div>
		 
		 </div>
<!-- 
<div class="row">
   <div class="col-md-6">
					  <div class="panel panel-default">
					<div class="panel-heading">
					<strong>排班信息</strong>
					</div>
				<div class="panel-body">
						
						<div class="alert alert-info">
							<table class="work-table"  border="2" >
  
							
   <tbody>
    <tr>
      <th width="62" scope="col">&nbsp; </th>
      <th width="62" scope="col">周一</th>
      <th width="62" scope="col">周二</th>
      <th width="62" scope="col">周三</th>
      <th width="63" scope="col">周四</th>
      <th width="63" scope="col">周五</th>
      <th width="63" scope="col">周六</th>
      <th width="63" scope="col">周日</th>
    </tr>
    <tr>
      <th scope="row">上午</th>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <th scope="row">下午</th>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
  </tbody>
</table> 

					  </div>

				   </div>
			        </div>
   </div>
</div>
</div> -->
<script src="js/jquery-1.10.2.js"></script>
<script src="js/bootstrap.js"></script>
<script src="js/custom.js"></script>

</body>
</html>

