<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Document</title>
<link rel="stylesheet" type="text/css"
	href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script
	src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<!-- 
<script type="text/javascript">
function createXMLHttpRequest(){
	try{
		return new XMLHttpRequest();//大多数浏览器
	}catch(e){
		try{
			return new ActiveXObject("Msxml2.XMLHTTP");
		}catch(e){
			return new ActiveXObject("Microsoft.XMLHTTP");
		}
	}
}
function send(){
	var xmlHttp = createXMLHttpRequest();
	xmlHttp.onreadystatechange = function(){
		//这是一个使用方法的主体，基本上什么事情都是在这个方法实现的
		if(xmlHttp.readyState == 4 && xmlHttp.status == 200){
				document.getElementById("error").innerHTML=xmlHttp.responseText;
		}
	};
	var username = document.getElementById("username").value;
	xmlHttp.open("Post","http://localhost:8080/ShopCar/AjaxServlet",true);
	xmlHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
	xmlHttp.send("username="+username);
}
</script>
 -->
<style>
#loginbody {
	border: solid 1px grey;
	width: 500px;
	height: 400px;
	margin-top: 100px;
}
</style>
<meta charset="UTF-8">
<title>登录界面</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<!--12列栅格系统，div占用3，向右偏移3 -->
			<form action="CheckLogin" method="post">
				<div class="col-md-3 col-md-offset-3" id="loginbody">
					<!-- 居中对齐 -->
					<p class="text-center" style="font-size: 30px">登录</p>
					<label for="exampleInputEmail1">用户名</label> <input type="text"
						name="username" class="form-control" id="username"
						placeholder="用户名"> <span id="error"></span>
						</br>
				<label for="exampleInputEmail1">密码</label>
					<input type="password" name="password" class="form-control"
						id="password" placeholder="密码"><br /> <label
						for="exampleInputEmail1">验证码</label> <input type="Captcha"
						class="Captcha" name="vcode" placeholder="请输入验证码！"> <img
						width="100px" height="50px" src="CheckNumber"
						onclick='src="CheckNumber?"+new Date()'> <br />
					<button type="submit" class="btn btn-success">登录</button>
					<button type="button" class="btn btn-info">重置</button>
					<a href="regist.jsp">注册</a>
				</div>
			</form>
		</div>
	</div>
</body>
</html>