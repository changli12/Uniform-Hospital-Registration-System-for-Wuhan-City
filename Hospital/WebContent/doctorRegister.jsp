
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="CSS/register.css" rel="stylesheet" type="text/CSS"/>
<title>医生登记</title>
</head>
<body>
	<form action="<%=request.getContextPath()%>/doctorRegister"  method="post">
    <div class="logo">	
    <img src="images/index/logo.png" alt="预约挂号平台" />
    </div>
    <div class="register">
    <table>

        <caption align="top" style="font-size:25px;color:#6CF;">添加医生信息</caption>
        <tr>
        <td>姓名：</td>
        <td><input id="username"type="text" name="username" ></td>
        </tr>
        <tr>
        <td>性别：</td>
        <td><input class="sex" type="radio" name="sex" /> 男
			<input  class="sex" type="radio" name="sex" /> 女</td>
		</tr>
        <tr>
        <td>工号：</td>
        <td><input type="text" name="doctor_id"></td>
        </tr>
		<tr>
        <td>所在部门编号：</td>
        <td><input type="text" name="depart_id"></td>
        </tr>
        <tr>
        <td>设置密码：</td>
        <td><input type="password" name="passwd" id="password"></td>
        </tr>
       
        <tr>
        <td>确认密码：</td>
        <td><input type="password" name="repasswd" id="repassword"></td>
        </tr>
      	<tr>
        <td>手机号码：</td>
        <td><input type="text" name="phone"></td>
        </tr>
		<tr>
        <td>email：</td>
         <td><input name="email" type="text" id="email"></td>
        </tr>
       <tr>
        <td>职位：</td>
         <td><input name="doctor_post" type="text" ></td>
        </tr>
        <tr>
        <td>特长：</td>
         <td><input name="doctor_specialty" type="text" ></td>
        </tr>
        <tr>
        <td><input type="submit" value="立即添加" name="sub"></td>
        <td><input type="reset" value="重置" name="reset"></td>
        </tr>
        </table>  
    </div>
    </form>
    
</body>
</html>