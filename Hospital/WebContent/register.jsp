<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
<link href="CSS/register.css" rel="stylesheet" type="text/CSS"/>
<script type="text/javascript"> 
  function validateForm(){
    var username= document.getElementById("username").value;
    if(username==""){
 
      alert("用户名 不能为空");
      return false;
    }
 
    var password= document.getElementById("password").value;
    if(password==""){
 
      alert("密码 不能为空");
      return false;
    }
     var phone=document.getElementById("phone").value;
     if(phone==""){
    	 alert("手机号码不能为空！");
    	 return false;
     }
    var idnumber= document.getElementById("idnumber").value;
    if(idnumber==""){
 
      alert("证件号码不能为空!");
      return false;
    }
 
    var repassword= document.getElementById("repassword").value;
    if(password!=repassword){
 
      alert("密码 必须 一致 ");
      return false;
    }
    var email= document.getElementById("email").value;
    if(email.match("^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$")==null){
 
      alert("邮箱地址 不正确 ");
      return false;
    }
 
  }

</script> 
</head>
<body>
<form name="form1" action="<%=request.getContextPath()%>/Register" onsubmit="return validateForm();" method="post">
<div class="logo">	
    <img src="images/index/sysname1.png" alt="预约挂号平台" />
    </div>
    <div class="register">
        <table>
        <caption align="top" style="font-size:25px;color:#6CF;">请填写注册信息</caption>
        <tr>
        <td>姓名：</td>
        <td><input  style="line-height: 25px"id="username"type="text" name="username" ></td>
        </tr>
        <tr>
        <td>性别：</td>
        <td><input  style="line-height: 25px" class="sex" type="radio" name="sex" value="男"/> 男
			<input  style="line-height: 25px" class="sex" type="radio" name="sex" value="女"/> 女</td>
		<tr>
		<td>年龄：</td>
		<td><input  style="line-height: 25px"type="text" name="age"></td>
		</tr>
		<tr>
        <td>证件号码：</td>
        <td><input  style="line-height: 25px"type="text" name="idnumber"></td>
        </tr>
        <tr>
        <td>设置密码：</td>
        <td><input  style="line-height: 25px"type="password" name="passwd" id="password"></td>
        </tr>
       
        <tr>
        <td>确认密码：</td>
        <td><input  style="line-height: 25px"type="password" name="repasswd" id="repassword"></td>
        </tr>
       
        <tr>
        <td>现居地址：</td>
        <td><input  style="line-height: 25px"type="text" name="address"></td>
        </tr>
      
        <tr>
        <td>手机号码：</td>
        <td><input  id="phone"style="line-height: 25px"name="phone"type="text"></td>
        </tr>
		<tr>
        <td>email：</td>
         <td><input style="line-height: 25px" name="email" type="text" id="email"></td>
        </tr>
        <tr>
        <td></td>
        <td><input  onclick="if(this.checked) document.getElementById('register').disabled=false;else document.getElementById('register').disabled=true"  type="radio" id="radio1"name="radio1" /> 本人已阅读并同意<a href="" style="text-decoration:none;">《预约挂号协议》</a></td>
        </tr>
         <tr>
         <td></td>
            <td><input type="submit" style="width:70px;height:30px;"id="register" disabled="disabled" name="register" value="注册" /></td>
            </tr>
        </table>  
   </div>
   </form>
</body>
</html>