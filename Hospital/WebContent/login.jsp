<!--<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>-->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="CSS/login.css" rel="stylesheet" type="text/CSS"/>
<title>登录</title>
</head>
<body>
<form method="post" action="<%=request.getContextPath()%>/Login">
<div class="logo">	
    <img src="images/index/sysname1.png" alt="预约挂号平台" />
    </div>
	<div class="login_head">
    	请填写登录信息
    </div>
    <div class="login">
        	<table class="table">
            <tr>
            <td>选择您的用户类型：</td>
            </tr>
            <tr>
            <td height="20px">
            	<select name="type" style="width:150px;height:25px;">
            	  <option > </option>
            	  <option value="管理员用户">管 理 员 用 户</option>
                <option   value="病人用户">病 人用 户</option>
                <option   value="医生用户">医 生 用 户</option>
                </select>
            </td>
            </tr>
            <tr>
            <td >手机号码/工号：</td>
            </tr>
            <tr>
            <td height="20px"> <input type="text"name="phone" /></td>
            </tr>
            <tr>
            <td >密码：</td>
            </tr>
            <tr>
            <td><input type="password" name="password" /></td>
            </tr>
            <tr>
            <td >
            <input id="lo"type="submit" value="" >
            </td>
            </tr>
     
            </table>   
    </div>
            <div class="remind">
                 没有账号？<a href="register.jsp">立即注册</a></br>
         <a href="index.jsp">返回首页</a>
        </div> 
    </form>
</body>
</html>