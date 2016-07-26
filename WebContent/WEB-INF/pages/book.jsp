<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="script/jquery-2.2.2.min.js"></script>
<script type="text/javascript">

	
	$(function() {
		//翻页
		$("a").click(function() {
			var serializeValue = $(":hidden").serialize();
			var href = this.href + "&" + serializeValue;
			window.location.href = href;
			return false;
		});
		
		//跳转校验
		$("#goPage").click(function() {

			var pageNo = $("#pageNo").val();
			var reg = /^\d+$/;
			if (!reg.test(pageNo)) {
				$("#pageNo").val("");
				alert("输入页面不合法！");
				return;
			}

			var pageNoTemp = parseInt(pageNo);
			if (pageNoTemp<1 || pageNoTemp>parseInt("${bookpage.totlePageNumber}")) {
				$("#pageNo").val("");
				alert("超出页面范围！");
				return;
			}
			var href="bookServlet?method=getBooks&pageNo="+pageNo+"&"+$(":hidden").serialize();
			window.location.href=href;
		});
		

	})
</script>
<title>Insert title here</title>
</head>
<input type="hidden" name="minPriceStr" value="${param.minPriceStr}" />
<input type="hidden" name="maxPriceStr" value="${param.maxPriceStr}" />
<body>
	<center>
		<form action="bookServlet?method=getBooks" method="post">
			Price:<input type="text" size=1 name="minPriceStr" /> - <input
				type="text" size=1 name="maxPriceStr" /> <input type="submit"
				value="Submit">
		</form>
		<br> <br>
		<table cellpadding="10">
			<c:forEach items="${bookpage.list}" var="book">
				<tr>
					<td><a href="bookServlet?method=getBook&pageNo=${bookpage.nextPage}&id=${book.id}">${book.title}</a> <br> ${book.author}</td>
					<td>${book.price}</td>
					<td><a href="">加入购物车</a></td>
				</tr>
			</c:forEach>

		</table>

		<br> <br> 共${bookpage.totlePageNumber }页 &nbsp;&nbsp;
		第${bookpage.pageNo }页 &nbsp;&nbsp;
		<c:if test="${ bookpage.hasPrev}">
			<a href="bookServlet?method=getBooks&pageNo=1">首页</a>
			&nbsp;&nbsp;
			<a href="bookServlet?method=getBooks&pageNo=${bookpage.prevPage} ">上一页</a>
		</c:if>

		<c:if test="${ bookpage.hasNext}">
			<a href="bookServlet?method=getBooks&pageNo=${bookpage.nextPage }">下一页</a>
			&nbsp;&nbsp;
			<a
				href="bookServlet?method=getBooks&pageNo=${bookpage.totlePageNumber }">末页</a>
		</c:if>

		&nbsp;&nbsp; 转到<input type="text" size="1" id="pageNo" />页
		&nbsp;&nbsp; <input type="submit" value="跳转" id="goPage"/>
	</center>

</body>
</html>