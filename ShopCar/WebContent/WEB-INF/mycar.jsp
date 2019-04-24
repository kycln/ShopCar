<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>购物车界面</title>
</head>
<body>
			<c:forEach items="${arraylistByCar }" var="books">
					<tr>
						<img src="${books.img }" style="width: 200px; height: 200px">
						</br>
						<td>书名：${books.bookname }</td>
						<td>作者：<strong>${books.author }</strong></td>
						</br>
						<td>${books.publish }</td>
						<td>${books.price }</td>
						<td><a href="">删除</a> &nbsp;&nbsp;</td>
					</tr>
			</c:forEach>
</body>
</html>