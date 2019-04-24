<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css"
	href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script
	src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>


<!-- ajax的内容，将选择的东西加到购物车 -->
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
function send(value){
	var xmlHttp = createXMLHttpRequest();
	xmlHttp.onreadystatechange = function(){
		//这是一个使用方法的主体，基本上什么事情都是在这个方法实现的
		if(xmlHttp.readyState == 4 && xmlHttp.status == 200){
			if(xmlHttp.responseText==true){
				
			}else{
				alter('图书加入购物车失败！');
			}
		}
	};
	var id = value;
	xmlHttp.open("Post","http://localhost:8080/ShopCar/MyCarServlet",true);
	xmlHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
	xmlHttp.send("type=add&id="+id);
}

</script>




<style>
#title {
	color: blue;
	backcolor: white;
}

#title1 {
	height: 60px;
	display: block;
	text-align: center
}

#loginbody {
	backcolor: black;
}
</style>

<title>购物页面</title>
</head>
<body>
	<div class="pag-header" id="title">
		<h2 id="title1">
			<strong>购物中心商城</strong>
		</h2>
		<h4>
			<p style="text-align: right">欢迎您，${user.username }</p>
		</h4>
	</div>
	<div class="container">
		<div class="row-md-9" id="loginbody">
			<c:forEach items="${book }" var="books">
				<div class="col-md-4">
					<tr>
						<img src="${books.img }" style="width: 200px; height: 200px">
						</br>
						<td>书名：${books.bookname }</td>
						<td>作者：<strong>${books.author }</strong></td>
						</br>
						<td colspan='2'>出版社：${books.publish }</td></br>
						<td>单价：${books.price }元</td>&nbsp;&nbsp;&nbsp;
						<td><button  onclick="send(this.value)" value="${books.id }"
								>购买</button> &nbsp;&nbsp;</td>
					</tr>
				</div>
			</c:forEach>
			<center>
				<ul class="pagination pagination-lg">
					<li><a href="#">&laquo;</a></li>
					<c:forEach begin="${Page.start }" end="${Page.end }" var="PageNum">
						<li><a href="PageServlet?curpage=${PageNum }">${PageNum }</a></li>
					</c:forEach>
					<li><a href="#">&raquo;</a></li>
				</ul>
			</center>
		</div>
		<div class="row-md-3">
		<a href="MyCarServlet?type=show">购物车</a>
		</div>
	</div>
</body>
</html>