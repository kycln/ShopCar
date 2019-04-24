<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page language="java" import="com.bbu.model.*"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增用户</title>
<link rel="stylesheet" type="text/css"
	href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script
	src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script type="text/javascript">
	function createXMLHttpRequest() {
		try {
			return new XMLHttpRequest();//大多数浏览器
		} catch (e) {
			try {
				return new ActiveXObject("Msxml2.XMLHTTP");
			} catch (e) {
				return new ActiveXObject("Microsoft.XMLHTTP");
			}
		}
	}
	function send() {
		var xmlHttp = createXMLHttpRequest();
		xmlHttp.onreadystatechange = function() {
			//这是一个使用方法的主体，基本上什么事情都是在这个方法实现的
			if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
				document.getElementById("error").innerHTML = xmlHttp.responseText;
			}
		};
		var username = document.getElementById("username").value;
		xmlHttp.open("Post", "http://localhost:8080/ShopCar/AjaxServlet", true);
		xmlHttp.setRequestHeader("Content-Type",
				"application/x-www-form-urlencoded");
		xmlHttp.send("username=" + username);
	}

	function submit() {
		var gnl = confirm("确认提交么？");
		if (gnl == true) {
			return true;
		} else {
			return false;
		}
	}
</script>
<style type="text/css">
#mybody {
	border: solid 1px grey;
	width: 980px;
	height: 500px;
	margin-top: 50px;
}
</style>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12" style="background: #4072B1; color: white">
				<h1 style="text-align: center">购物商城用户注册页面</h1>
			</div>
		</div>
		<div class="row">
			<div class="col-md-2 col-md-offset-2" id="mybody">
				<!-- <div style="float:left;margin-right:550px"> -->
				<h2 style="text-align: center">新增用户信息</h2>
				<!-- </div> -->
				<hr />
				<form class="form-horizontal"
					action="http://localhost:8080/ShopCar/UserServlet" method="post"
					onsubmit="return submit()" >
					<div class="form-group">
						<label for="inputUserName" class="col-sm-2 control-label">姓名:</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" name="username"
								id="username" onblur="send()" placeholder=" 姓名 ">
						</div>
						<span id="error"></span>
					</div>
					<div class="form-group">
						<label for="inputPassword" class="col-sm-2 control-label">密码:</label>
						<div class="col-sm-10">
							<input type="password" class="form-control" name="password"
								id="inputPassword" placeholder=" 密码 ">
						</div>
					</div>
					<div class="form-group">
						<label for="inputEmail" class="col-sm-2 control-label">邮箱:</label>
						<div class="col-sm-10">
							<input type="email" class="form-control" name="email"
								id="inputEmail" placeholder=" 邮箱 ">
						</div>
					</div>
					<div class="form-group">
						<label for="inputGrade" class="col-sm-2 control-label">电话:</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" name="telephone"
								id="inputGrade" placeholder=" 电话号码 ">
						</div>
					</div>
					<div class="form-group">
						<label for="inputGrade" class="col-sm-2 control-label">验证码</label>
						<div class="col-lg-8">
						<input type="Captcha"
						class="col-ms-8" name="vcode" placeholder="请输入验证码！">
						</div>
						<div class="col-ms-4">
							<img width="100px" height="35px" src="CheckNumber"
								onclick='src="CheckNumber?"+new Date()'>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" class="btn btn-success">确定</button>
							<button type="reset" class="btn btn-warning">取消</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>