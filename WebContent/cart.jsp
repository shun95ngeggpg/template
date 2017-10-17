<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>カート</title>
</head>
<body>
	<div id="header">
		<div id="pr"></div>
	</div>
	<div id="main">
		<div id="top">
			<p>カート</p>
		</div>
		<div>
			<s:if test="myPageList == null">
				<h3>カートに商品はありません。</h3>
			</s:if>
		</div>
		<!-- 購入ボタンフォーム -->
		<s:form action="GoPaymentAction">
			<button type="submit">購入する
			</button>
		</s:form>
	</div>
</body>
</html>