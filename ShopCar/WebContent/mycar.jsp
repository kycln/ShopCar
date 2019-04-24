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

<script type="text/javascript">
function submit(){
	var gnl = confirm("确认删除么？");
	if(gnl == true){
	return true;
	}else{
	return false;
	}
	}
function exit(){
	var ogn = confirm("是否确定要退出？");
	if(ogn == true){
	history.go(-1);
	}
}
</script>

<style >
#title {
	color: blue;
	backcolor: white;
}
</style>
<title>购物车页面</title>
</head>
<body>
	<div class="pag-header" id="title">
		<h2 id="title1">
			<center><strong>购物车</strong></center>
		</h2>
		<h4>
			<p style="text-align: right">欢迎您，${user.username }</p>
		</h4>
		</div>
		<div id="loginbody">
		<table cellpadding='0' border='1'>
					<c:forEach items="${arraylistByCar }" var="books">
					<tr>
						<td>书名：${books.bookname }</td>
						<td>作者：<strong>${books.author }</strong></td>
						<td>出版社：${books.publish }</td>
						<td>书的数量：${books.nums }</td>
						<td>单价：${books.price }元</td>
						<td><a onsubmit="return submit()" href="MyCarServlet?type=delete&id=${books.id }" onclick="return submit()">删除</a> &nbsp;&nbsp;</td>
						<br>
						</tr>
					</c:forEach>
					<tr><td colspan='6'>总支付：${mycar.AllPrice() }</td></tr>
					</table>
			</div>
			<a href="BookSecodeServlet">去商城继续购物</a>&nbsp;&nbsp;<button type="submit">支付</button>
			<a href="ExitServelt" onclick="return exit()">放弃此次购物</a>
</body>
</html>