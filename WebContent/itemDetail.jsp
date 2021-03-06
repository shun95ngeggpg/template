<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>商品詳細</title>
</head>
<body>
	<div id="main">
		<div id="top">
			<p>商品詳細</p>
		</div>

		<s:iterator value="itemList" status="count">
			<s:form action="InsertCartAction">
			<input type="hidden" name="itemId" value="<s:property value='itemId' />" />
				<table>
					<tr>
						<td><span>商品名</span></td>
						<td><s:property	value="ItemName" /><br>
						</td>
					</tr>
					<tr>
						<td><span>値段</span></td>
						<td><s:property value="Price" /><span>円</span>
						</td>
					</tr>
					<tr>
						<td><span>購入個数</span></td>
						<td><select name="count">
								<option value="1" selected="selected">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
						</select></td>
					</tr>
					<tr>
						<td><span>支払い方法</span></td>
						<td><input type="radio" name="pay" value="1"
							checked="checked">現金払い <input type="radio" name="pay"
							value="2">クレジットカード</td>
					</tr>
					<tr>
						<td><s:submit value="カートに入れる" /></td>
					</tr>
				</table>
			</s:form>
		</s:iterator>

		<div id="text-center">

			<s:form action="SelectCartAction">
				<s:submit value="カートへ" />
			</s:form>
			<s:if test="#session.id != null">
				<p>
					ログアウトする場合は<a href='<s:url action="LogoutAction" />'>こちら</a>
				</p>
			</s:if>
		</div>
	</div>
</body>
</html>