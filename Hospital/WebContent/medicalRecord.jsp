<%@ page language="java" import="java.util.*,dao.com.OrderDao,object.reserveinfo,java.sql.*" pageEncoding="utf-8"%>
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
    <meta name="description" content="" />
    <meta name="author" content="" />
    <!--[if IE]>
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <![endif]-->
    <title>医嘱界面</title>
    <!-- BOOTSTRAP CORE STYLE  -->
    <link href="CSS/bootstrap.css" rel="stylesheet" />
    <!-- FONT AWESOME STYLE  -->
    <link href="CSS/font-awesome.css" rel="stylesheet" />
    <!-- CUSTOM STYLE  -->
    <link href="CSS/style.css" rel="stylesheet" />
    <!-- GOOGLE FONT -->
    <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
<script type="text/javascript">
   //var  thisURL = document.URL;    
   //var  reserve_id =thisURL.split('?')[1];  
   //var  showid= reserve_id.split('=')[1];  
    //function  showid(){  
	// alert(showid);
	// alert("aaaa");
    //document.getElementById('ee').value=showid;  
     
</script>
</head>

<body>
 <div class="panel panel-primary ">
					<div class="panel-heading head">
						医 生 界 面
					</div>
</div>

 <div class="col-md-6 col-xs-12 col-sm-offset-1 col-sm-10">
               <div class="panel panel-info">
                        <div class="panel-heading">
                           病  历
                        </div>
                        <div class="panel-body">
                            <form role="form" action="Prescribe?method=add_textinfo" method="post">
                                        <div class="form-group">
                                            <label>预约号</label>
                                            <input name="reserve_id"  id= "reserve_id"  class="form-control" type="text" value="<%=request.getParameter("reserve_id") %>" />
                       
                                        </div>
                                 <div class="form-group">
                                            <label>姓名</label>
                                            <input class="form-control" name="patient_name" id="patient_name" type="text"  value="<%=request.getParameter("patient_name") %>"/>
                                        </div>
                                         <div class="form-group">
                                            <label>年龄</label>
                                            <input name="age" id="age" class="form-control" type="text" value="<%=request.getParameter("age") %>"/>
                                        </div>
                                            <div class="form-group">
                                            <label>性别</label>
                                            <input class="form-control" type="text" value="<%=request.getParameter("sex") %>"/>
                                        </div>
                                            
                             
                                            <div class="form-group">
                                            <label>医嘱</label>
                                            <input id="textinfo" name="textinfo" class="form-control"></input>
                                        </div>
                                        <button type="submit" class="btn btn-info" >确定 </button>
                                    </form>
                            </div>
                        </div>
                            </div>
</body>
</html>
